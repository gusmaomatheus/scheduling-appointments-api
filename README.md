# Agendamento de Consultas Médicas 👨🏻‍⚕️

## Descrição ✍🏻

Um microserviço para agendar uma consulta para um paciente. A relação entre Paciente e Consulta é **1-N**, onde **um** paciente pode estar em **n** consultas, mas **uma** consulta só tem **um** paciente atrelado a ela.

## Tecnologias Utilizadas 💻

- [Spring Framework](https://spring.io/projects/spring-boot) 🍃
    - [Spring Web](https://docs.spring.io/spring-boot/docs/current/reference/html/web.html) 🕸️
    - [Spring Data JPA](https://spring.io/projects/spring-data) 🎲
    - [Spring Validation](https://docs.spring.io/spring-framework/reference/core/validation/beanvalidation.html) ✅
    - [Spring Security](https://docs.spring.io/spring-security/reference/index.html) 🔐
- [Maven](https://maven.apache.org/guides/index.html) 🪶
- [Docker](https://docs.docker.com/) 🐳
- [PostgreSQL](https://www.postgresql.org/docs/) 🐘
- [Flyway](https://flywaydb.org/postgresql) 🐦
- [Lombok](https://projectlombok.org/) 🌶
- [JWT Auth](https://jwt.io/introduction) 🎡


## Práticas Adotadas 🛠️

Ao desenvolver esta aplicação, foram seguidas algumas práticas fundamentais:

- **SOLID** 🏋️‍♂️: Princípios sólidos da programação orientada a objetos foram aplicados para garantir um design flexível e escalável.
  
- **DRY** 🌵: "Don't Repeat Yourself" foi seguido para evitar redundâncias no código, promovendo a reutilização e a manutenção eficiente.
  
- **YAGNI** 🤷‍♂️: "You Aren't Gonna Need It" foi mantido em mente para evitar o desenvolvimento de recursos que não são necessários no momento, mantendo o foco na simplicidade.
  
- **KISS** 💋: "Keep It Simple, Stupid" foi seguido para manter a simplicidade na implementação, facilitando a compreensão e a manutenção do código.

## Instação ⚙

1. Clonar o repositório:
    ```bash
    $ git clone git@github.com:gusmaomatheus/patient-scheduling.git
    ``` 

2. Instalar e iniciar o [Docker desktop](https://www.docker.com/products/docker-desktop/)

3. Instalar dependencias com o [Maven](https://maven.apache.org/guides/index.html)

## Como usar 🖥

1. Iniciar a aplicação com o [Maven](https://maven.apache.org/guides/index.html)

2. A API ficará disponível em [http://localhost:8080](http://localhost:8080)

## Como logar na aplicação 🔐
1. Acessar http://localhost:15432/login e logar no Postgre com as credenciais:
    - user: admin@admin.com
    - password: root

2. Inserir um usuário com permissões de administrador no Postgre executando o seguinte comando no query tool:

    ```sql
    INSERT INTO users VALUES(1, 'admin', 'admin', 0)
    ```

3. Depois faça um POST em http://localhost:8080/api/auth/login com o seguinte corpo:
    ```json
    {
        "login": "admin",
        "password": "admin"
    }
    ```
4. Com o token que ele irá gerar você poderá se autenticar na aplicação.
    
    Postman:

   
    ![postman-example](https://i.imgur.com/jqMOIpp.png)


## API Endpoints 🌐

A API fornece os seguintes endpoints:

## Auth 

### POST LOGIN

```
POST /api/auth/login - Autentifica o usuário e retorna seu token de login.
```

Exemplo:

```json
{
    "login": "admin",
    "password": "admin"
}
```

Resultado esperado (200 - Ok):

```json
{
    "token": "eyJhbGciOiJIuZi1nIisinR5cci6iKPxvcj9.eyjzdWIIOIIXmjm0nty30DKqweIktainnpvaFtZSI6IKG4.4pcPyMD09olPSyXnrXCjTwXyr4BsezdI1AVTmud2fU4"
}
```

### POST REGISTER

```
POST /api/auth/register - Cria um novo usuário.
```

Exemplo:

```json
{
    "login": "matheus",
    "password": "12345678",
    "role": "USER"
}
```

Resultado: (201 - Created)

```json
[]
```

## Patients

### POST PATIENT

```
POST /api/patient - Cria um novo paciente.
```

Exemplo:

```json
{
    "firstName": "Caio",
	"lastName": "Castro",
	"cpf": "62306962073",
	"email": "caio.castro@gmail.com"
}
```

Resultado esperado: (201 - Created)

```json
{
    "id": 1,
    "firstName": "Caio",
	"lastName": "Castro",
	"cpf": "623.069.620-73",
	"email": "caio.castro@gmail.com"
}
```

### GET PATIENTS

```
GET /api/patient - Retorna todos os pacientes registrados.
```

Resultado esperado (200 - Ok):

```json
[
    {
        "id": 1,
        "firstName": "Caio",
	    "lastName": "Castro",
	    "cpf": "623.069.620-73",
	    "email": "caio.castro@gmail.com"
    },
    {
        "id": 2,
        "firstName": "Matheus",
        "lastName": "Gusmão",
        "cpf": "862.379.190-82",
        "email": "gusmao.matheus@gmail.com"
    }
]
```

### GET PATIENT

```
GET /api/patient/{id} - Retorna um único paciente pelo seu id.
```

Resultado esperado (200 - Ok):

```json
{
    "id": 1,
    "firstName": "Caio",
	"lastName": "Castro",
	"cpf": "623.069.620-73",
	"email": "caio.castro@gmail.com"
}
```

### PUT PATIENT

```
PUT /api/patient/{id} - Edita alguma(s) informação(ões) de um usuário pelo seu id.
```

Exemplo:

```json
{
    "email": "castro.caio@gmail.com"
}
```

Resultado esperado (200 - Ok):

```json
{
    "id": 1,
    "firstName": "Caio",
	"lastName": "Castro",
	"cpf": "623.069.620-73",
	"email": "castro.caio@gmail.com"
}
```

### DELETE PATIENT

```
DELETE /api/patient/{id} - Deleta um usuário pelo seu id.
```

Resultado esperado (204 - No Content):

```json
[]
```

## Schedules

### POST SCHEDULE

```
POST /api/schedule - Cria uma nova consulta.
```

Exemplo:

```json
{
	"description": "Exame de vista",
	"date": "2023-11-25T16:19:04",
	"patientId": 1
}
```

Resultado esperado: (201 - Created)

```json
{
    "id": 1,
    "description": "Exame de vista",
    "date": "2023-11-25T16:19:04",
    "createdAt": "2023-11-19T17:16:11.220605",
    "patient": {
        "id": 1,
        "firstName": "Caio",
	    "lastName": "Castro",
	    "cpf": "623.069.620-73",
	    "email": "castro.caio@gmail.com"        
    } 
}
```

### GET SCHEDULES

```
GET /api/schedule - Retorna todas as consultas agendadas.
```

Resultado esperado (200 - Ok):

```json
[
    {
        "id": 1,
        "description": "Exame de vista",
        "date": "2023-11-25T16:19:04",
        "createdAt": "2023-11-19T17:16:11.220605",
        "patient": {
            "id": 1,
            "firstName": "Caio",
	        "lastName": "Castro",
	        "cpf": "623.069.620-73",
	        "email": "castro.caio@gmail.com"        
        } 
    },
    {
        "id": 2,
        "description": "Exame de coração",
        "date": "2023-11-22T16:19:04",
        "createdAt": "2023-11-14T17:16:11.220605",
        "patient": {
            "id": 2,
            "firstName": "Matheus",
            "lastName": "Gusmão",
            "cpf": "862.379.190-82",
            "email": "gusmao.matheus@gmail.com"    
        } 
    }
]
```

### GET SCHEDULE

```
GET /api/schedule/{id} - Retorna uma consulta pelo seu id.
```

Resultado esperado (200 - Ok):

```json
{
    "id": 1,
    "description": "Exame de vista",
    "date": "2023-11-25T16:19:04",
    "createdAt": "2023-11-19T17:16:11.220605",
    "patient": {
        "id": 1,
        "firstName": "Caio",
	    "lastName": "Castro",
	    "cpf": "623.069.620-73",
	    "email": "castro.caio@gmail.com"        
    } 
}
```

### PUT SCHEDULE

```
PUT /api/schedule/{id} - Edita alguma(s) informação(ões) de uma consulta pelo seu id.
```

Exemplo:

```json
{
    "description": "Exame de vista e de coração"
}
```

Resultado esperado (200 - Ok):

```json
{
    "id": 1,
    "description": "Exame de vista e de coração",
    "date": "2023-11-25T16:19:04",
    "createdAt": "2023-11-19T17:16:11.220605",
    "patient": {
        "id": 1,
        "firstName": "Caio",
	    "lastName": "Castro",
	    "cpf": "623.069.620-73",
	    "email": "castro.caio@gmail.com"        
    } 
}
```

### DELETE SCHEDULE

```
DELETE /api/schedule/{id} - Deleta uma consulta pelo seu id.
```

Resultado esperado (204 - No Content):

```json
[]
```
