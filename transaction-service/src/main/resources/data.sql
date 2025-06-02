-- Create transactions table with proper constraints
CREATE TABLE IF NOT EXISTS transactions (
                                            id UUID PRIMARY KEY,
                                            account_id UUID NOT NULL,
                                            customer_id UUID NOT NULL,
                                            target_account_id UUID,
                                            transaction_type VARCHAR(20) NOT NULL CHECK (transaction_type IN ('DEPOSIT', 'WITHDRAWAL', 'TRANSFER')),
    amount DECIMAL(15,2) NOT NULL CHECK (amount > 0),
    description VARCHAR(500),
    reference_number VARCHAR(100),
    status VARCHAR(20) NOT NULL CHECK (status IN ('PENDING', 'COMPLETED', 'FAILED', 'CANCELLED')),
    previous_balance DECIMAL(15,2) NOT NULL,
    new_balance DECIMAL(15,2) NOT NULL,
    processed_date TIMESTAMP NOT NULL,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_modified_date TIMESTAMP
    );

-- Create indexes for performance
CREATE INDEX IF NOT EXISTS idx_transactions_account_id ON transactions(account_id);
CREATE INDEX IF NOT EXISTS idx_transactions_customer_id ON transactions(customer_id);
CREATE INDEX IF NOT EXISTS idx_transactions_target_account_id ON transactions(target_account_id);
CREATE INDEX IF NOT EXISTS idx_transactions_status ON transactions(status);
CREATE INDEX IF NOT EXISTS idx_transactions_type ON transactions(transaction_type);
CREATE INDEX IF NOT EXISTS idx_transactions_processed_date ON transactions(processed_date DESC);
CREATE INDEX IF NOT EXISTS idx_transactions_reference ON transactions(reference_number);

-- Insert sample transaction data (using existing account and customer IDs from other services)
INSERT INTO transactions (id, account_id, customer_id, transaction_type, amount, description, reference_number, status, previous_balance, new_balance, processed_date, created_date)
SELECT
    '33333333-3333-3333-3333-333333333331'::UUID,
    '11111111-1111-1111-1111-111111111111'::UUID,
    '22222222-2222-2222-2222-222222222222'::UUID,
    'DEPOSIT',
    1000.00,
    'Initial deposit',
    'REF001',
    'COMPLETED',
    4000.00,
    5000.00,
    CURRENT_TIMESTAMP - INTERVAL '25 days',
    CURRENT_TIMESTAMP - INTERVAL '25 days'
WHERE NOT EXISTS (
    SELECT 1 FROM transactions WHERE id = '33333333-3333-3333-3333-333333333331'::UUID
    );

INSERT INTO transactions (id, account_id, customer_id, transaction_type, amount, description, reference_number, status, previous_balance, new_balance, processed_date, created_date)
SELECT
    '33333333-3333-3333-3333-333333333332'::UUID,
    '11111111-1111-1111-1111-111111111112'::UUID,
    '22222222-2222-2222-2222-222222222222'::UUID,
    'DEPOSIT',
    5000.00,
    'Salary deposit',
    'REF002',
    'COMPLETED',
    10000.00,
    15000.00,
    CURRENT_TIMESTAMP - INTERVAL '20 days',
    CURRENT_TIMESTAMP - INTERVAL '20 days'
WHERE NOT EXISTS (
    SELECT 1 FROM transactions WHERE id = '33333333-3333-3333-3333-333333333332'::UUID
    );

INSERT INTO transactions (id, account_id, customer_id, transaction_type, amount, description, reference_number, status, previous_balance, new_balance, processed_date, created_date)
SELECT
    '33333333-3333-3333-3333-333333333333'::UUID,
    '11111111-1111-1111-1111-111111111113'::UUID,
    '22222222-2222-2222-2222-222222222223'::UUID,
    'WITHDRAWAL',
    2500.00,
    'Business expense',
    'REF003',
    'COMPLETED',
    27500.00,
    25000.00,
    CURRENT_TIMESTAMP - INTERVAL '15 days',
    CURRENT_TIMESTAMP - INTERVAL '15 days'
WHERE NOT EXISTS (
    SELECT 1 FROM transactions WHERE id = '33333333-3333-3333-3333-333333333333'::UUID
    );

INSERT INTO transactions (id, account_id, customer_id, transaction_type, amount, description, reference_number, status, previous_balance, new_balance, processed_date, created_date)
SELECT
    '33333333-3333-3333-3333-333333333334'::UUID,
    '11111111-1111-1111-1111-111111111115'::UUID,
    '22222222-2222-2222-2222-222222222224'::UUID,
    'WITHDRAWAL',
    249.50,
    'ATM withdrawal',
    'REF004',
    'COMPLETED',
    1000.00,
    750.50,
    CURRENT_TIMESTAMP - INTERVAL '10 days',
    CURRENT_TIMESTAMP - INTERVAL '10 days'
WHERE NOT EXISTS (
    SELECT 1 FROM transactions WHERE id = '33333333-3333-3333-3333-333333333334'::UUID
    );

INSERT INTO transactions (id, account_id, customer_id, transaction_type, amount, description, reference_number, status, previous_balance, new_balance, processed_date, created_date)
SELECT
    '33333333-3333-3333-3333-333333333335'::UUID,
    '11111111-1111-1111-1111-111111111114'::UUID,
    '22222222-2222-2222-2222-222222222223'::UUID,
    'TRANSFER',
    10000.00,
    'Transfer to business checking',
    'REF005',
    'COMPLETED',
    60000.00,
    50000.00,
    CURRENT_TIMESTAMP - INTERVAL '5 days',
    CURRENT_TIMESTAMP - INTERVAL '5 days'
WHERE NOT EXISTS (
    SELECT 1 FROM transactions WHERE id = '33333333-3333-3333-3333-333333333335'::UUID
    );