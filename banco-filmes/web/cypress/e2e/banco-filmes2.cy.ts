export {}

describe('Banco de Filmes', () => {
    it('Succesfully adds movies to watch list and removes one of them', () => {
        cy.visit('/')

        cy.get('[alt="Poster do filme Coringa"]').invoke('show')
            .click();

        cy.get('p').contains('Add').click();

        cy.on('window:alert', str => {
            expect(str).to.equal('Adicionado na Watch List!');
        })

        cy.get('button').contains('Watch List').click();

        cy.contains('Coringa').should('be.visible');

        cy.get('[alt="Logo do Banco de Filmes"]').click();

        cy.get('[alt="Poster do filme Cidade de Deus"]').invoke('show')
            .click();

        cy.get('p').contains('Add').click();

        cy.get('button').contains('Watch List').click();

        cy.contains('Cidade de Deus').should('be.visible');

        cy.get('svg').get('#3').children().children('rect').click({force: true});

        cy.contains('Coringa').should('not.exist');
    })
})