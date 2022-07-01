export {}

describe('Banco de Filmes', () => {
    it('successfully loads', () => {
        cy.visit('/')

        cy.get('[alt="Poster do filme Demon Slayer - Mugen Train: O Filme"]').click();
    })
})