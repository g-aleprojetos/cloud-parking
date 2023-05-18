# cloud-parking

## swagger
http://localhost:8080/swagger-ui.html#/

## Run database
```bash
docker run --name parking-db -p 5432:5432 -e POSTGRES_DB=parking -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123 -d postgres:10-alpine
```

## Stop database
```bash
docker stop parking-db
```

## Start database
````bash
docker start parking-db
````
