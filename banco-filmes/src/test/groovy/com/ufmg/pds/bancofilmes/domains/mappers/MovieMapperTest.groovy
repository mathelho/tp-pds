package com.ufmg.pds.bancofilmes.domains.mappers

import com.ufmg.pds.bancofilmes.domains.Movie
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePostRequestBodyDTO
import com.ufmg.pds.bancofilmes.domains.dtos.MoviePutRequestBodyDTO
import org.apache.commons.lang3.ObjectUtils
import spock.lang.Specification

import static com.ufmg.pds.bancofilmes.mocks.MovieMock.createMoviePostRequestBody
import static com.ufmg.pds.bancofilmes.mocks.MovieMock.createMoviePutRequestBody

class MovieMapperTest extends Specification {
    void "It should convert a MoviePostRequestBodyDTO into a Movie"() {
        given:
        MoviePostRequestBodyDTO moviePostRequestBodyDTO = createMoviePostRequestBody()

        when:
        Movie convertedMovie = MovieMapper.INSTANCE.moviePostRequestBodyDTOToMovie(moviePostRequestBodyDTO)

        then:
        assert convertedMovie instanceof Movie

        assert ObjectUtils.isEmpty(convertedMovie.getId())
        assert ObjectUtils.isEmpty(convertedMovie.getScore())
        assert ObjectUtils.isEmpty(convertedMovie.getNumberOfReviews())

        assert convertedMovie.getTitle() == moviePostRequestBodyDTO.getTitle()
        assert convertedMovie.getDirector() == moviePostRequestBodyDTO.getDirector()
        assert convertedMovie.getImdbScore() == moviePostRequestBodyDTO.getImdbScore()
        assert convertedMovie.getSynopsis() == moviePostRequestBodyDTO.getSynopsis()
        assert convertedMovie.getGenres() == moviePostRequestBodyDTO.getGenres()
        assert convertedMovie.getWhereToWatch() == moviePostRequestBodyDTO.getWhereToWatch()
        assert convertedMovie.getImageUrl() == moviePostRequestBodyDTO.getImageUrl()
        assert convertedMovie.getAdvisoryRating() == moviePostRequestBodyDTO.getAdvisoryRating()
        assert convertedMovie.getReleaseYear() == moviePostRequestBodyDTO.getReleaseYear()
    }

    void "It should convert a null MoviePostRequestBodyDTO into a Movie"() {
        given:
        MoviePostRequestBodyDTO moviePostRequestBodyDTO = null

        when:
        Movie convertedMovie = MovieMapper.INSTANCE.moviePostRequestBodyDTOToMovie(moviePostRequestBodyDTO)

        then:
        assert ObjectUtils.isEmpty(convertedMovie)
    }

    void "It should convert a MoviePutRequestBodyDTO into a Movie"() {
        given:
        MoviePutRequestBodyDTO moviePutRequestBodyDTO = createMoviePutRequestBody()

        when:
        Movie convertedMovie = MovieMapper.INSTANCE.moviePutRequestBodyDTOToMovie(moviePutRequestBodyDTO)

        then:
        assert convertedMovie instanceof Movie

        assert ObjectUtils.isEmpty(convertedMovie.getScore())
        assert ObjectUtils.isEmpty(convertedMovie.getNumberOfReviews())

        assert convertedMovie.getId() == moviePutRequestBodyDTO.getId()
        assert convertedMovie.getTitle() == moviePutRequestBodyDTO.getTitle()
        assert convertedMovie.getDirector() == moviePutRequestBodyDTO.getDirector()
        assert convertedMovie.getImdbScore() == moviePutRequestBodyDTO.getImdbScore()
        assert convertedMovie.getSynopsis() == moviePutRequestBodyDTO.getSynopsis()
        assert convertedMovie.getGenres() == moviePutRequestBodyDTO.getGenres()
        assert convertedMovie.getWhereToWatch() == moviePutRequestBodyDTO.getWhereToWatch()
        assert convertedMovie.getImageUrl() == moviePutRequestBodyDTO.getImageUrl()
        assert convertedMovie.getAdvisoryRating() == moviePutRequestBodyDTO.getAdvisoryRating()
        assert convertedMovie.getReleaseYear() == moviePutRequestBodyDTO.getReleaseYear()
    }

    void "It should convert a null MoviePutRequestBodyDTO into a Movie"() {
        given:
        MoviePutRequestBodyDTO moviePutRequestBodyDTO = null

        when:
        Movie convertedMovie = MovieMapper.INSTANCE.moviePutRequestBodyDTOToMovie(moviePutRequestBodyDTO)

        then:
        assert ObjectUtils.isEmpty(convertedMovie)
    }
}
