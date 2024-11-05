FROM gradle:8.6-jdk17 AS builder


WORKDIR /app


COPY . .


RUN gradle build -x test


FROM openjdk:17-jdk-slim


WORKDIR /app


COPY --from=builder /app/build/libs/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]