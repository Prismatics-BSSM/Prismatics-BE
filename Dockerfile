# 1단계: 빌드(Stage Build)
FROM gradle:8.10-jdk21 AS build
WORKDIR /app
COPY . .
RUN ./gradlew bootJar --no-daemon

# 2단계: 실행(Stage Run)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# 빌드된 JAR 복사
COPY --from=build /app/build/libs/*.jar app.jar

# Cloud Run은 8080 포트를 기본으로 사용
EXPOSE 8080

# 실행
ENTRYPOINT ["java", "-jar", "app.jar"]