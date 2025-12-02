# Vehicle Management API

## Features

- Full CRUD for vehicles
- Strict input validation:
    - `400 Bad Request` for malformed JSON
    - `422 Unprocessable Entity` for missing fields, invalid values

## Tech Stack

### Backend

- Java 21
- Spring Boot 4
- PostgreSQL
- Maven
- JUnit 5 + Spring Test + MockMvc

### Frontend

- Angular 21
- TypeScript
- Reactive forms

## How to Run Everything from the Terminal

```bash
# 1. Create/Start the Database
cd backend
docker compose up vehicles-db

# 2. In a new terminal tab - start the backend from project backend folder
cd backend
./mvnw spring-boot:run
# → API runs on http://localhost:8080

# 3. In a new terminal tab – start the frontend from the frontend folder
cd frontend
npm install
ng serve
# → Frontend runs on http://localhost:4200
```

## How to Run Tests

```bash
# Run all backend tests
cd backend
./mvnw test

# Expected result:
# Tests run: 16, Failures: 0, Errors: 0, Skipped: 0
# BUILD SUCCESS
```



