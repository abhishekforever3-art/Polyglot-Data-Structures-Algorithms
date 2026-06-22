USE uplift_healthcare;

-- ==========================================
-- CATCH-UP: Remaining Tier 2 Bridging Tables
-- ==========================================

CREATE TABLE POLICY_RIDERS (
    policy_rider_id VARCHAR(20) PRIMARY KEY,
    policy_id VARCHAR(15) NOT NULL,
    rider_id VARCHAR(10) NOT NULL,
    additional_premium_amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (policy_id) REFERENCES POLICIES(policy_id),
    FOREIGN KEY (rider_id) REFERENCES RIDERS(rider_id)
) ENGINE=InnoDB;

CREATE TABLE PROVIDER_CONTRACTS (
    contract_id VARCHAR(15) PRIMARY KEY,
    facility_id VARCHAR(15) NOT NULL,
    procedure_code VARCHAR(10) NOT NULL,
    negotiated_package_rate DECIMAL(10,2) NOT NULL,
    effective_date DATE NOT NULL,
    expiration_date DATE NOT NULL,
    FOREIGN KEY (facility_id) REFERENCES FACILITIES(facility_id)
) ENGINE=InnoDB;

-- ==========================================
-- TIER 4: Audit Logs & Accumulators
-- ==========================================

CREATE TABLE MEMBER_ACCUMULATORS (
    accumulator_id VARCHAR(20) PRIMARY KEY,
    member_id VARCHAR(15) NOT NULL,
    benefit_year INT NOT NULL,
    current_deductible_met DECIMAL(10,2) NOT NULL,
    current_oop_max_met DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (member_id) REFERENCES MEMBERS(member_id)
) ENGINE=InnoDB;

CREATE TABLE CLAIM_ADJUDICATION_LOGS (
    log_id VARCHAR(20) PRIMARY KEY,
    claim_id VARCHAR(20) NOT NULL,
    denial_code VARCHAR(10) NOT NULL,
    adjudicated_by VARCHAR(50) NOT NULL,
    review_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (claim_id) REFERENCES CLAIMS_HEADER(claim_id),
    FOREIGN KEY (denial_code) REFERENCES DENIAL_REASON_CODES(denial_code)
) ENGINE=InnoDB;

CREATE TABLE HIGH_DOLLAR_CLAIMS_REVIEW (
    review_id VARCHAR(20) PRIMARY KEY,
    claim_id VARCHAR(20) NOT NULL,
    audit_status VARCHAR(30) NOT NULL,
    assigned_physician_reviewer VARCHAR(50) NOT NULL,
    recovered_savings_amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (claim_id) REFERENCES CLAIMS_HEADER(claim_id)
) ENGINE=InnoDB;

-- ==========================================
-- TIER 4: Outbound Middleware
-- ==========================================

CREATE TABLE CLAIM_DISBURSEMENTS (
    disbursement_id VARCHAR(25) PRIMARY KEY,
    claim_id VARCHAR(20) NOT NULL,
    facility_id VARCHAR(15) NOT NULL,
    check_or_eft_number VARCHAR(50) NOT NULL,
    disbursement_date DATE NOT NULL,
    FOREIGN KEY (claim_id) REFERENCES CLAIMS_HEADER(claim_id),
    FOREIGN KEY (facility_id) REFERENCES FACILITIES(facility_id)
) ENGINE=InnoDB;

CREATE TABLE VENDOR_PAYMENT_CLEARINGHOUSE (
    transmission_id VARCHAR(25) PRIMARY KEY,
    claim_id VARCHAR(20) NOT NULL,
    vendor_name VARCHAR(50) NOT NULL,
    payment_method_type VARCHAR(20) NOT NULL,
    transmission_status VARCHAR(20) NOT NULL,
    vendor_reference_number VARCHAR(50),
    sent_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    cleared_timestamp TIMESTAMP NULL,
    FOREIGN KEY (claim_id) REFERENCES CLAIMS_HEADER(claim_id)
) ENGINE=InnoDB;

