package com.ufmg.pds.bancofilmes.domains.adapters.services

import com.ufmg.pds.bancofilmes.domains.AdvisoryRatingEnum
import com.ufmg.pds.bancofilmes.domains.GenreEnum
import com.ufmg.pds.bancofilmes.domains.Movie
import com.ufmg.pds.bancofilmes.domains.WhereToWatchEnum
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePostRequestBodyDTO
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePutRequestBodyDTO
import com.ufmg.pds.bancofilmes.domains.dtos.RateMoviePostRequestBodyDTO
import com.ufmg.pds.bancofilmes.domains.mappers.MovieMapper
import com.ufmg.pds.bancofilmes.domains.ports.repositories.MovieRepositoryPort
import com.ufmg.pds.bancofilmes.exceptions.BadRequestException
import com.ufmg.pds.bancofilmes.exceptions.NotFoundException
import org.apache.commons.lang3.ObjectUtils
import spock.lang.Specification

import java.util.stream.IntStream

import static com.ufmg.pds.bancofilmes.mocks.MovieMock.*

class MovieServiceTest extends Specification {
    MovieService movieService
    MovieRepositoryPort movieRepositoryPort = Mock()

    def setup() {
        movieService = new MovieService(movieRepositoryPort)
    }

    def "it should return all Movies saved in data base successfully"() {
        given:
        Movie savedMovie0 = createMovie()
        Movie savedMovie1 = new Movie(
                2L,
                "Test",
                "Tester",
                0.0,
                8.0,
                "Test",
                List.of(GenreEnum.ACTION, GenreEnum.ADVENTURE, GenreEnum.FANTASY),
                List.of(WhereToWatchEnum.CRUNCHYROLL),
                "https://i.imgur.com/SrWGiOE.jpg",
                AdvisoryRatingEnum.QUATORZE,
                "2010",
                0)

        when:
        List<Movie> listOfMovie = movieService.listAll()

        then:
        1 * movieRepositoryPort.findAll() >> [savedMovie0, savedMovie1]

        and: 'validate the method return'
        assert ObjectUtils.isNotEmpty(listOfMovie)
        assert listOfMovie.size() == 2

        assert listOfMovie.get(0) == savedMovie0
        assert listOfMovie.get(1) == savedMovie1
    }

    def "it should return an emptyList when there is no Movies saved in data base"() {
        when:
        List<Movie> listOfMovie = movieService.listAll()

        then:
        1 * movieRepositoryPort.findAll() >> []

        and: 'validate the method return'
        assert ObjectUtils.isEmpty(listOfMovie)
    }

    def "it should return an Movie based on the given id"() {
        given:
        Movie savedMovie = createMovie()
        Long id = 1L

        when:
        Movie expectedMovie = movieService.findById(id)

        then:
        1 * movieRepositoryPort.findById(id) >> Optional.of(savedMovie)

        and:
        assert ObjectUtils.isNotEmpty(expectedMovie)

        assert expectedMovie == savedMovie
    }

    def "it should throw a NotFoundException when id is not found in data base"() {
        given:
        String expectedMessage = "Movie with id 42 not found"
        Long id = 42L

        when:
        movieService.findById(id)

        then:
        movieRepositoryPort.findById(id) >> Optional.empty()

        and:
        NotFoundException exception = thrown(NotFoundException)
        assert exception.getMessage() == expectedMessage
    }

    def "it should return an Movie in data base based on the title"() {
        given:
        String MovieName = "Sailor Moon"
        Movie savedMovie1 = createMovie(2L, MovieName, 9.0)

        when:
        Movie listOfMovie = movieService.findByTitle(MovieName)

        then:
        1 * movieRepositoryPort.findByTitle(MovieName) >> Optional.of(savedMovie1)

        and: 'validate the method return'
        assert ObjectUtils.isNotEmpty(listOfMovie)

        assert listOfMovie == savedMovie1
    }

