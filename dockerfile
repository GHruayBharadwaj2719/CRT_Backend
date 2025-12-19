# ---------- Build stage ----------
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Install git
RUN apt-get update && apt-get install -y git && rm -rf /var/lib/apt/lists/*

# Clone repository
RUN git clone https://github.com/2300090278/docker-backend.git .

# Build Spring Boot JAR (NO TESTS, NO SUREFIRE)
RUN --mount=type=cache,target=/root/.m2 \
    mvn clean package \
    -DskipTests \
    -Dmaven.test.skip=true \
    -DskipITs \
    -DskipSurefire=true \
    -Dmaven.javadoc.skip=true \
    --batch-mode \
    --no-transfer-progress

# ---------- Run stage ----------
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

# Render requires port 8080
EXPOSE 8080

ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
