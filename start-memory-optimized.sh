#!/bin/bash

echo "Starting banking microservices with memory optimization..."

# Clean up any existing containers and volumes
echo "Cleaning up existing containers..."
docker-compose -f docker-compose-memory-optimized.yml down -v

# Set Docker memory limits
export DOCKER_CONTENT_TRUST=0

# Build images with BuildKit for better caching
export DOCKER_BUILDKIT=1

echo "Building optimized images..."
docker-compose -f docker-compose-memory-optimized.yml build

# Start services in stages to reduce memory spike
echo "Starting infrastructure services..."
docker-compose -f docker-compose-memory-optimized.yml up -d postgres-shared
sleep 10

echo "Starting Kafka services..."
docker-compose -f docker-compose-memory-optimized.yml up -d zookeeper
sleep 10
docker-compose -f docker-compose-memory-optimized.yml up -d kafka
sleep 10

echo "Starting core services..."
docker-compose -f docker-compose-memory-optimized.yml up -d auth-service
sleep 5
docker-compose -f docker-compose-memory-optimized.yml up -d account-service
sleep 5
docker-compose -f docker-compose-memory-optimized.yml up -d fraud-service
sleep 5

echo "Starting dependent services..."
docker-compose -f docker-compose-memory-optimized.yml up -d customer-service
sleep 5
docker-compose -f docker-compose-memory-optimized.yml up -d transaction-service
sleep 5

echo "Starting gateway and frontend..."
docker-compose -f docker-compose-memory-optimized.yml up -d api-gateway
sleep 5
docker-compose -f docker-compose-memory-optimized.yml up -d banking-frontend

echo "All services started! Checking status..."
docker-compose -f docker-compose-memory-optimized.yml ps

echo ""
echo "Memory usage by container:"
docker stats --no-stream --format "table {{.Container}}\t{{.MemUsage}}\t{{.MemPerc}}"

echo ""
echo "Total memory usage:"
docker ps -q | xargs docker stats --no-stream --format "{{.MemUsage}}" | awk -F'/' '{gsub(/[^0-9.]/,"",$1); sum+=$1} END {print "Total: " sum " MiB"}'