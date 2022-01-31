# Football Inventory Api
Simple Inventory app for a Football shop to track Jerseys in stock 
Api has endpoints for GET/POST/PUT/DELETE 

## Getting started
* git clone https://github.com/SeanONeillArdmore/FootballInventory.git
* run class FootballInventoryApplication in your IDE
* navigate to http://localhost:8080/swagger-ui/

##  Architecture
A Microservice architecture with REST APIs.

A Spring Boot application with a Rest Controller which communicates with 
the persistence layer using a service implementation which in turn communicates 
to the JPA through a DAO object.

## Endpoints 

## Get All Jerseys

curl -X GET "http://localhost:8080/football-api/jersey" -H "accept: */*"

![img.png](img.png)


## Delete Jersey 
http://localhost:8080/football-api/jersey/{1977007}

## Add a Jersey:


## Update a Jersey



