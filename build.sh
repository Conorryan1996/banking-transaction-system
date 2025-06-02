#!/bin/bash

# Build script for Banking Transaction System
# This script ensures all dependencies are properly set up before building

set -e  # Exit on error

echo "🏦 Banking Transaction System - Build Script"
echo "==========================================="

# Check if we're in the right directory
if [ ! -f "docker-compose.yml" ]; then
    echo "❌ Error: This script must be run from the project root directory"
    exit 1
fi

# Check if package-lock.json exists for frontend, create if missing
if [ ! -f "banking-frontend/package-lock.json" ]; then
    echo "📦 Generating package-lock.json for frontend..."
    (cd banking-frontend && npm install)
    echo "✅ package-lock.json generated"
fi

# Build all services
echo "🔨 Building all services with docker-compose..."
docker-compose build

echo "✅ Build complete! Run 'docker-compose up' to start the system."