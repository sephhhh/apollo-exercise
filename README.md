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
- Spring Data JPA + Hibernate
- PostgreSQL
- Maven
- JUnit 5 + Spring Test + MockMvc

### Frontend

- Angular 21
- TypeScript
- Reactive forms

## How to Run Everything from the Terminal

```bash
# 1. Start the backend (from project root folder)
./mvnw spring-boot:run
# → API runs on http://localhost:8080

# 2. In a new terminal tab – start the frontend
cd frontend
npm install          # first time only
ng serve
# → Frontend runs on http://localhost:4200
```

## How to Run Tests

```bash
# Run all backend tests
./mvnw test

# Expected result:
# Tests run: 16, Failures: 0, Errors: 0, Skipped: 0
# BUILD SUCCESS
```



