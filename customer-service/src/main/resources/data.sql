-- Create customers table with proper constraints
CREATE TABLE IF NOT EXISTS customers (
                                         id UUID PRIMARY KEY,
                                         first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(20),
    date_of_birth DATE,
    status VARCHAR(20) NOT NULL CHECK (status IN ('PENDING_VERIFICATION', 'ACTIVE', 'SUSPENDED', 'CLOSED')),
    customer_type VARCHAR(20) NOT NULL CHECK (customer_type IN ('INDIVIDUAL', 'BUSINESS')),
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_modified_date TIMESTAMP
    );

-- Create indexes for performance
CREATE INDEX IF NOT EXISTS idx_customers_email ON customers(email);
CREATE INDEX IF NOT EXISTS idx_customers_status ON customers(status);
CREATE INDEX IF NOT EXISTS idx_customers_type ON customers(customer_type);
CREATE INDEX IF NOT EXISTS idx_customers_name ON customers(first_name, last_name);

-- Insert sample customers (matching the customer IDs used in Account Service)
INSERT INTO customers (id, first_name, last_name, email, phone, date_of_birth, status, customer_type, created_date)
SELECT
    '22222222-2222-2222-2222-222222222222'::UUID,
    'John',
    'Smith',
    'john.smith@example.com',
    '+1-555-0123',
    '1985-06-15'::DATE,
    'ACTIVE',
    'INDIVIDUAL',
    CURRENT_TIMESTAMP - INTERVAL '35 days'
WHERE NOT EXISTS (
    SELECT 1 FROM customers WHERE id = '22222222-2222-2222-2222-222222222222'::UUID
    );

INSERT INTO customers (id, first_name, last_name, email, phone, date_of_birth, status, customer_type, created_date)
SELECT
    '22222222-2222-2222-2222-222222222223'::UUID,
    'ABC',
    'Corporation',
    'contact@abccorp.com',
    '+1-555-0124',
    '1990-01-01'::DATE,
    'ACTIVE',
    'BUSINESS',
    CURRENT_TIMESTAMP - INTERVAL '30 days'
WHERE NOT EXISTS (
    SELECT 1 FROM customers WHERE id = '22222222-2222-2222-2222-222222222223'::UUID
    );

INSERT INTO customers (id, first_name, last_name, email, phone, date_of_birth, status, customer_type, created_date)
SELECT
    '22222222-2222-2222-2222-222222222224'::UUID,
    'Jane',
    'Doe',
    'jane.doe@example.com',
    '+1-555-0125',
    '1992-03-20'::DATE,
    'PENDING_VERIFICATION',
    'INDIVIDUAL',
    CURRENT_TIMESTAMP - INTERVAL '7 days'
WHERE NOT EXISTS (
    SELECT 1 FROM customers WHERE id = '22222222-2222-2222-2222-222222222224'::UUID
    );

INSERT INTO customers (id, first_name, last_name, email, phone, date_of_birth, status, customer_type, created_date)
SELECT
    '22222222-2222-2222-2222-222222222225'::UUID,
    'Tech',
    'Innovations LLC',
    'info@techinnovations.com',
    '+1-555-0126',
    '2020-05-10'::DATE,
    'ACTIVE',
    'BUSINESS',
    CURRENT_TIMESTAMP - INTERVAL '15 days'
WHERE NOT EXISTS (
    SELECT 1 FROM customers WHERE id = '22222222-2222-2222-2222-222222222225'::UUID
    );