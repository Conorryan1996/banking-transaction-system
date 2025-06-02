
# Multi-stage build that handles shared-proto
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy the entire project
COPY . .

# Build shared-proto first (this generates the gRPC classes)
WORKDIR /app/shared-proto
RUN mvn clean install -DskipTests

# Build account-service (now shared-proto is available in local Maven repo)
WORKDIR /app/account-service
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Install wget for health checks
RUN apk add --no-cache wget

# Create a non-root user
RUN addgroup -g 1000 spring && adduser -u 1000 -G spring -s /bin/sh -D spring

# Copy the JAR from builder stage
COPY --from=builder /app/account-service/target/account-service-0.0.1-SNAPSHOT.jar app.jar
RUN chown spring:spring app.jar

USER spring

EXPOSE 5000 9000

# Run with JAVA_OPTS from environment
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]