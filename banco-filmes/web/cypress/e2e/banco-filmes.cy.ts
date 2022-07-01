export {}

describe('Banco de Filmes', () => {
    it('successfully loads', () => {
        cy.visit('/')

        cy.get('[alt="Poster do filme Demon Slayer - Mugen Train: O Filme"]').click();

        cy.get('button').contains('Avaliar o filme').click();

        cy.get('[placeholder="Digite uma nota de 1 a 10..."]')
            .type('9.0');

        cy.get('button').contains('Enviar avaliação').click();

        cy.on('window:alert', str => {
            expect(str).to.equal('Filme avaliado!');
        })

    })
})