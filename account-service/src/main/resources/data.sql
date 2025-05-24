-- COMPLETE DATA.SQL FILE
-- src/main/resources/data.sql

-- Ensure the accounts table exists with correct structure
CREATE TABLE IF NOT EXISTS accounts (
                                        id UUID PRIMARY KEY,
                                        account_number VARCHAR(255) UNIQUE NOT NULL,
    customer_id UUID NOT NULL,
    account_type VARCHAR(50) NOT NULL CHECK (account_type IN ('CHECKING', 'SAVINGS', 'BUSINESS_CHECKING', 'BUSINESS_SAVINGS')),
    balance DECIMAL(15,2) NOT NULL DEFAULT 0.00,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE' CHECK (status IN ('ACTIVE', 'INACTIVE', 'FROZEN', 'CLOSED')),
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_modified_date TIMESTAMP
    );

-- Create index for better performance
CREATE INDEX IF NOT EXISTS idx_accounts_customer_id ON accounts(customer_id);
CREATE INDEX IF NOT EXISTS idx_accounts_account_number ON accounts(account_number);
CREATE INDEX IF NOT EXISTS idx_accounts_status ON accounts(status);

-- Insert comprehensive sample data
INSERT INTO accounts (id, account_number, customer_id, account_type, balance, status, created_date)
SELECT
    '11111111-1111-1111-1111-111111111111'::UUID,
    'ACC1000001',
    '22222222-2222-2222-2222-222222222222'::UUID,
    'CHECKING',
    5000.00,
    'ACTIVE',
    CURRENT_TIMESTAMP - INTERVAL '30 days'
WHERE NOT EXISTS (
    SELECT 1 FROM accounts WHERE id = '11111111-1111-1111-1111-111111111111'::UUID
    );

INSERT INTO accounts (id, account_number, customer_id, account_type, balance, status, created_date)
SELECT
    '11111111-1111-1111-1111-111111111112'::UUID,
    'ACC1000002',
    '22222222-2222-2222-2222-222222222222'::UUID,
    'SAVINGS',
    15000.00,
    'ACTIVE',
    CURRENT_TIMESTAMP - INTERVAL '25 days'
WHERE NOT EXISTS (
    SELECT 1 FROM accounts WHERE id = '11111111-1111-1111-1111-111111111112'::UUID
    );

INSERT INTO accounts (id, account_number, customer_id, account_type, balance, status, created_date)
SELECT
    '11111111-1111-1111-1111-111111111113'::UUID,
    'ACC1000003',
    '22222222-2222-2222-2222-222222222223'::UUID,
    'BUSINESS_CHECKING',
    25000.00,
    'ACTIVE',
    CURRENT_TIMESTAMP - INTERVAL '20 days'
WHERE NOT EXISTS (
    SELECT 1 FROM accounts WHERE id = '11111111-1111-1111-1111-111111111113'::UUID
    );

INSERT INTO accounts (id, account_number, customer_id, account_type, balance, status, created_date)
SELECT
    '11111111-1111-1111-1111-111111111114'::UUID,
    'ACC1000004',
    '22222222-2222-2222-2222-222222222223'::UUID,
    'BUSINESS_SAVINGS',
    50000.00,
    'ACTIVE',
    CURRENT_TIMESTAMP - INTERVAL '15 days'
WHERE NOT EXISTS (
    SELECT 1 FROM accounts WHERE id = '11111111-1111-1111-1111-111111111114'::UUID
    );

INSERT INTO accounts (id, account_number, customer_id, account_type, balance, status, created_date)
SELECT
    '11111111-1111-1111-1111-111111111115'::UUID,
    'ACC1000005',
    '22222222-2222-2222-2222-222222222224'::UUID,
    'CHECKING',
    750.50,
    'ACTIVE',
    CURRENT_TIMESTAMP - INTERVAL '10 days'
WHERE NOT EXISTS (
    SELECT 1 FROM accounts WHERE id = '11111111-1111-1111-1111-111111111115'::UUID
    );

INSERT INTO accounts (id, account_number, customer_id, account_type, balance, status, created_date)
SELECT
    '11111111-1111-1111-1111-111111111116'::UUID,
    'ACC1000006',
    '22222222-2222-2222-2222-222222222224'::UUID,
    'SAVINGS',
    12500.75,
    'FROZEN',
    CURRENT_TIMESTAMP - INTERVAL '5 days'
WHERE NOT EXISTS (
    SELECT 1 FROM accounts WHERE id = '11111111-1111-1111-1111-111111111116'::UUID
    );