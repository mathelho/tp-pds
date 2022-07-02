package com.ufmg.pds.bancofilmes.infrastructure.mappers

import com.ufmg.pds.bancofilmes.domains.Movie
import com.ufmg.pds.bancofilmes.infrastructure.adapters.entities.MovieEntity
import org.apache.commons.lang3.ObjectUtils
import spock.lang.Specification

import static com.ufmg.pds.bancofilmes.mocks.MovieMock.createMovie
import static com.ufmg.pds.bancofilmes.mocks.MovieMock.createMovieEntity

class MovieEntityMapperTest extends Specification {
    void "It should convert a MovieEntity into a Movie"() {
        given:
        MovieEntity movieEntity = createMovieEntity()

        when:
        Movie convertedMovie = MovieEntityMapper.INSTANCE.toMovie(movieEntity)

        then:
        assert convertedMovie instanceof Movie

        assert convertedMovie.getId() == movieEntity.getId()
        assert convertedMovie.getScore() == movieEntity.getScore()
        assert convertedMovie.getTitle() == movieEntity.getTitle()
        assert convertedMovie.getDirector() == movieEntity.getDirector()
        assert convertedMovie.getImdbScore() == movieEntity.getImdbScore()
        assert convertedMovie.getSynopsis() == movieEntity.getSynopsis()
        assert convertedMovie.getGenres() == movieEntity.getGenres()
        assert convertedMovie.getWhereToWatch() == movieEntity.getWhereToWatch()
        assert convertedMovie.getImageUrl() == movieEntity.getImageUrl()
        assert convertedMovie.getAdvisoryRating() == movieEntity.getAdvisoryRating()
        assert convertedMovie.getReleaseYear() == movieEntity.getReleaseYear()
        assert convertedMovie.getNumberOfReviews() == movieEntity.getNumberOfReviews()
    }

    void "It should convert a null MovieEntity into a Movie"() {
        given:
        MovieEntity movieEntity = null

        when:
        Movie convertedMovie = MovieEntityMapper.INSTANCE.toMovie(movieEntity)

        then:
        assert ObjectUtils.isEmpty(convertedMovie)
    }

    void "It should convert a Movie into a MovieEntity"() {
        given:
        Movie movie = createMovie()

        when:
        MovieEntity convertedMovieEntity = MovieEntityMapper.INSTANCE.toMovieEntity(movie)

        then:
        assert convertedMovieEntity instanceof MovieEntity

        assert convertedMovieEntity.getId() == movie.getId()
        assert convertedMovieEntity.getScore() == movie.getScore()
        assert convertedMovieEntity.getTitle() == movie.getTitle()
        assert convertedMovieEntity.getDirector() == movie.getDirector()
        assert convertedMovieEntity.getImdbScore() == movie.getImdbScore()
        assert convertedMovieEntity.getSynopsis() == movie.getSynopsis()
        assert convertedMovieEntity.getGenres() == movie.getGenres()
        assert convertedMovieEntity.getWhereToWatch() == movie.getWhereToWatch()
        assert convertedMovieEntity.getImageUrl() == movie.getImageUrl()
        assert convertedMovieEntity.getAdvisoryRating() == movie.getAdvisoryRating()
        assert convertedMovieEntity.getReleaseYear() == movie.getReleaseYear()
        assert convertedMovieEntity.getNumberOfReviews() == movie.getNumberOfReviews()
    }

    void "It should convert a null Movie into a MovieEntity"() {
        given:
        Movie movie = null

        when:
        MovieEntity convertedMovieEntity = MovieEntityMapper.INSTANCE.toMovieEntity(movie)

        then:
        assert ObjectUtils.isEmpty(convertedMovieEntity)
    }
}
