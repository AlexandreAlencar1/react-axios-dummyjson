
# Loja XXX
Projeto de uma loja, utilizado para aprimorar conceitos que adquiri na faculdade e em cursos onnline.

Funcionamento:

Ao executar o código, os produtos da API https://dummyjson.com/ são consumidos e salvos no banco de dados escolhido. Posteriormente, esses produtos podem ser consumidos pelo frontend.

No frontend, os clientes têm a opção de se registrar. No entanto, este é apenas o começo do projeto.

# Backend do Projeto

## Descrição
Este projeto é uma aplicação backend desenvolvida em Spring Boot 3.1.3, utilizando Lombok, Hibernate e JPA. Ele implementa operações CRUD e API RESTfull, seguindo padrões de desenvolvimento como Clean Code e MVC, além de fazer uso de versionamento com Git.

# Instalação


## Banco de Dados
Você pode escolher entre usar um banco de dados PostgreSQL local (instalado em seu computador) ou MySQL via Docker para este projeto.

### Docker (Recomendado)
Este projeto está configurado para uso com Docker. Siga os passos abaixo para executá-lo:

1. Navegue até a pasta `spring/`.

2. Execute o seguinte comando para iniciar o contêiner Docker:
```bash
docker-compose up
```

### PostgreSQL (Local)

Se preferir usar o PostgreSQL localmente, siga estas etapas:

Comente a parte do arquivo application.properties relacionada ao Docker MySQL.

Remova o comentário do Postgresql no arquivo application.properties e utilize localmente.

### Backend

1. Abra o arquivo `SpringbootApplication.java` e clique em `run` para iniciar o backend.

### Frontend

1. No terminal, navegue até a pasta `frontend/`.
2. Para iniciar o frontend:
 ```bash
npm start
```

Aproveite o projeto!
# Futuras Implementações:
Estamos planejando estilizar o projeto e adicionar as seguintes funcionalidades:

Opção de adicionar produtos ao carrinho.
Opção de comprar produtos.
Finalização do carrinho.
Histórico de pedidos.
Implementação de validações.
Utilização do Spring Security para melhorar a segurança da aplicação.
Fique atento para futuras atualizações e melhorias neste projeto!