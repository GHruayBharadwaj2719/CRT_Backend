# ---------- Build stage ----------
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app

# Install git (optional but kept as requested)
RUN apt-get update && apt-get install -y git && rm -rf /var/lib/apt/lists/*

# Clone backend repository
RUN git clone https://github.com/2300090278/docker-backend.git .

# Build Spring Boot JAR
RUN --mount=type=cache,target=/root/.m2 \
    mvn clean package -DskipTests

# ---------- Run stage ----------
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy JAR from build stage
COPY --from=builder /app/target/*.jar app.jar

# Render requires port 8080
EXPOSE 8080

# Optional JVM options
ENV JAVA_OPTS=""

# Start Spring Boot app
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
