# 1. 빌드 이미지 (Gradle 사용)
FROM gradle:8.7.0-jdk21 AS builder
WORKDIR /app

# Gradle Wrapper와 설정/의존 캐시 최적화
COPY gradlew gradle/ settings.gradle* build.gradle* gradle.properties /app/
RUN chmod +x ./gradlew

# 실제 모듈만 복사
COPY demo /app/demo

# demo 모듈에서 빌드
WORKDIR /app/demo
RUN ../gradlew --no-daemon clean build -x test

# 2. 런타임 이미지
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/demo/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]