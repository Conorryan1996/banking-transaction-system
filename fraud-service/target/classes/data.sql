-- Create indexes for better query performance
CREATE INDEX IF NOT EXISTS idx_transaction_history_customer_timestamp 
ON transaction_history(customer_id, timestamp);

CREATE INDEX IF NOT EXISTS idx_transaction_history_customer_type_timestamp 
ON transaction_history(customer_id, transaction_type, timestamp);

CREATE INDEX IF NOT EXISTS idx_fraud_alerts_customer_status 
ON fraud_alerts(customer_id, status);