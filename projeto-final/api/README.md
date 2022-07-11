# Inicialização

## Build
Para realizar o processo de build, basta executar o seguinte comando

```
mvn clean install
```

## Banco de Dados
O sistema utiliza o Docker como ambiente virtual para Banco de Dados,
sendo assim é necessário ter o docker instalado em sua máquina.
Além disso, para subir esse ambiente, execute o seguinte comando:

```
docker-compose up -d
```

## Iniciar o projeto
A seguir execute o seguinte comando para subir o projeto

```
mvn spring-boot:run
```

Com isso o projeto será acessível na seguinte URL:

```
http://localhost:8080/agrotech
```

## Interface / Documentação
Para faciltar os testes, o projeto utiliza o Swagger como documentador.
Para acessá-lo basta usar a seguinte URL:

```
http://localhost:8080/agrotech/swagger-ui.html
```
