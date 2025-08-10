# 1) 빌드 스테이지
FROM gradle:8.7.0-jdk21 AS builder
WORKDIR /app
# 필요한 파일만 먼저 복사(캐시 최적화)
COPY build.gradle* settings.gradle* gradle.properties gradlew gradle/ ./
RUN chmod +x gradlew
# 소스 복사
COPY src ./src
# 컨테이너 내부에서 빌드
RUN ./gradlew --no-daemon clean bootJar

# 2) 런타임 스테이지
FROM eclipse-temurin:21-jre
WORKDIR /app
# stage 이름은 builder
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
