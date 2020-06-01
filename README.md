<h1 align="center">Learning Management System</h1>

## Description

University of Los Angeles (ficitonal) management system.

## How to run

### Docker

#### Requiremets

- [Docker](https://docs.docker.com/get-docker/)
- [Docker-Compose](https://docs.docker.com/compose/install/)

#### Note

There are three docker-compose files, named after each enivornment.<br>
To run containers in development environment:
<br>
`$ docker-comopse -f docker-compose.yml up -d`<br>
To run containers in production environment: <br>
`$ docker-comopse -f docker-compose.prod.yml up -d`<br>

Containers: main_app_backend, main_app_frontend, mysql

If you don't want to write a -f docker-compose.yml everytime, just export env variable with<br>
`$ export COMPOSE_FILE=docker-compose.yml` <br>
Or add it to your .zshrc/.bashrc file and source it.

### Without docker

- Create new database and create an application.properties file based on example<br>
  @TODO

#### @Requirements

- Lombok

### Technologies

- SpringBoot
- Angular 9 with ngrx
- Sass
- MySQL
- MongoDB
- Python (code-generation)

### Design resources

[Figma project](https://www.figma.com/file/qc1DDLrPyskpR015t6c3Q1/University-of-Los-Angeles-LMS?node-id=0%3A1) <br>
[Figma prototype](https://www.figma.com/proto/qc1DDLrPyskpR015t6c3Q1/University-of-Los-Angeles-LMS?node-id=0%3A1)
