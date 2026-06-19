-- ==============================================================================
-- UPLIFT HEALTH INSURANCE - TIER 4: ENTERPRISE STATE-MACHINE & INTEGRATION
-- DIALECT: PostgreSQL
-- STRATEGY: Audit Trails, State Tracking, and Compliance Guardrails
-- ==============================================================================

-- ------------------------------------------------------------------------------
-- 1. CLEANUP (Idempotent Execution)
-- ------------------------------------------------------------------------------
DROP TABLE IF EXISTS provider_reviews CASCADE;
DROP TABLE IF EXISTS provider_grievances CASCADE;
DROP TABLE IF EXISTS member_complaints CASCADE;
DROP TABLE IF EXISTS government_funding_ledger CASCADE;
DROP TABLE IF EXISTS reinsurance_stop_loss_claims CASCADE;
DROP TABLE IF EXISTS provider_claim_corrections CASCADE;
DROP TABLE IF EXISTS vendor_payment_clearinghouse CASCADE;
DROP TABLE IF EXISTS claim_disbursements CASCADE;
DROP TABLE IF EXISTS high_dollar_claims_review CASCADE;
DROP TABLE IF EXISTS claim_adjudication_logs CASCADE;
DROP TABLE IF EXISTS member_accumulators CASCADE;

-- ------------------------------------------------------------------------------
-- 2. TABLE CREATION & RELATIONS
-- ------------------------------------------------------------------------------

-- MEMBER_ACCUMULATORS: State-machine for annual member spending.
CREATE TABLE member_accumulators (
    accumulator_id VARCHAR(20) PRIMARY KEY,
    member_id VARCHAR(15) NOT NULL,
    benefit_year INT NOT NULL CHECK (benefit_year >= 2000),
    current_deductible_met DECIMAL(10,2) NOT NULL DEFAULT 0.00 CHECK (current_deductible_met >= 0),
    current_oop_max_met DECIMAL(10,2) NOT NULL DEFAULT 0.00 CHECK (current_oop_max_met >= 0),
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_accum_member FOREIGN KEY (member_id) REFERENCES members(member_id) ON DELETE RESTRICT,
    CONSTRAINT chk_oop_greater_than_deductible CHECK (current_oop_max_met >= current_deductible_met)
);

-- CLAIM_ADJUDICATION_LOGS: Asynchronous audit trail for claim denials.
CREATE TABLE claim_adjudication_logs (
    log_id VARCHAR(20) PRIMARY KEY,
    claim_id VARCHAR(20) NOT NULL,
    denial_code VARCHAR(10) NOT NULL,
    adjudicated_by VARCHAR(50) NOT NULL,
    review_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_log_claim FOREIGN KEY (claim_id) REFERENCES claims_header(claim_id) ON DELETE RESTRICT,
    CONSTRAINT fk_log_denial FOREIGN KEY (denial_code) REFERENCES denial_reason_codes(denial_code) ON DELETE RESTRICT
);

-- HIGH_DOLLAR_CLAIMS_REVIEW: Operational safety net for expensive procedures.
CREATE TABLE high_dollar_claims_review (
    review_id VARCHAR(20) PRIMARY KEY,
    claim_id VARCHAR(20) NOT NULL,
    audit_status VARCHAR(30) NOT NULL CHECK (audit_status IN ('Pending', 'In Review', 'Cleared', 'Flagged for Fraud')),
    assigned_physician_reviewer VARCHAR(50),
    recovered_savings_amount DECIMAL(10,2) DEFAULT 0.00 CHECK (recovered_savings_amount >= 0),
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_hd_claim FOREIGN KEY (claim_id) REFERENCES claims_header(claim_id) ON DELETE RESTRICT
);

-- CLAIM_DISBURSEMENTS: Outbound check/EFT voucher ledger.
CREATE TABLE claim_disbursements (
    disbursement_id VARCHAR(20) PRIMARY KEY,
    claim_id VARCHAR(20) NOT NULL,
    facility_id VARCHAR(15) NOT NULL,
    check_or_eft_number VARCHAR(50) NOT NULL UNIQUE,
    disbursement_date DATE NOT NULL,
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_disb_claim FOREIGN KEY (claim_id) REFERENCES claims_header(claim_id) ON DELETE RESTRICT,
    CONSTRAINT fk_disb_facility FOREIGN KEY (facility_id) REFERENCES facilities(facility_id) ON DELETE RESTRICT
);

-- VENDOR_PAYMENT_CLEARINGHOUSE: B2B pipeline integration (e.g., Zelis).
CREATE TABLE vendor_payment_clearinghouse (
    transmission_id VARCHAR(20) PRIMARY KEY,
    claim_id VARCHAR(20) NOT NULL,
    vendor_name VARCHAR(50) NOT NULL,
    payment_method_type VARCHAR(20) NOT NULL,
    transmission_status VARCHAR(20) NOT NULL CHECK (transmission_status IN ('Sent', 'Acknowledged', 'Failed', 'Reconciled')),
    vendor_reference_number VARCHAR(50),
    sent_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    cleared_timestamp TIMESTAMP,
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_vendor_claim FOREIGN KEY (claim_id) REFERENCES claims_header(claim_id) ON DELETE RESTRICT
);

