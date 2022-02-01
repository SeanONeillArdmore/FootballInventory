# Football Inventory Api
Simple Inventory app for a Football Shop to track Jerseys in stock 
the Application has endpoints for GET/POST/PUT/DELETE 

## Getting started
* git clone https://github.com/SeanONeillArdmore/FootballInventory.git
* from command line execute: `mvn clean package` 
* navigate to http://localhost:8080/swagger-ui/

##  Architecture
A Microservice based application using RESTful APIs

Spring Boot application using in-memory h2 database

### Build as Java App

From Project Root Directory.

### Run as java app

- Build app using maven: `mvn clean -B package`. Output of this will be a Fat executable jar.
- Run app as jar, execute: `java -jar target/app.jar` 
- App available at localhost:8080

### Run as docker image

- Build app using maven: `mvn clean -B package`. Output of this will be a Fat executable jar.
- Build Docker Image: `docker build -t local/football-inventory -f docker/Dockerfile .`
- Run app as docker image, execute: `docker run --rm -p 9090:8080 -t local/football-inventory` 
- App available at localhost:9090 (or whatever host port specified.)

### GitHub Action workflow 
- Workflow that builds and tests every pull request to the repository

## API Endpoints 

## Get All Jerseys

```bash
curl -X GET "http://localhost:8080/football-api/jersey" -H "accept: */*"
```

<img width="1440" alt="Screenshot 2022-01-31 at 17 04 04" src="https://user-images.githubusercontent.com/98542188/151843278-2e692616-7275-4e29-bc74-fedba94dcce1.png">

## Get Jersey by Id

```bash
curl -X GET "http://localhost:8080/football-api/jersey/2dd39629-e1bd-4777-ba08-a1f124bde93a" -H "accept: */*"
```

![Screenshot 2022-01-31 at 17 47 39](https://user-images.githubusercontent.com/98542188/151845902-0491849e-7f8b-4f11-8039-7befd116ec5a.png)


## Delete Jersey 

```bash
curl -X DELETE "http://localhost:8080/football-api/jersey/2dd39629-e1bd-4777-ba08-a1f124bde93a" -H "accept: */*"
```

![Screenshot 2022-01-31 at 17 46 35](https://user-images.githubusercontent.com/98542188/151845648-dedc626f-3967-4117-a4d2-8e96faca1190.png)


## Add a Jersey:

```bash
curl -X POST "http://localhost:8080/football-api/jersey" -H "accept: */*" -H "Content-Type: application/json" -d "{\"color\":\"Blue\",\"jerseyId\":\"\",\"size\":\"XL\",\"team\":\"Chelsea\"}"
```

<img width="1440" alt="Screenshot 2022-01-31 at 17 31 44" src="https://user-images.githubusercontent.com/98542188/151845272-639a7d62-7e5d-449f-b886-e723f8988b72.png">


## Update a Jersey

```bash
curl -X PUT "http://localhost:8080/football-api/jersey/8d752c07-b5c7-485b-a035-e104f7efa2bb" -H "accept: */*" -H "Content-Type: application/json" -d "{\"color\":\"White\",\"jerseyId\":\"\",\"size\":\"XS\",\"team\":\"Spurs\"}"
```

![Screenshot 2022-01-31 at 17 45 38](https://user-images.githubusercontent.com/98542188/151845511-bb04a643-f8e9-4c86-a9ed-953681e29e34.png)


