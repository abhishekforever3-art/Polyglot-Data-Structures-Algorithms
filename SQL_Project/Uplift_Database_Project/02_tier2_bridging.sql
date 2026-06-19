-- ==============================================================================
-- UPLIFT HEALTH INSURANCE - TIER 2: RELATIONAL BRIDGING & ASSOCIATION LAYER
-- DIALECT: PostgreSQL
-- STRATEGY: ON DELETE RESTRICT, Unary Recursion, and Date Validation
-- ==============================================================================

-- ------------------------------------------------------------------------------
-- 1. CLEANUP (Idempotent Execution)
-- ------------------------------------------------------------------------------
DROP TABLE IF EXISTS provider_contracts CASCADE;
DROP TABLE IF EXISTS practitioners CASCADE;
DROP TABLE IF EXISTS policy_riders CASCADE;
DROP TABLE IF EXISTS members CASCADE;
DROP TABLE IF EXISTS policies CASCADE;

-- ------------------------------------------------------------------------------
-- 2. TABLE CREATION & RELATIONS
-- ------------------------------------------------------------------------------

-- POLICIES: Central configuration contract.
CREATE TABLE policies (
    policy_id VARCHAR(15) PRIMARY KEY,
    plan_id VARCHAR(10) NOT NULL,
    government_program_id VARCHAR(10), -- Nullable for commercial plans
    billing_frequency VARCHAR(10) NOT NULL CHECK (billing_frequency IN ('Monthly', 'Quarterly', 'Annually')),
    total_policy_premium DECIMAL(10,2) NOT NULL CHECK (total_policy_premium >= 0),
    policy_start_date DATE NOT NULL,
    policy_end_date DATE NOT NULL,
    
    -- Enterprise Compliance
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    -- FOREIGN KEYS: RESTRICT prevents deleting a coverage plan if a policy uses it
    CONSTRAINT fk_policy_plan FOREIGN KEY (plan_id) REFERENCES coverage_plans(plan_id) ON DELETE RESTRICT,
    CONSTRAINT fk_policy_gov FOREIGN KEY (government_program_id) REFERENCES government_programs(program_id) ON DELETE RESTRICT,
    
    -- LOGIC GATE: A policy cannot end before it begins
    CONSTRAINT chk_policy_dates CHECK (policy_end_date >= policy_start_date)
);

-- MEMBERS: Subscribers and dependents.
CREATE TABLE members (
    member_id VARCHAR(15) PRIMARY KEY,
    policy_id VARCHAR(15) NOT NULL,
    
    -- UNARY PATTERN: Nullable. If null, they ARE the subscriber. 
    -- If populated, it points to another member_id in this exact table.
    subscriber_id VARCHAR(15), 
    
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    gender CHAR(1) NOT NULL CHECK (gender IN ('M', 'F', 'O')),
    relationship_to_policyholder VARCHAR(20) NOT NULL,
    state CHAR(2) NOT NULL,
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_member_policy FOREIGN KEY (policy_id) REFERENCES policies(policy_id) ON DELETE RESTRICT,
    CONSTRAINT fk_member_subscriber FOREIGN KEY (subscriber_id) REFERENCES members(member_id) ON DELETE RESTRICT
);

-- POLICY_RIDERS: Many-to-Many Bridge Table resolving Policies and Riders.
CREATE TABLE policy_riders (
    policy_rider_id VARCHAR(20) PRIMARY KEY,
    policy_id VARCHAR(15) NOT NULL,
    rider_id VARCHAR(10) NOT NULL,
    additional_premium_amount DECIMAL(10,2) NOT NULL CHECK (additional_premium_amount >= 0),
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_pr_policy FOREIGN KEY (policy_id) REFERENCES policies(policy_id) ON DELETE RESTRICT,
    CONSTRAINT fk_pr_rider FOREIGN KEY (rider_id) REFERENCES riders(rider_id) ON DELETE RESTRICT
);

-- PRACTITIONERS: Doctors mapping to facilities and specialties.
CREATE TABLE practitioners (
    practitioner_id VARCHAR(15) PRIMARY KEY,
    primary_facility_id VARCHAR(15) NOT NULL,
    primary_specialty_id VARCHAR(10) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    
    -- NPI is a strict 10-digit medical license. UNIQUE ensures no duplicates.
    npi_number CHAR(10) NOT NULL UNIQUE, 
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_pract_facility FOREIGN KEY (primary_facility_id) REFERENCES facilities(facility_id) ON DELETE RESTRICT,
    CONSTRAINT fk_pract_specialty FOREIGN KEY (primary_specialty_id) REFERENCES specialties(specialty_id) ON DELETE RESTRICT
);

-- PROVIDER_CONTRACTS: Maps a facility to its fee schedules.
CREATE TABLE provider_contracts (
    contract_id VARCHAR(15) PRIMARY KEY,
    facility_id VARCHAR(15) NOT NULL,
    procedure_code VARCHAR(10) NOT NULL,
    negotiated_package_rate DECIMAL(10,2) NOT NULL CHECK (negotiated_package_rate >= 0),
    effective_date DATE NOT NULL,
    expiration_date DATE NOT NULL,
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_contract_facility FOREIGN KEY (facility_id) REFERENCES facilities(facility_id) ON DELETE RESTRICT,
    CONSTRAINT chk_contract_dates CHECK (expiration_date >= effective_date)
);