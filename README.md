
# Projeto Intensivão Java Spring
## DSList
Este projeto é uma API RESTful desenvolvida durante o curso "Intensivão Java Spring" da DevSuperior. Ele serve para o gerenciamento de uma lista de jogos, permitindo operações como listagem, busca detalhada e manipulação da ordem dos jogos em listas.

## Tecnologias Utilizadas
O projeto foi desenvolvido com as seguintes tecnologias:
- Java 17
- Spring Boot: Framework para desenvolvimento de aplicações Java.
- JPA / Hibernate: Para persistência de dados e mapeamento objeto-relacional.
- Maven: Ferramenta de automação de build e gerenciamento de dependências.
- Docker: Utilizado para hospedar o banco de dados, facilitando a configuração do ambiente.
- Postgres: O banco de dados relacional usado dentro do contêiner Docker para armazenar as informações dos jogos e listas.

### Como Rodar o Projeto

## Funcionalidades
### API Endpoints
A API oferece os seguintes endpoints:
```
GET /games  - Listagem de Jogos Cadastrados:
GET /games/{id}  Buscar Jogo por ID , (onde {id} é o ID do jogo)
GET /lists Listagem das Listas de Jogos Cadastradas
GET /lists/{id}/games  Buscar Listagem de Jogos por ID da Lista ,  (onde {id} é o ID da lista)
POST /lists/{id}/replacement Mudar a Posição do Jogo dentro de uma Lista de Jogos  (onde {id} é o ID da lista)
Corpo da Requisição (Body): ReplacementDTO contendo informações da posição de origem e destino.


```


### Pré-requisitos: Certifique-se de ter o Java Development Kit (JDK) 17 ou superior e o Maven instalados em sua máquina.

### Clonar o Repositório

  ```bash
    git clone https://github.com/FelipePincg/dslist.git
  ```
### Navegar até o Diretório do Projeto
  ```bash
    cd dslist
  ```
### Configurar e Iniciar o Banco de Dados com Docker:
 - Crie um arquivo docker-compose.yml (ou configure diretamente via comandos Docker) para o PostgreSQL, garantindo que as variáveis de ambiente (usuário, senha, nome do banco) correspondam às configurações do seu application.properties no Spring Boot.
 - Exemplo de docker-compose.yml:
```YAML
  services:
  # ====================================================================================================================
  # POSTGRES SERVER
  # ====================================================================================================================
  pg-docker:
    image: postgres:14-alpine
    container_name: dev-postgresql
    environment:
      POSTGRES_DB: mydatabase
      POSTGRES_USER: your_user
      POSTGRES_PASSWORD: your_password
    ports:
      - 5433:5432
    volumes:
      - ./.data/postgresql/data:/var/lib/postgresql/data
    networks:
      - dev-network
  # ====================================================================================================================
  # PGADMIN
  # ====================================================================================================================
  pgadmin-docker:
    image: dpage/pgadmin4
    container_name: dev-pgadmin
    environment:
      PGADMIN_DEFAULT_EMAIL: me@example.com
      PGADMIN_DEFAULT_PASSWORD: your_password
    ports:
      - 5050:80
    volumes:
      - ./.data/pgadmin:/var/lib/pgadmin
    depends_on:
      - pg-docker
    networks:
      - dev-network
# ======================================================================================================================
# REDE
# ======================================================================================================================
networks:
  dev-network:
    driver: bridge

```

Lembre-se de substituir your_user e your_password pelas suas credenciais.

- Inicie o contêiner Docker:
  
```
  docker-compose up -d
```


### Compilar e Rodar o Projeto
  ```bash
    ./mvnw spring-boot:run
  ```

O projeto será iniciado e a API estará disponível em http://localhost:8080/dslist/ por padrão (ou outra porta configurada).


