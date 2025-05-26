# Multi-stage build that handles shared-proto
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy the entire project
COPY src/main/java/com/pm/transactionservice .

# Build shared-proto first (this generates the gRPC classes)
WORKDIR /app/shared-proto
RUN mvn clean install -DskipTests

# Build transaction-service (now shared-proto is available in local Maven repo)
WORKDIR /app/transaction-service
RUN mvn clean package -DskipTests

# Runtime stage
FROM openjdk:17-jdk-slim

WORKDIR /app

# Install wget for health checks
RUN apt-get update && apt-get install -y wget && rm -rf /var/lib/apt/lists/*

# Copy the JAR from builder stage
COPY --from=builder /app/transaction-service/target/transaction-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 5002 9002

ENTRYPOINT ["java", "-jar", "app.jar"]