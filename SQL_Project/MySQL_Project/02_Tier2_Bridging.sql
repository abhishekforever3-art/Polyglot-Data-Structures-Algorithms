USE uplift_healthcare;

-- 1. POLICIES (Connects to COVERAGE_PLANS)
CREATE TABLE POLICIES (
    policy_id VARCHAR(15) PRIMARY KEY,
    plan_id VARCHAR(10) NOT NULL,
    policy_holder_first_name VARCHAR(50) NOT NULL,
    policy_holder_last_name VARCHAR(50) NOT NULL,
    policy_status VARCHAR(15) NOT NULL,
    effective_date DATE NOT NULL,
    termination_date DATE,
    premium_amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (plan_id) REFERENCES COVERAGE_PLANS(plan_id)
) ENGINE=InnoDB;

-- 2. MEMBERS (Connects to POLICIES with a recursive relationship for families)
CREATE TABLE MEMBERS (
    member_id VARCHAR(15) PRIMARY KEY,
    policy_id VARCHAR(15) NOT NULL,
    primary_member_id VARCHAR(15),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL,
    gender VARCHAR(10) NOT NULL,
    relationship_to_holder VARCHAR(20) NOT NULL,
    member_status VARCHAR(15) NOT NULL,
    FOREIGN KEY (policy_id) REFERENCES POLICIES(policy_id),
    FOREIGN KEY (primary_member_id) REFERENCES MEMBERS(member_id)
) ENGINE=InnoDB;

-- 3. PRACTITIONERS (Connects to SPECIALTIES)
CREATE TABLE PRACTITIONERS (
    practitioner_id VARCHAR(15) PRIMARY KEY,
    specialty_id VARCHAR(10) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    license_number VARCHAR(30) UNIQUE NOT NULL,
    network_status VARCHAR(15) NOT NULL,
    FOREIGN KEY (specialty_id) REFERENCES SPECIALTIES(specialty_id)
) ENGINE=InnoDB;