CREATE TABLE PROVIDER_CLAIM_CORRECTIONS (
    correction_id VARCHAR(25) PRIMARY KEY,
    original_claim_id VARCHAR(20) NOT NULL,
    provider_facility_id VARCHAR(15) NOT NULL,
    correction_reason VARCHAR(255) NOT NULL,
    review_status VARCHAR(20) NOT NULL,
    new_submitted_json_payload TEXT NOT NULL,
    assigned_auditor_id VARCHAR(50) NOT NULL,
    FOREIGN KEY (original_claim_id) REFERENCES CLAIMS_HEADER(claim_id),
    FOREIGN KEY (provider_facility_id) REFERENCES FACILITIES(facility_id)
) ENGINE=InnoDB;

CREATE TABLE REINSURANCE_STOP_LOSS_CLAIMS (
    reinsurance_claim_id VARCHAR(25) PRIMARY KEY,
    claim_id VARCHAR(20) NOT NULL,
    attachment_point_threshold DECIMAL(10,2) NOT NULL,
    amount_recovered_from_reinsurer DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (claim_id) REFERENCES CLAIMS_HEADER(claim_id)
) ENGINE=InnoDB;

-- ==========================================
-- TIER 4: Compliance & Subsidies
-- ==========================================

CREATE TABLE GOVERNMENT_FUNDING_LEDGER (
    funding_entry_id VARCHAR(20) PRIMARY KEY,
    policy_id VARCHAR(15) NOT NULL,
    program_id VARCHAR(10) NOT NULL,
    payment_date DATE NOT NULL,
    capitation_amount_received DECIMAL(10,2) NOT NULL,
    disbursement_cycle VARCHAR(20) NOT NULL,
    FOREIGN KEY (policy_id) REFERENCES POLICIES(policy_id),
    FOREIGN KEY (program_id) REFERENCES GOVERNMENT_PROGRAMS(program_id)
) ENGINE=InnoDB;

CREATE TABLE MEMBER_COMPLAINTS (
    complaint_id VARCHAR(20) PRIMARY KEY,
    member_id VARCHAR(15) NOT NULL,
    claim_id VARCHAR(20), 
    complaint_type VARCHAR(50) NOT NULL,
    submission_date DATE NOT NULL,
    complaint_text TEXT NOT NULL,
    current_status VARCHAR(20) NOT NULL,
    resolution_notes TEXT,
    FOREIGN KEY (member_id) REFERENCES MEMBERS(member_id),
    FOREIGN KEY (claim_id) REFERENCES CLAIMS_HEADER(claim_id)
) ENGINE=InnoDB;

CREATE TABLE PROVIDER_GRIEVANCES (
    provider_grievance_id VARCHAR(20) PRIMARY KEY,
    facility_id VARCHAR(15) NOT NULL,
    disputed_claim_id VARCHAR(20) NOT NULL,
    dispute_reason VARCHAR(255) NOT NULL,
    disputed_amount DECIMAL(10,2) NOT NULL,
    submission_date DATE NOT NULL,
    resolution_status VARCHAR(20) NOT NULL,
    FOREIGN KEY (facility_id) REFERENCES FACILITIES(facility_id),
    FOREIGN KEY (disputed_claim_id) REFERENCES CLAIMS_HEADER(claim_id)
) ENGINE=InnoDB;

CREATE TABLE PROVIDER_REVIEWS (
    review_id VARCHAR(20) PRIMARY KEY,
    member_id VARCHAR(15) NOT NULL,
    practitioner_id VARCHAR(15),
    facility_id VARCHAR(15) NOT NULL,
    claim_id VARCHAR(20),
    rating_score INT NOT NULL,
    review_text TEXT,
    review_date DATE NOT NULL,
    FOREIGN KEY (member_id) REFERENCES MEMBERS(member_id),
    FOREIGN KEY (practitioner_id) REFERENCES PRACTITIONERS(practitioner_id),
    FOREIGN KEY (facility_id) REFERENCES FACILITIES(facility_id),
    FOREIGN KEY (claim_id) REFERENCES CLAIMS_HEADER(claim_id)
) ENGINE=InnoDB;