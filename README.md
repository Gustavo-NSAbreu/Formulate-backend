# Run this application

## Required software

**You must have Docker and Docker Compose installed.**

## Required configuration

Before running the project, you must create a `docker-compose.yaml` in the folder where both the repositories that this project depends on are, like this:

```
formulate
|
|- docker-compose.yaml
|
|- formulate_backend
```

The content of the docker compose must be:

```yaml
services:
  formulate-database:
    image: 'postgres'
    container_name: 'formulate-database'
    restart: always
    shm_size: 128mb
    volumes:
      - formulate-database:/var/lib/postgresql
    environment:
      - 'POSTGRES_DB=formulate'
      - 'POSTGRES_PASSWORD=1234'
    ports:
      - 5432:5432
    networks:
      - formulate-backend-network

  formulate-backend:
    image: formulate-backend
    container_name: formulate-backend
    build: ./formulate_backend
    ports:
      - "8000:8000"
    networks:
      - formulate-backend-network

networks:
  formulate-backend-network:
    driver: bridge

volumes:
  formulate-database:
```

## Running

After setting up the file and repositories, run:

`docker compose up`

## Access the database

Run:

`docker exec -it postgres psql -h localhost -p 5432 -d formulate -U postgres`