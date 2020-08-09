<h1 align="center">Learning Management System</h1>

## Description
<h3>API Gateway Server</h3>
Every request will go thorugh this app and based on service discovery will route traffic to targeted service  
[Netflix Zuul Github Repository](https://github.com/Netflix/zuul)

#### Requirements

- Java 11
- Discovery Server (Netflix Eureka)

### Docker

Read [README.md](https://github.com/OMKE/ULA/blob/master/README.md) for instructions

### Without docker

In terminal:  
`$ mvn spring-boot:run`

It will fire up a server on port 8080 




