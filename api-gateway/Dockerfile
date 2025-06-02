# Multi-stage build
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy the entire project
COPY . .

# Build shared-proto first (if needed by api-gateway)
WORKDIR /app/shared-proto
RUN mvn clean install -DskipTests

# Build api-gateway
WORKDIR /app/api-gateway
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Install wget for health checks
RUN apk add --no-cache wget

# Create a non-root user
RUN addgroup -g 1000 appuser && adduser -u 1000 -G appuser -s /bin/sh -D appuser

# Copy the JAR from builder stage
COPY --from=builder /app/api-gateway/target/api-gateway-1.0.0.jar app.jar

# Change ownership
RUN chown -R appuser:appuser app.jar

# Switch to non-root user
USER appuser

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]