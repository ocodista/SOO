# Inicialização

## Docker
Para roda a aplicação, é necessário ter Docker instalado em seu computador.  

Para iniciar todas as aplicações, rode

```
docker-compose up -d
```
## Banco de Dados
Ele estará rodando em um container chamado database e também é acessível através do localhost:3306

## API
Após iniciar o projeto, é possível consumir a API Rest através da seguinte URL:

```
http://localhost:8080/agrotech
```

## Interface / Documentação
Para faciltar os testes, o projeto utiliza o Swagger como documentador.
Para acessá-lo basta usar a seguinte URL:

```
http://localhost:8080/agrotech/swagger-ui.html
```

## Testes
Para rodar os testes, rode

```
cd api
mvn clean test
```