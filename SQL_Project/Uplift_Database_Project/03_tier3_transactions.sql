-- ==============================================================================
-- UPLIFT HEALTH INSURANCE - TIER 3: HIGH-CONCURRENCY OLTP TRANSACTION ENGINE
-- DIALECT: PostgreSQL
-- STRATEGY: Header-Child Composition, Strict Financial Constraints, FK Gatekeeping
-- ==============================================================================

-- ------------------------------------------------------------------------------
-- 1. CLEANUP (Idempotent Execution)
-- ------------------------------------------------------------------------------
DROP TABLE IF EXISTS member_wellness_claims CASCADE;
DROP TABLE IF EXISTS member_other_insurance CASCADE;
DROP TABLE IF EXISTS premium_payments CASCADE;
DROP TABLE IF EXISTS claim_line_items CASCADE;
DROP TABLE IF EXISTS claims_header CASCADE;
DROP TABLE IF EXISTS prior_authorizations CASCADE;

-- ------------------------------------------------------------------------------
-- 2. TABLE CREATION & RELATIONS
-- ------------------------------------------------------------------------------

-- PRIOR_AUTHORIZATIONS: The access gatekeeper for expensive procedures.
CREATE TABLE prior_authorizations (
    auth_id VARCHAR(15) PRIMARY KEY,
    member_id VARCHAR(15) NOT NULL,
    requesting_practitioner_id VARCHAR(15) NOT NULL,
    procedure_code VARCHAR(10) NOT NULL,
    auth_status VARCHAR(20) NOT NULL CHECK (auth_status IN ('Pending', 'Approved', 'Denied', 'Appealed')),
    effective_date DATE NOT NULL,
    expiration_date DATE NOT NULL,
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_auth_member FOREIGN KEY (member_id) REFERENCES members(member_id) ON DELETE RESTRICT,
    CONSTRAINT fk_auth_practitioner FOREIGN KEY (requesting_practitioner_id) REFERENCES practitioners(practitioner_id) ON DELETE RESTRICT,
    CONSTRAINT chk_auth_dates CHECK (expiration_date >= effective_date)
);

-- CLAIMS_HEADER: Captures unique visit metadata exactly once.
CREATE TABLE claims_header (
    claim_id VARCHAR(20) PRIMARY KEY,
    member_id VARCHAR(15) NOT NULL,
    facility_id VARCHAR(15) NOT NULL,
    rendering_practitioner_id VARCHAR(15) NOT NULL,
    
    -- Nullable because not all visits require a prior authorization
    prior_auth_id VARCHAR(15), 
    
    date_of_service DATE NOT NULL,
    total_billed_amount DECIMAL(10,2) NOT NULL CHECK (total_billed_amount >= 0),
    claim_status VARCHAR(20) NOT NULL CHECK (claim_status IN ('Received', 'Adjudicating', 'Paid', 'Denied')),
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_claim_member FOREIGN KEY (member_id) REFERENCES members(member_id) ON DELETE RESTRICT,
    CONSTRAINT fk_claim_facility FOREIGN KEY (facility_id) REFERENCES facilities(facility_id) ON DELETE RESTRICT,
    CONSTRAINT fk_claim_practitioner FOREIGN KEY (rendering_practitioner_id) REFERENCES practitioners(practitioner_id) ON DELETE RESTRICT,
    CONSTRAINT fk_claim_auth FOREIGN KEY (prior_auth_id) REFERENCES prior_authorizations(auth_id) ON DELETE RESTRICT
);

-- CLAIM_LINE_ITEMS: The granular, itemized cost-sharing breakdowns.
CREATE TABLE claim_line_items (
    line_item_id VARCHAR(25) PRIMARY KEY,
    claim_id VARCHAR(20) NOT NULL,
    procedure_code VARCHAR(10) NOT NULL,
    diagnosis_code VARCHAR(10) NOT NULL,
    
    -- Strict financial tracking: Everything must be a positive decimal or zero.
    billed_amount DECIMAL(10,2) NOT NULL CHECK (billed_amount >= 0),
    contractual_write_off DECIMAL(10,2) NOT NULL CHECK (contractual_write_off >= 0),
    allowed_amount DECIMAL(10,2) NOT NULL CHECK (allowed_amount >= 0),
    applied_to_deductible DECIMAL(10,2) NOT NULL CHECK (applied_to_deductible >= 0),
    copay_paid DECIMAL(10,2) NOT NULL CHECK (copay_paid >= 0),
    coinsurance_paid DECIMAL(10,2) NOT NULL CHECK (coinsurance_paid >= 0),
    other_coverage_paid_amount DECIMAL(10,2) NOT NULL CHECK (other_coverage_paid_amount >= 0),
    member_responsibility_amount DECIMAL(10,2) NOT NULL CHECK (member_responsibility_amount >= 0),
    paid_amount DECIMAL(10,2) NOT NULL CHECK (paid_amount >= 0),
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    -- COMPOSITION PATTERN: If a user tries to delete the Header, it blocks it because of these lines.
    CONSTRAINT fk_line_claim FOREIGN KEY (claim_id) REFERENCES claims_header(claim_id) ON DELETE RESTRICT
);

-- PREMIUM_PAYMENTS: Financial ledger for subscriber income.
CREATE TABLE premium_payments (
    payment_id VARCHAR(20) PRIMARY KEY,
    policy_id VARCHAR(15) NOT NULL,
    payment_date DATE NOT NULL,
    amount_paid DECIMAL(10,2) NOT NULL CHECK (amount_paid > 0),
    payment_method VARCHAR(20) NOT NULL,
    billing_period VARCHAR(7) NOT NULL, -- e.g., '2026-06'
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_premium_policy FOREIGN KEY (policy_id) REFERENCES policies(policy_id) ON DELETE RESTRICT
);

-- MEMBER_OTHER_INSURANCE: Coordination of Benefits (COB) tracker.
CREATE TABLE member_other_insurance (
    cob_id VARCHAR(15) PRIMARY KEY,
    member_id VARCHAR(15) NOT NULL,
    other_insurer_name VARCHAR(50) NOT NULL,
    other_policy_number VARCHAR(30) NOT NULL,
    coverage_priority VARCHAR(10) NOT NULL CHECK (coverage_priority IN ('Primary', 'Secondary', 'Tertiary')),
    effective_date DATE NOT NULL,
    termination_date DATE, -- Nullable because they might still have the other insurance
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_cob_member FOREIGN KEY (member_id) REFERENCES members(member_id) ON DELETE RESTRICT
);

-- MEMBER_WELLNESS_CLAIMS: Real-time rewards redemption engine.
CREATE TABLE member_wellness_claims (
    redemption_id VARCHAR(20) PRIMARY KEY,
    member_id VARCHAR(15) NOT NULL,
    benefit_perk_id VARCHAR(10) NOT NULL,
    submission_date DATE NOT NULL,
    proof_status VARCHAR(20) NOT NULL CHECK (proof_status IN ('Submitted', 'Verified', 'Rejected')),
    disbursed_date DATE,
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_wellness_member FOREIGN KEY (member_id) REFERENCES members(member_id) ON DELETE RESTRICT,
    CONSTRAINT fk_wellness_perk FOREIGN KEY (benefit_perk_id) REFERENCES wellness_benefits(benefit_perk_id) ON DELETE RESTRICT
);