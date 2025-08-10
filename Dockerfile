# 1) 빌드 스테이지
FROM gradle:8.7.0-jdk21 AS builder
# WORKDIR /app

# ARG JAR_FILE=build/libs/*.jar
# COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]