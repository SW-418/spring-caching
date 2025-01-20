FROM openjdk:21-jdk-slim AS build

WORKDIR /app

COPY src ./src

COPY gradlew .
COPY gradlew.bat .
COPY gradle ./gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .

RUN ./gradlew clean build -x test

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=build /app/build/libs/spring-caching-1.0.0.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
