-- ==============================================================================
-- UPLIFT HEALTH INSURANCE - TIER 1: STATIC MASTER DATA & REFERENCE LAYER
-- DIALECT: PostgreSQL
-- STRATEGY: Idempotent Execution, Soft Deletes, Strict Data Validation
-- ==============================================================================

-- ------------------------------------------------------------------------------
-- 1. CLEANUP (Idempotent Execution)
-- Using CASCADE to drop dependencies safely if this script is re-run.
-- ------------------------------------------------------------------------------
DROP TABLE IF EXISTS coverage_plans CASCADE;
DROP TABLE IF EXISTS riders CASCADE;
DROP TABLE IF EXISTS facilities CASCADE;
DROP TABLE IF EXISTS specialties CASCADE;
DROP TABLE IF EXISTS denial_reason_codes CASCADE;
DROP TABLE IF EXISTS wellness_benefits CASCADE;
DROP TABLE IF EXISTS government_programs CASCADE;

-- ------------------------------------------------------------------------------
-- 2. TABLE CREATION
-- ------------------------------------------------------------------------------

-- COVERAGE_PLANS: Defines the core pricing and rules for insurance plans.
CREATE TABLE coverage_plans (
    plan_id VARCHAR(10) PRIMARY KEY,
    plan_name VARCHAR(50) NOT NULL,
    plan_type VARCHAR(20) NOT NULL,
    
    -- Financials: Enforced DECIMAL precision and zero-floor constraints
    base_monthly_rate DECIMAL(10,2) NOT NULL CHECK (base_monthly_rate >= 0),
    base_annual_rate DECIMAL(10,2) NOT NULL CHECK (base_annual_rate >= 0),
    annual_deductible DECIMAL(10,2) NOT NULL CHECK (annual_deductible >= 0),
    copay_amount DECIMAL(10,2) NOT NULL CHECK (copay_amount >= 0),
    coinsurance_percentage INT NOT NULL CHECK (coinsurance_percentage >= 0 AND coinsurance_percentage <= 100),
    out_of_pocket_max DECIMAL(10,2) NOT NULL CHECK (out_of_pocket_max >= 0),
    
    -- Enterprise Compliance Features
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- RIDERS: Optional add-ons to coverage (e.g., Dental, Vision).
CREATE TABLE riders (
    rider_id VARCHAR(10) PRIMARY KEY,
    rider_name VARCHAR(50) NOT NULL,
    rider_type VARCHAR(30) NOT NULL,
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- FACILITIES: Hospitals and clinics. Isolated to prevent 3NF transitive dependencies.
CREATE TABLE facilities (
    facility_id VARCHAR(15) PRIMARY KEY,
    facility_name VARCHAR(100) NOT NULL,
    facility_type VARCHAR(30) NOT NULL,
    network_status VARCHAR(15) NOT NULL CHECK (network_status IN ('In-Network', 'Out-of-Network', 'Tier 1', 'Tier 2')),
    facility_address VARCHAR(255) NOT NULL,
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- SPECIALTIES: Medical taxonomy catalog.
CREATE TABLE specialties (
    specialty_id VARCHAR(10) PRIMARY KEY,
    specialty_name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(255),
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- DENIAL_REASON_CODES: System dictionary to eliminate redundant text in claim logs.
CREATE TABLE denial_reason_codes (
    denial_code VARCHAR(10) PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- WELLNESS_BENEFITS: Fixed rewards catalogs.
CREATE TABLE wellness_benefits (
    benefit_perk_id VARCHAR(10) PRIMARY KEY,
    perk_name VARCHAR(100) NOT NULL,
    reward_type VARCHAR(30) NOT NULL,
    reward_value DECIMAL(10,2) NOT NULL CHECK (reward_value >= 0),
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- GOVERNMENT_PROGRAMS: Defines regulatory funding sources (e.g., Medicare).
CREATE TABLE government_programs (
    program_id VARCHAR(10) PRIMARY KEY,
    program_name VARCHAR(50) NOT NULL,
    government_agency VARCHAR(50) NOT NULL,
    funding_type VARCHAR(50) NOT NULL,
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);