    def "it should throw a NotFoundException when trying to get an Movie title not in the data base"() {
        given:
        String expectedMessage = "Movie Sailor Moon not found"
        String MovieName = "Sailor Moon"

        when:
        movieService.findByTitle(MovieName)

        then:
        movieRepositoryPort.findByTitle(MovieName) >> Optional.empty()

        and:
        NotFoundException exception = thrown(NotFoundException)
        assert exception.getMessage() == expectedMessage
    }

    def "it should save an Movie in data base successfully"() {
        given:
        Movie savedMovie0 = createMovie()
        MoviePostRequestBodyDTO moviePostRequestBodyDTO = createMoviePostRequestBody()

        when:
        Movie movie = movieService.save(moviePostRequestBodyDTO)

        then:
        1 * movieRepositoryPort.save(_) >> savedMovie0

        and: 'validate Movie value and the return method'
        assert ObjectUtils.isNotEmpty(movie)
        assert movie == savedMovie0

    }

    def "it should save a batch of movies in data base successfully"() {
        given:
        String MovieName1 = "Sailor Moon"
        MoviePostRequestBodyDTO moviePostRequest1 = createMoviePostRequestBody(MovieName1, 9.0, "1994")
        Movie savedMovie1 = MovieMapper.INSTANCE.moviePostRequestBodyDTOToMovie(moviePostRequest1)
        String MovieName2 = "Demon Slayer"
        MoviePostRequestBodyDTO moviePostRequest2 = createMoviePostRequestBody(MovieName2, 7.0, "2020")
        Movie savedMovie2 = MovieMapper.INSTANCE.moviePostRequestBodyDTOToMovie(moviePostRequest2)

        List<MoviePostRequestBodyDTO> listOfPostRequestMovies = [moviePostRequest1, moviePostRequest2]
        List<Movie> listOfMovies = [savedMovie1, savedMovie2]

        when:
        List<Movie> listOfSavedMovies = movieService.saveInBatch(listOfPostRequestMovies)

        then:
        1 * movieRepositoryPort.save(_) >> savedMovie1
        1 * movieRepositoryPort.save(_) >> savedMovie2

        and: 'validate Movie value and the return method'
        assert ObjectUtils.isNotEmpty(listOfSavedMovies)
        assert listOfSavedMovies == listOfMovies

    }

    def "it should delete an Movie that was saved in data base successfully"() {
        given:
        Long id = 2L
        Movie savedMovie1 = createMovie(id, "Sailor Moon", 9.0)

        when:
        List<Movie> listOfMovie = movieService.delete(id)

        then:
        1 * movieRepositoryPort.findById(id) >> Optional.of(savedMovie1)
        assert ObjectUtils.isEmpty(listOfMovie)
    }

    def "it should throw an NotFoundException when trying to delete an nonexistent Movie"() {
        given:
        Long id = 2L
        String expectedMessage = "Movie with id 2 not found"

        when:
        List<Movie> listOfMovie = movieService.delete(id)

        then:
        1 * movieRepositoryPort.findById(id) >> Optional.empty()

        and: 'Assert that the exception is being throw'
        NotFoundException exception = thrown(NotFoundException)
        assert exception.getMessage() == expectedMessage
        assert ObjectUtils.isEmpty(listOfMovie)
    }

    def "it should call the clear method"() {
        when:
        movieService.clear()

        then: "it tests if the method was successfully called one time"
        1 * movieRepositoryPort.clear()
    }

    def "it should replace an previously added Movie successfully"() {
        given:
        Long id = 1L
        Movie savedMovie0 = createMovie()
        MoviePutRequestBodyDTO moviePutRequestBodyDTO = createMoviePutRequestBody()

        when:
        List<Movie> listOfMovie = movieService.replace(moviePutRequestBodyDTO)

        then:
        1 * movieRepositoryPort.findById(id) >> Optional.of(savedMovie0)
        1 * movieRepositoryPort.save(_) >> savedMovie0
        assert ObjectUtils.isEmpty(listOfMovie)
    }

