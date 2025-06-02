# Multi-stage build that handles shared-proto
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy the entire project
COPY . .

# Build shared-proto first (this generates the gRPC classes)
WORKDIR /app/shared-proto
RUN mvn clean install -DskipTests

# Build fraud-service (now shared-proto is available in local Maven repo)
WORKDIR /app/fraud-service
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Install wget for health checks
RUN apk add --no-cache wget

# Create a non-root user
RUN addgroup -g 1000 appuser && adduser -u 1000 -G appuser -s /bin/sh -D appuser

# Copy the jar file
COPY --from=builder /app/fraud-service/target/fraud-service-0.0.1-SNAPSHOT.jar app.jar

# Change ownership
RUN chown -R appuser:appuser app.jar

# Switch to non-root user
USER appuser

# Expose ports
EXPOSE 5003 9003

# Run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]