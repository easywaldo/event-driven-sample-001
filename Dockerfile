# 1. 빌드 이미지 (Gradle 사용)
FROM gradle:8.2.1-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

# 2. 런타임 이미지
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/demo/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]