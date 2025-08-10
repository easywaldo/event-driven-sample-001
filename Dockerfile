# 1) 빌드 스테이지
FROM gradle:8.7.0-jdk21 AS builder

WORKDIR /app/demo
# 필요한 파일만 먼저 복사(캐시 최적화)
COPY demo/gradlew demo/gradle/ demo/settings.gradle* demo/build.gradle*  /app/demo/

RUN chmod +x gradlew
# 소스 복사
COPY demo/src /app/demo/src

# 컨테이너 내부에서 빌드
RUN ./gradlew --no-daemon clean bootJar


# ARG JAR_FILE=build/libs/*.jar
# COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]