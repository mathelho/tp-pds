export {}

describe('Banco de Filmes', () => {
    it('Successfully rates a movie', () => {
        cy.visit('/')

        cy.get('[alt="Poster do filme Demon Slayer - Mugen Train: O Filme"]').invoke('show')
            .click();

        cy.get('button').contains('Avaliar o filme').click();

        cy.get('[placeholder="Digite uma nota de 1 a 10..."]')
            .type('9.0');

        cy.get('button').contains('Enviar avaliação').click();

        cy.on('window:alert', str => {
            expect(str).to.equal('Filme avaliado!');
        })

    })

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

    it('Sucesfully search a movie and find it'), ()=> {
        cy.visit('/')

        cy.get('alt="Botão para filtrar/pesquisar filmes"').click();
        
        cy.get('placeholder="Busque pelo título..."').type('Coringa');

        cy.get('button').contains('Buscar').click()

        cy.contains('Coringa').should('be.visible');
    }
})