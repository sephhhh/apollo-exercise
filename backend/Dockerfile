FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN ./mvnw dependency:go-offline -B

COPY src ./src
RUN ./mvnw clean package -DskipTests -B

EXPOSE 8080
CMD ["java", "-jar", "target/exercise-0.0.1-SNAPSHOT.jar"]