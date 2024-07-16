# Forum Hub

Forum Hub é uma aplicação de fórum desenvolvida em Java, utilizando Spring Boot, JPA, Flyway, MySQL, Lombok, JWT e Spring Security. Este projeto tem como objetivo criar um fórum robusto e seguro para a criação, gerenciamento e discussão de tópicos.

## Funcionalidades

- **Autenticação e Autorização**: Implementado com JWT e Spring Security.
- **CRUD de Usuários**: Cadastro, atualização, remoção e listagem de usuários.
- **CRUD de Tópicos**: Criação, atualização, remoção e listagem de tópicos.
- **CRUD de Respostas**: Criação, atualização, remoção e listagem de respostas.

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal para a construção da aplicação.
- **Spring Data JPA**: Para persistência e gerenciamento de dados.
- **Spring Security**: Para segurança e gerenciamento de autenticação/autorização.
- **Flyway**: Para versionamento e migração de banco de dados.
- **MySQL**: Banco de dados relacional utilizado.
- **Lombok**: Para reduzir a verbosidade do código Java.
- **JWT (JSON Web Token)**: Para autenticação segura.
- **Maven**: Para gerenciamento de dependências e build.

## Estrutura do Projeto

```
src
 └── main
     └── java
         └── me.sloowy.forumhub
             ├── controller
             │   ├── AnswerController.java
             │   ├── AuthController.java
             │   ├── CourseController.java
             │   ├── ProfileController.java
             │   ├── TopicController.java
             │   └── UserController.java
             ├── domain
             │   ├── answer
             │   ├── course
             │   ├── profile
             │   ├── topic
             │   │   ├── dto
             │   │   ├── validation
             │   │   ├── StatusType.java
             │   │   ├── Topic.java
             │   │   ├── TopicRepository.java
             │   │   └── TopicService.java
             │   └── user
             │       ├── dto
             │       ├── validation
             │       ├── User.java
             │       ├── UserRepository.java
             │       └── UserService.java
             ├── infra
             │   ├── auth
             │   │   ├── TokenJwtDTO.java
             │   │   └── TokenService.java
             │   └── ForumhubApplication.java
 └── resources
     └── db
         └── migration
```

## Como Executar

1. Clone o repositório:
    ```sh
    git clone https://github.com/seu-usuario/forum-hub.git
    ```

2. Navegue até o diretório do projeto:
    ```sh
    cd forum-hub
    ```

3. Configure o banco de dados no arquivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
    spring.datasource.username=seu-usuario
    spring.datasource.password=sua-senha
    spring.jpa.hibernate.ddl-auto=update
    spring.flyway.enabled=true
    ```

4. Execute o projeto:
    ```sh
    mvn spring-boot:run
    ```

5. Acesse a aplicação em:
    ```
    http://localhost:8080
    ```
