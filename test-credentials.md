# Working Test Credentials

Based on the banking system setup, here are the steps to create a working user:

## Option 1: Create via API (Recommended)

1. First, create a new customer:
```bash
curl -X POST http://localhost:5001/customers \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Demo",
    "lastName": "User",
    "email": "newdemo@example.com",
    "phone": "+1234567890",
    "dateOfBirth": "1990-01-01",
    "customerType": "INDIVIDUAL"
  }'
```

2. Note the customer ID from the response.

3. Since the auth service registration has issues, create the user directly in the database using the customer ID from step 1.

## Option 2: Use Existing Test Data

The system has pre-loaded customers but no corresponding auth users. You can manually create auth records for:
- Customer: John Smith (ID: 22222222-2222-2222-2222-222222222222)
- Email: john.smith@example.com

## Option 3: Direct Database Access

Since the auth service has BCrypt validation issues, you may need to:
1. Generate a proper BCrypt hash using an online tool or Java code
2. Insert directly into the auth database
3. Ensure the user_roles table is properly populated

## Note on Current Issues

The auth service appears to have issues with:
1. BCrypt password validation (possibly wrong salt rounds or encoding)
2. The `/auth/register` endpoint requires an existing customer ID
3. No default users are created in the initialization scripts

For frontend testing, you may want to temporarily disable authentication or create a bypass endpoint.