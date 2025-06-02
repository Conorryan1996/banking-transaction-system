# API Gateway

The API Gateway serves as the single entry point for all client requests to the Banking Transaction System microservices.

## Overview

- **Port**: 8080
- **Technology**: Spring Cloud Gateway
- **Purpose**: Route requests to appropriate microservices, handle CORS, provide centralized logging

## Routes

All routes are prefixed with `/api` and forwarded to the appropriate service:

| Route Pattern | Target Service | Example |
|---------------|----------------|---------|
| `/api/accounts/**` | Account Service (port 5000) | `/api/accounts/123` |
| `/api/customers/**` | Customer Service (port 5001) | `/api/customers/456` |
| `/api/transactions/**` | Transaction Service (port 5002) | `/api/transactions/789` |

## Features

1. **Automatic Path Rewriting**: Removes `/api` prefix when forwarding to services
2. **CORS Support**: Configured for all origins (customize for production)
3. **Request/Response Logging**: All requests and responses are logged
4. **Health Checks**: Available at `/actuator/health`
5. **Route Discovery**: View all routes at `/actuator/gateway/routes`

## Running Locally

```bash
cd api-gateway
./mvnw spring-boot:run
```

## Building

```bash
cd api-gateway
./mvnw clean package
```

## Docker

```bash
docker build -t api-gateway .
docker run -p 8080:8080 api-gateway
```

## Example Usage

Instead of calling services directly:
```bash
# Direct service call
GET http://localhost:5001/customers
```

Use the gateway:
```bash
# Through gateway
GET http://localhost:8080/api/customers
```

## Configuration

The gateway configuration is in `src/main/resources/application.yml`. Key configurations:

- **Routes**: Define path patterns and target services
- **CORS**: Configure allowed origins, methods, and headers
- **Logging**: Set log levels for debugging
- **Timeouts**: Configure connection and response timeouts