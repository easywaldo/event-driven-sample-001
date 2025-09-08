# 1) 빌드 스테이지
FROM gradle:8.7.0-jdk17 AS builder

# UTF-8 환경
ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8
ENV JAVA_TOOL_OPTIONS="-Dfile.encoding=UTF-8"

WORKDIR /app/demo

# 필요한 파일만 먼저 복사(캐시 최적화)
# wrapper와 설정 복사 (wrapper JAR가 들어있는 gradle/wrapper까지 꼭 포함)
COPY demo/gradlew /app/demo/gradlew
COPY demo/gradle /app/demo/gradle
COPY demo/settings.gradle* demo/build.gradle* /app/demo/

RUN chmod +x gradlew

# 소스 복사
COPY demo/src /app/demo/src

# 컨테이너 내부에서 빌드
RUN ./gradlew --no-daemon clean bootJar

# ★ 빌드 산출물을 실행 경로로 이동(이 줄이 중요!)
RUN cp /app/demo/build/libs/*.jar /app/demo/app.jar


# ARG JAR_FILE=build/libs/*.jar
# COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/demo/app.jar"]