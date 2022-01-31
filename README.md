# Football Inventory Api
Simple Inventory app for a Football Shop to track Jerseys in stock 
the Application has endpoints for GET/POST/PUT/DELETE 

## Getting started
* git clone https://github.com/SeanONeillArdmore/FootballInventory.git
* run class FootballInventoryApplication in your IDE
* navigate to http://localhost:8080/swagger-ui/

##  Architecture
A Microservice architecture with REST APIs.

A Spring Boot application with a Rest Controller which communicates with 
the persistence layer using a service implementation which in turn communicates 
to the JPA through a DAO object.

## Endpoints  using curl

## Get All Jerseys
curl -X GET "http://localhost:8080/football-api/jersey" -H "accept: */*"


<img width="1440" alt="Screenshot 2022-01-31 at 17 04 04" src="https://user-images.githubusercontent.com/98542188/151843278-2e692616-7275-4e29-bc74-fedba94dcce1.png">

## Get Jersey based on specified Id!

curl -X GET "http://localhost:8080/football-api/jersey/2dd39629-e1bd-4777-ba08-a1f124bde93a" -H "accept: */*"

## Delete Jersey 
curl -X DELETE "http://localhost:8080/football-api/jersey/2dd39629-e1bd-4777-ba08-a1f124bde93a" -H "accept: */*"

## Post a Jersey:
curl -X POST "http://localhost:8080/football-api/jersey" -H "accept: */*" -H "Content-Type: application/json" -d "{\"color\":\"Blue\",\"jerseyId\":\"\",\"size\":\"XL\",\"team\":\"Chelsea\"}"

[Uploading Screenshot 2022-01-31 at 17.31.44.png…]()

## Update a Jersey
curl -X PUT "http://localhost:8080/football-api/jersey/8d752c07-b5c7-485b-a035-e104f7efa2bb" -H "accept: */*" -H "Content-Type: application/json" -d "{\"color\":\"White\",\"jerseyId\":\"\",\"size\":\"XS\",\"team\":\"Spurs\"}"



