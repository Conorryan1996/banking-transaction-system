-- Add scheduled_date column if it doesn't exist
ALTER TABLE transactions 
ADD COLUMN IF NOT EXISTS scheduled_date TIMESTAMP;

-- Update the status CHECK constraint to include SCHEDULED
ALTER TABLE transactions 
DROP CONSTRAINT IF EXISTS transactions_status_check;

ALTER TABLE transactions 
ADD CONSTRAINT transactions_status_check 
CHECK (status IN ('PENDING', 'SCHEDULED', 'COMPLETED', 'FAILED', 'CANCELLED'));