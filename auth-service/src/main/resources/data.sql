-- Create default roles if they don't exist
INSERT INTO roles (id, name, description) VALUES 
    (gen_random_uuid(), 'ROLE_CUSTOMER', 'Customer role with basic banking permissions'),
    (gen_random_uuid(), 'ROLE_ADMIN', 'Administrator role with full system access'),
    (gen_random_uuid(), 'ROLE_EMPLOYEE', 'Bank employee role with operational permissions')
ON CONFLICT (name) DO NOTHING;

-- Create indexes for better performance
CREATE INDEX IF NOT EXISTS idx_users_username ON users(username);
CREATE INDEX IF NOT EXISTS idx_users_email ON users(email);
CREATE INDEX IF NOT EXISTS idx_users_customer_id ON users(customer_id);