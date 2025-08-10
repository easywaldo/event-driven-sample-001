# 1. 빌드 이미지 (Gradle 사용)
FROM gradle:8.7.0-jdk21 AS builder
WORKDIR /app

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

# demo 모듈에서 빌드
# WORKDIR /app/demo
# RUN ../gradlew --no-daemon clean build -x test

# 2. 런타임 이미지
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/demo/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]