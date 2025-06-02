#!/bin/bash
set -e

# Create multiple databases
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE accounts_db;
    CREATE DATABASE customers_db;
    CREATE DATABASE transactions_db;
    CREATE DATABASE fraud_db;
    CREATE DATABASE auth_db;

    -- Grant all privileges to postgres user
    GRANT ALL PRIVILEGES ON DATABASE accounts_db TO postgres;
    GRANT ALL PRIVILEGES ON DATABASE customers_db TO postgres;
    GRANT ALL PRIVILEGES ON DATABASE transactions_db TO postgres;
    GRANT ALL PRIVILEGES ON DATABASE fraud_db TO postgres;
    GRANT ALL PRIVILEGES ON DATABASE auth_db TO postgres;
EOSQL