    def "it should throw an error when trying to replace an nonexistent Movie"() {
        given:
        String expectedExceptionMessage = "Movie with id 1 not found"
        Long id = 1L
        MoviePutRequestBodyDTO moviePutRequestBodyDTO = createMoviePutRequestBody()

        when:
        List<Movie> listOfMovie = movieService.replace(moviePutRequestBodyDTO)

        then:
        1 * movieRepositoryPort.findById(id) >> Optional.empty()
        assert ObjectUtils.isEmpty(listOfMovie)

        and: 'Assert that the exception is being throw'
        NotFoundException exception = thrown(NotFoundException)
        assert exception.getMessage() == expectedExceptionMessage
    }

    def "it should return the top ten Movie ordered by score successfully"() {
        given:
        def numberOfMoviesInDataBase = 10
        def Movies = createOrderedMovieList(numberOfMoviesInDataBase, "desc")

        when:
        List<Movie> topTenMovies = movieService.getTopTen()

        then:
        1 * movieRepositoryPort.getTopTen() >> Movies

        and:
        assert ObjectUtils.isNotEmpty(topTenMovies)
        assert topTenMovies.size() == 10
        assert isScoreDescOrdered(topTenMovies)
    }

    def "it should rate a Movie with succcess"() {
        given:
        Movie savedMovie = createMovie()
        Long id = 1L

        when:
        Movie expectedMovie = movieService.findById(id)

        then:
        1 * movieRepositoryPort.findById(id) >> Optional.of(savedMovie)

        and:
        assert ObjectUtils.isNotEmpty(expectedMovie)

        assert expectedMovie == savedMovie
    }

    def "it should throw a BadRequestException when rate is lower than 1.0"() {
        given:
        RateMoviePostRequestBodyDTO rate = createRateMoviePostRequestBody(0.9)
        def expectedMessage = "Movie score should be between 1 and 10"

        when:
        movieService.rate(rate)

        then:
        BadRequestException exception = thrown(BadRequestException)
        assert exception.getMessage() == expectedMessage
    }

    def "it should throw a BadRequestException when rate is bigger than 10.0"() {
        given:
        RateMoviePostRequestBodyDTO rate = createRateMoviePostRequestBody(10.1)
        def expectedMessage = "Movie score should be between 1 and 10"

        when:
        movieService.rate(rate)

        then:
        BadRequestException exception = thrown(BadRequestException)
        assert exception.getMessage() == expectedMessage
    }

    def "it should rate a movie successfully"() {
        given:
        Double score = 10.0
        RateMoviePostRequestBodyDTO rate = createRateMoviePostRequestBody(score)
        Movie savedMovie = createMovie()

        when:
        Movie returnedMovie = movieService.rate(rate)

        then:
        1 * movieRepositoryPort.findById(1L) >> Optional.of(savedMovie)
        1 * movieRepositoryPort.save(savedMovie) >> savedMovie

        and:
        assert ObjectUtils.isNotEmpty(returnedMovie)
        assert ObjectUtils.isNotEmpty(savedMovie.getScore())
        assert savedMovie.getScore() == score
    }

    // MARK: Auxiliar function
    static List<Movie> createOrderedMovieList(int numberOfMovies, String order) {
        def movies = new ArrayList()
        IntStream.range(0, numberOfMovies).forEach(index -> {
            Double score = index % 9 + 1.5
            def movie = createMovie(index, "Movie " + index.toString(), score)
            movies.add(movie)
        })
        if (order.toLowerCase() == "asc") {
            return movies.sort((Movie a, Movie b) -> a.getScore() <=> b.getScore()) as List<Movie>
        }
        return movies.sort((Movie a, Movie b) -> b.getScore() <=> a.getScore()) as List<Movie>
    }

    private static boolean isScoreDescOrdered(List<Movie> movies) {
        boolean isOrdered = true
        Movie position = movies.get(0)

        for (Movie movie : movies) {
            isOrdered = movie.getScore() <= position.getScore() && isOrdered
            position = movie
        }

        return isOrdered
    }
}