-- PROVIDER_CLAIM_CORRECTIONS: Provider-side modifications.
CREATE TABLE provider_claim_corrections (
    correction_id VARCHAR(20) PRIMARY KEY,
    original_claim_id VARCHAR(20) NOT NULL,
    provider_facility_id VARCHAR(15) NOT NULL,
    correction_reason VARCHAR(100) NOT NULL,
    review_status VARCHAR(20) NOT NULL CHECK (review_status IN ('Submitted', 'Accepted', 'Rejected')),
    new_submitted_json_payload TEXT NOT NULL,
    assigned_auditor_id VARCHAR(20),
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_corr_claim FOREIGN KEY (original_claim_id) REFERENCES claims_header(claim_id) ON DELETE RESTRICT,
    CONSTRAINT fk_corr_facility FOREIGN KEY (provider_facility_id) REFERENCES facilities(facility_id) ON DELETE RESTRICT
);

-- REINSURANCE_STOP_LOSS_CLAIMS: Catastrophic risk recovery.
CREATE TABLE reinsurance_stop_loss_claims (
    reinsurance_claim_id VARCHAR(20) PRIMARY KEY,
    claim_id VARCHAR(20) NOT NULL,
    attachment_point_threshold DECIMAL(10,2) NOT NULL CHECK (attachment_point_threshold > 0),
    amount_recovered_from_reinsurer DECIMAL(10,2) NOT NULL CHECK (amount_recovered_from_reinsurer >= 0),
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_stoploss_claim FOREIGN KEY (claim_id) REFERENCES claims_header(claim_id) ON DELETE RESTRICT
);

-- GOVERNMENT_FUNDING_LEDGER: State/Federal subsidy tracking.
CREATE TABLE government_funding_ledger (
    funding_entry_id VARCHAR(20) PRIMARY KEY,
    policy_id VARCHAR(15) NOT NULL,
    program_id VARCHAR(10) NOT NULL,
    payment_date DATE NOT NULL,
    capitation_amount_received DECIMAL(10,2) NOT NULL CHECK (capitation_amount_received >= 0),
    disbursement_cycle VARCHAR(20) NOT NULL,
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_gov_fund_policy FOREIGN KEY (policy_id) REFERENCES policies(policy_id) ON DELETE RESTRICT,
    CONSTRAINT fk_gov_fund_prog FOREIGN KEY (program_id) REFERENCES government_programs(program_id) ON DELETE RESTRICT
);

-- MEMBER_COMPLAINTS: Operational error and appeal logs.
CREATE TABLE member_complaints (
    complaint_id VARCHAR(20) PRIMARY KEY,
    member_id VARCHAR(15) NOT NULL,
    claim_id VARCHAR(20), -- Nullable: Complaints might not always be about a specific claim
    complaint_type VARCHAR(50) NOT NULL,
    submission_date DATE NOT NULL,
    complaint_text TEXT NOT NULL,
    current_status VARCHAR(20) NOT NULL CHECK (current_status IN ('Open', 'Investigating', 'Resolved', 'Closed')),
    resolution_notes TEXT,
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_comp_member FOREIGN KEY (member_id) REFERENCES members(member_id) ON DELETE RESTRICT,
    CONSTRAINT fk_comp_claim FOREIGN KEY (claim_id) REFERENCES claims_header(claim_id) ON DELETE RESTRICT
);

-- PROVIDER_GRIEVANCES: Legal appeals and contract disputes.
CREATE TABLE provider_grievances (
    provider_grievance_id VARCHAR(20) PRIMARY KEY,
    facility_id VARCHAR(15) NOT NULL,
    disputed_claim_id VARCHAR(20) NOT NULL,
    dispute_reason VARCHAR(100) NOT NULL,
    disputed_amount DECIMAL(10,2) NOT NULL CHECK (disputed_amount >= 0),
    submission_date DATE NOT NULL,
    resolution_status VARCHAR(20) NOT NULL CHECK (resolution_status IN ('Filed', 'Mediation', 'Resolved in favor of Provider', 'Upheld by Insurer')),
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_griev_facility FOREIGN KEY (facility_id) REFERENCES facilities(facility_id) ON DELETE RESTRICT,
    CONSTRAINT fk_griev_claim FOREIGN KEY (disputed_claim_id) REFERENCES claims_header(claim_id) ON DELETE RESTRICT
);

-- PROVIDER_REVIEWS: Member feedback and quality analytics.
CREATE TABLE provider_reviews (
    review_id VARCHAR(20) PRIMARY KEY,
    member_id VARCHAR(15) NOT NULL,
    practitioner_id VARCHAR(15), -- Nullable if reviewing just the facility
    facility_id VARCHAR(15) NOT NULL,
    claim_id VARCHAR(20), -- Authentic visit verification (Nullable)
    rating_score INT NOT NULL CHECK (rating_score >= 1 AND rating_score <= 5),
    review_text TEXT,
    review_date DATE NOT NULL,
    
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_rev_member FOREIGN KEY (member_id) REFERENCES members(member_id) ON DELETE RESTRICT,
    CONSTRAINT fk_rev_practitioner FOREIGN KEY (practitioner_id) REFERENCES practitioners(practitioner_id) ON DELETE RESTRICT,
    CONSTRAINT fk_rev_facility FOREIGN KEY (facility_id) REFERENCES facilities(facility_id) ON DELETE RESTRICT,
    CONSTRAINT fk_rev_claim FOREIGN KEY (claim_id) REFERENCES claims_header(claim_id) ON DELETE RESTRICT
);