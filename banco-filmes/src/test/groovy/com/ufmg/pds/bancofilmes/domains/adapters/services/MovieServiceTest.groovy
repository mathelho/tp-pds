package com.ufmg.pds.bancofilmes.domains.adapters.services

import com.ufmg.pds.bancofilmes.domains.Movie
import com.ufmg.pds.bancofilmes.domains.ports.repositories.MovieRepositoryPort
import spock.lang.Specification

class MovieServiceTest extends Specification {
    MovieService movieService
    MovieRepositoryPort movieRepositoryPort = Mock()

    def setup() {
        movieService = new MovieService(movieRepositoryPort)
    }

    def "It should pass"() {
        given:

        when:
        movieService.listAll()

        then:
        1 * movieRepositoryPort.findAll() >> new ArrayList<Movie>()

        and:
        assert true
    }
}
