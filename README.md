# FootballInventory
Simple Spring Boot App 

## Local
Run app from intelij defaults to H2 in memory DB. Exposed on port 8080

## Endpoints
## Get All Jerseys
http://localhost:8080/football-api/jersey

## Delete
http://localhost:8080/football-api/jersey/{1977007}

Get all Jerseys:
```bash
curl -X GET  -H 'Accept: */*' http://localhost/football-api/jersey
```

Add a Jersey:
```bash
curl -X POST \
http://localhost/book-api/jersey \
-H 'Accept: */*' \
-H 'Content-Type: application/json' \
-d '{
    "team": "Everton",
    "size": "Xl",
    "color": "blue", 
}'
```

