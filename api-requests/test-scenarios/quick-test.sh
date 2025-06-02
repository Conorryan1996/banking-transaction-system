#!/bin/bash
# Quick test script for banking transactions

echo "=== Banking Transaction System Test ==="
echo

# Test account ID (pre-loaded in the system)
ACCOUNT_ID="11111111-1111-1111-1111-111111111111"

echo "1. Checking initial balance..."
curl -s "http://localhost:5002/transactions/account/$ACCOUNT_ID/balance" | python3 -m json.tool
echo

echo "2. Making a deposit of $300..."
curl -X POST http://localhost:5002/transactions \
  -H "Content-Type: application/json" \
  -d "{
    \"accountId\": \"$ACCOUNT_ID\",
    \"transactionType\": \"DEPOSIT\",
    \"amount\": 300.00,
    \"description\": \"Test deposit\"
  }" -s | python3 -m json.tool
echo

echo "3. Making a withdrawal of $150..."
curl -X POST http://localhost:5002/transactions \
  -H "Content-Type: application/json" \
  -d "{
    \"accountId\": \"$ACCOUNT_ID\",
    \"transactionType\": \"WITHDRAWAL\",
    \"amount\": 150.00,
    \"description\": \"Test withdrawal\"
  }" -s | python3 -m json.tool
echo

echo "4. Checking final balance..."
curl -s "http://localhost:5002/transactions/account/$ACCOUNT_ID/balance" | python3 -m json.tool
echo

echo "5. Testing insufficient funds (trying to withdraw $50,000)..."
curl -X POST http://localhost:5002/transactions \
  -H "Content-Type: application/json" \
  -d "{
    \"accountId\": \"$ACCOUNT_ID\",
    \"transactionType\": \"WITHDRAWAL\",
    \"amount\": 50000.00,
    \"description\": \"Should fail - insufficient funds\"
  }" -s | python3 -m json.tool
echo

echo "6. Getting transaction history..."
curl -s "http://localhost:5002/transactions/account/$ACCOUNT_ID?limit=5" | python3 -m json.tool
echo

echo "=== Test Complete ==="