# Demo User Credentials

After setting up the system, create a demo user by running:

```bash
docker exec postgres-shared psql -U postgres -d auth_db << 'EOF'
-- Clear existing demo user
DELETE FROM user_roles WHERE user_id IN (SELECT id FROM users WHERE username = 'demouser');
DELETE FROM users WHERE username = 'demouser';

-- Ensure role exists
INSERT INTO roles (id, name, description) 
VALUES (gen_random_uuid(), 'ROLE_CUSTOMER', 'Customer role')
ON CONFLICT (name) DO NOTHING;

-- Create demo user
-- Password: demopass123
-- BCrypt hash generated with rounds=10
INSERT INTO users (
    id, 
    username, 
    email, 
    password, 
    customer_id,
    enabled,
    account_non_expired,
    account_non_locked,
    credentials_non_expired,
    created_at
) VALUES (
    gen_random_uuid(),
    'demouser',
    'demouser@example.com',
    '$2a$10$EixZaYVK1fsbw1ZfbX3OXe.9vDnTpLzhFZ6z2E0ErWvH6MiFmUJPm', -- demopass123
    '22222222-2222-2222-2222-222222222222'::UUID,
    true,
    true,
    true,
    true,
    CURRENT_TIMESTAMP
);

-- Link to customer role
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u, roles r
WHERE u.username = 'demouser' AND r.name = 'ROLE_CUSTOMER';

SELECT 'Demo user created!' as status;
EOF
```

Then login with:
- **Username**: demouser
- **Password**: demopass123

Test the login:
```bash
curl -X POST http://localhost:5004/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "demouser",
    "password": "demopass123"
  }'
```

Or through the API Gateway:
```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "demouser",
    "password": "demopass123"
  }'
```