USE uplift_healthcare;

-- 1. PRIOR_AUTHORIZATIONS (The Access Gatekeeper)
CREATE TABLE PRIOR_AUTHORIZATIONS (
    auth_id VARCHAR(15) PRIMARY KEY,
    member_id VARCHAR(15) NOT NULL,
    requesting_practitioner_id VARCHAR(15) NOT NULL,
    procedure_code VARCHAR(10) NOT NULL,
    auth_status VARCHAR(20) NOT NULL,
    effective_date DATE NOT NULL,
    expiration_date DATE NOT NULL,
    FOREIGN KEY (member_id) REFERENCES MEMBERS(member_id),
    FOREIGN KEY (requesting_practitioner_id) REFERENCES PRACTITIONERS(practitioner_id)
) ENGINE=InnoDB;

-- 2. CLAIMS_HEADER (The Encounter Hub)
CREATE TABLE CLAIMS_HEADER (
    claim_id VARCHAR(20) PRIMARY KEY,
    member_id VARCHAR(15) NOT NULL,
    facility_id VARCHAR(15) NOT NULL,
    rendering_practitioner_id VARCHAR(15) NOT NULL,
    prior_auth_id VARCHAR(15), 
    date_of_service DATE NOT NULL,
    total_billed_amount DECIMAL(10,2) NOT NULL,
    claim_status VARCHAR(20) NOT NULL,
    FOREIGN KEY (member_id) REFERENCES MEMBERS(member_id),
    FOREIGN KEY (facility_id) REFERENCES FACILITIES(facility_id),
    FOREIGN KEY (rendering_practitioner_id) REFERENCES PRACTITIONERS(practitioner_id),
    FOREIGN KEY (prior_auth_id) REFERENCES PRIOR_AUTHORIZATIONS(auth_id)
) ENGINE=InnoDB;

-- 3. CLAIM_LINE_ITEMS (Itemized Cost Breakdown)
CREATE TABLE CLAIM_LINE_ITEMS (
    line_item_id VARCHAR(25) PRIMARY KEY,
    claim_id VARCHAR(20) NOT NULL,
    procedure_code VARCHAR(10) NOT NULL,
    diagnosis_code VARCHAR(10) NOT NULL,
    billed_amount DECIMAL(10,2) NOT NULL,
    contractual_write_off DECIMAL(10,2) NOT NULL,
    allowed_amount DECIMAL(10,2) NOT NULL,
    paid_amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (claim_id) REFERENCES CLAIMS_HEADER(claim_id)
) ENGINE=InnoDB;

-- 4. PREMIUM_PAYMENTS (Inbound Revenue)
CREATE TABLE PREMIUM_PAYMENTS (
    payment_id VARCHAR(20) PRIMARY KEY,
    policy_id VARCHAR(15) NOT NULL,
    payment_date DATE NOT NULL,
    amount_paid DECIMAL(10,2) NOT NULL,
    payment_method VARCHAR(20) NOT NULL,
    billing_period VARCHAR(7) NOT NULL,
    FOREIGN KEY (policy_id) REFERENCES POLICIES(policy_id)
) ENGINE=InnoDB;

-- 5. MEMBER_OTHER_INSURANCE (Coordination of Benefits)
CREATE TABLE MEMBER_OTHER_INSURANCE (
    cob_id VARCHAR(15) PRIMARY KEY,
    member_id VARCHAR(15) NOT NULL,
    other_insurer_name VARCHAR(50) NOT NULL,
    other_policy_number VARCHAR(30) NOT NULL,
    coverage_priority VARCHAR(10) NOT NULL,
    effective_date DATE NOT NULL,
    termination_date DATE,
    FOREIGN KEY (member_id) REFERENCES MEMBERS(member_id)
) ENGINE=InnoDB;

-- 6. MEMBER_WELLNESS_CLAIMS (Rewards Redemptions)
CREATE TABLE MEMBER_WELLNESS_CLAIMS (
    redemption_id VARCHAR(20) PRIMARY KEY,
    member_id VARCHAR(15) NOT NULL,
    benefit_perk_id VARCHAR(10) NOT NULL,
    submission_date DATE NOT NULL,
    proof_status VARCHAR(20) NOT NULL,
    disbursed_date DATE,
    FOREIGN KEY (member_id) REFERENCES MEMBERS(member_id),
    FOREIGN KEY (benefit_perk_id) REFERENCES WELLNESS_BENEFITS(benefit_perk_id)
) ENGINE=InnoDB;