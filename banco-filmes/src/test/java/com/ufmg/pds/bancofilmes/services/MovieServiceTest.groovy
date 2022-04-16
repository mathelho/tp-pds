package com.ufmg.pds.bancofilmes.services

import com.ufmg.pds.bancofilmes.domains.Movie
import spock.lang.Specification

class MovieServiceTest extends Specification {
    MovieServiceWithoutDB movieService

    def setup() {
        movieService = new MovieServiceWithoutDB()
    }

    def "It should test"() {
        given:
        def movie1 = new Movie(1L, "Interstellar", "Christopher Nolan", 9)
        def movie2 = new Movie(2L, "Batman Begins", "Christopher Nolan", 8.8)


        when:
        def movies = movieService.findAll()

        then:
        assert !movies.isEmpty()

        and: 'validate the response'
        assert movies.get(0) == movie1
        assert movies.get(1) == movie2
    }
}
