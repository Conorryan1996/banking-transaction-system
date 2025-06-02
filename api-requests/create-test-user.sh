#!/bin/bash

echo "Creating a test user account..."

# First, let's register a new user
curl -X POST http://localhost:8080/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "email": "testuser@example.com",
    "password": "Test123!@#",
    "firstName": "Test",
    "lastName": "User"
  }'

echo -e "\n\nNow logging in with the created user..."

# Login with the created user
response=$(curl -s -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "password": "Test123!@#"
  }')

echo "Login response:"
echo $response | jq .

# Extract token if jq is available
if command -v jq &> /dev/null; then
    token=$(echo $response | jq -r .accessToken)
    echo -e "\n\nAccess token saved. You can use it for authenticated requests:"
    echo "export TOKEN=$token"
fi

echo -e "\n\nTest credentials:"
echo "Username: testuser"
echo "Password: Test123!@#"