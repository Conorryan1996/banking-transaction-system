# Multi-stage build that handles shared-proto
FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy the entire project
COPY . .

# Build shared-proto first (this generates the gRPC classes)
WORKDIR /app/shared-proto
RUN mvn clean install -DskipTests

# Build auth-service (now shared-proto is available in local Maven repo)
WORKDIR /app/auth-service
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Create non-root user
RUN addgroup -g 1000 appgroup && \
    adduser -u 1000 -G appgroup -D appuser

# Copy JAR from builder
COPY --from=builder /app/auth-service/target/*.jar app.jar

# Change ownership
RUN chown -R appuser:appgroup /app

# Switch to non-root user
USER appuser

# Expose ports
EXPOSE 5004 9004

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=60s --retries=3 \
    CMD wget -q -O /dev/null http://localhost:5004/actuator/health || exit 1

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]