# ===============================
# Etapa 1: Build con Gradle Wrapper
# ===============================
FROM gradle:8.14-jdk17-alpine AS builder

WORKDIR /home/app

# Copiamos solo lo necesario para cachear dependencias
COPY gradlew .
COPY gradle ./gradle
COPY build.gradle.kts settings.gradle.kts ./

RUN chmod +x ./gradlew
RUN ./gradlew dependencies --no-daemon

# Copiamos el código fuente
COPY src ./src

# Genera el jar de Spring Boot
RUN ./gradlew bootJar --no-daemon

# ===============================
# Etapa 2: Runtime liviano
# ===============================
FROM eclipse-temurin:17-jre-alpine

ENV APP_HOME=/app
WORKDIR $APP_HOME

# Copiamos el jar generado
COPY --from=builder /home/app/build/libs/*.jar app.jar

# Puerto configurable por variable de entorno
EXPOSE 8080

# Arranque de la app
ENTRYPOINT ["java","-jar","app.jar"]
