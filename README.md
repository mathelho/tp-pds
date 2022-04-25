# Banco de Filmes

O objetivo do sistema é fornecer informações sobre os mais diversos filmes na indústria.
Pretendemos criar um banco de dados no Backend que fornece informações como Gênero de
filmes, notas gerais (iMDB), classificação indicativa, sugestão de filme pra “assistir agora” e
afins. Iremos ainda criar testes unitários para todo o sistema, buscando um coverage de 80%
no minimo enquanto dividirmos as subtasks entre os componentes da equipe.

- Linguagem: Java
- Foco: Backend
- Backlog Básico: [TP de PDS | Trello](https://trello.com/invite/b/EOYUriw7/043fc864e7947228dec9c58ca784468c/tppdsalternativobacklogeafins)
- Figma: [BancoDeFilmes](https://www.figma.com/file/n67ExnIeSd5CPKFcjz1h5m/BancoDeFilmes?node-id=0%3A1)

## Funções dos membros

- Felipe Matheus Guimarães dos Santos: Arquiteto/Dev, responsável pelo refinamento e Implementação;
- Celso Junio Simões de Oliveira Santos: Dev/QA, responsável por implementação, testes e quality;
- Matheus Ferreira Coelho: Dev/UX, responsável pelo Banco de dados, retorno visual e implementação;
- Natan: Dev/Analista, responsável por Implementação, Banco de dados e testes.

## Requisitos:

Para começar a utilizar Banco de filmes é necessário atendes a alguns pré requisitos básicos que apresentaremos a seguir:
- Instalar JDK na versão 17;
- Instalar a IDE IntelliJ (Opcional, para visualizar o código)
- Instalar o Maven
- Instalar Docker
- Instalar MySQL
- Instalar Workbench
- Instalar Postman

Após instalar as ferramentas necessárias você estará apto a utilizar o sistema de forma completa. ( Ou não, necessário verificar a necessidade
de construir um HOW TO, explicando como setar todas as variáveis necessárias e organizar o ambiente para que o usuário consiga efetivamente utiliza-lo)

## Step-bystep
- Para rodar o sistema pela primeira vez, execute um "docker-compose-up" estando no diretório tp-pds/banco-filmes
- Após, execute um mvn clean install
- Então rode o projeto no IntelliJ para colocar o host online;
- Importe o arquivo JSON dentro do diretório "collection" no nosso projeto para o Postman, e então, use as funções que já desenvolvemos até então.

## Possível MVP

Para nosso MVP, planejamos colocar o sistema já funcional com aproximadamente 5 funcionalidades básicas no backEnd, com um frontEnd já funcional contendo aproximadamente 5 telas. Ainda,
este será um MVP do tipo Protótipo.

### Funcionalidades:
 - findByName: Retorna certas informações sobre um filme tais como o Diretor do mesmo, seu Nome e sua Nota.
 - listAll: Comando para listar todos os fiulmes que teremos adicionados ao banco;
 - save: Comando para realizar um post no BackEnd para salvar um filme no Banco;
 - delete: Comando para deletar um filme salvo no banco, sendo este filme definido pelo seu 'id';
 - replace: Atualiza uma entrada do banco com as informações enviadas, através do ID daquela entrada;

### Front
Para o frontEnd pretendemos construir 5 telas que estão diretamente relacionadas as nossas funções implementadas no Back.
São elas:
- Tela Inicial: Contendo uma preview com os filmes obtidos através do listAll;
- Tela de Filtro/Pesquisa: Inicialmente irá utilizar somente a função de 'findByName' que implementaremos e então, podemos adicionar outros filmes se houver tempo hábil;
- Tela de Ranking: Contendo um ranking com os filmes mais bem avaliados no nosso sistema <função a definir>;
- Tela do Filme: Contendo informações como sinopses, notas, onde assistir e afins; através da função 'findByName'
- Tela de Review/Avaliações: Contendo campos para entradas de notas dos usuários sobre os filmes;

Queremos demonstrar como seria o funcionamento básico do sistema a partir dessas funcionalidades implementadas, dando a visão e já explicando
que diversas outras funcionalidades seriam implementadas caso a idéia estivesse boa, podendo claor, ocorrer diversas alterações no sistema
inteiro.
