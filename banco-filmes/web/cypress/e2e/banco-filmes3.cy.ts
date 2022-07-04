export {}

describe('Banco de Filmes', () => {
    it('Successfully search a movie and find it', () => {
        cy.visit('/')

        cy.get('[alt="Botão para filtrar/pesquisar filmes"]').click();
        
        cy.get('[placeholder="Busque pelo título..."]').type('Coringa');

        cy.get('button').contains('Buscar').click()

        cy.contains('Coringa').should('be.visible');
    })
})