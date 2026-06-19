-- ==============================================================================
-- UPLIFT HEALTH INSURANCE: MASTER SCHEMA (27 TABLES - MySQL InnoDB)
-- Relationships: Foreign Key Constraints applied for data integrity.
-- ==============================================================================

-- --- CATEGORY 1: MEMBERS & CORE ---
CREATE TABLE members (member_id INT AUTO_INCREMENT PRIMARY KEY, first_name VARCHAR(50), last_name VARCHAR(50), dob DATE, gender VARCHAR(10), ssn VARCHAR(11)) ENGINE=InnoDB;
CREATE TABLE dependents (dependent_id INT AUTO_INCREMENT PRIMARY KEY, member_id INT, name VARCHAR(50), relationship VARCHAR(20), CONSTRAINT fk_dep_mem FOREIGN KEY (member_id) REFERENCES members(member_id)) ENGINE=InnoDB;
CREATE TABLE addresses (address_id INT AUTO_INCREMENT PRIMARY KEY, member_id INT, street VARCHAR(100), city VARCHAR(50), state VARCHAR(2), zip VARCHAR(10), CONSTRAINT fk_addr_mem FOREIGN KEY (member_id) REFERENCES members(member_id)) ENGINE=InnoDB;
CREATE TABLE contact_info (contact_id INT AUTO_INCREMENT PRIMARY KEY, member_id INT, phone VARCHAR(20), email VARCHAR(100), CONSTRAINT fk_cont_mem FOREIGN KEY (member_id) REFERENCES members(member_id)) ENGINE=InnoDB;

-- --- CATEGORY 2: PROVIDERS & FACILITIES ---
CREATE TABLE facilities (facility_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), type VARCHAR(50)) ENGINE=InnoDB;
CREATE TABLE providers (provider_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), specialty VARCHAR(50), npi_number VARCHAR(20)) ENGINE=InnoDB;
CREATE TABLE facility_network (map_id INT AUTO_INCREMENT PRIMARY KEY, facility_id INT, network_status VARCHAR(20), CONSTRAINT fk_net_fac FOREIGN KEY (facility_id) REFERENCES facilities(facility_id)) ENGINE=InnoDB;
CREATE TABLE provider_facility_link (link_id INT AUTO_INCREMENT PRIMARY KEY, provider_id INT, facility_id INT, CONSTRAINT fk_link_prov FOREIGN KEY (provider_id) REFERENCES providers(provider_id), CONSTRAINT fk_link_fac FOREIGN KEY (facility_id) REFERENCES facilities(facility_id)) ENGINE=InnoDB;

-- --- CATEGORY 3: POLICIES & COVERAGE ---
CREATE TABLE plans (plan_id INT AUTO_INCREMENT PRIMARY KEY, plan_name VARCHAR(50), annual_deductible DECIMAL(10,2)) ENGINE=InnoDB;
CREATE TABLE policy_header (policy_id INT AUTO_INCREMENT PRIMARY KEY, member_id INT, plan_id INT, start_date DATE, end_date DATE, CONSTRAINT fk_pol_mem FOREIGN KEY (member_id) REFERENCES members(member_id), CONSTRAINT fk_pol_plan FOREIGN KEY (plan_id) REFERENCES plans(plan_id)) ENGINE=InnoDB;
CREATE TABLE policy_riders (rider_id INT AUTO_INCREMENT PRIMARY KEY, policy_id INT, coverage_type VARCHAR(50), CONSTRAINT fk_rid_pol FOREIGN KEY (policy_id) REFERENCES policy_header(policy_id)) ENGINE=InnoDB;
CREATE TABLE premiums (premium_id INT AUTO_INCREMENT PRIMARY KEY, policy_id INT, amount DECIMAL(10,2), due_date DATE, CONSTRAINT fk_prem_pol FOREIGN KEY (policy_id) REFERENCES policy_header(policy_id)) ENGINE=InnoDB;

-- --- CATEGORY 4: CLAIMS MANAGEMENT ---
CREATE TABLE claims_header (claim_id INT AUTO_INCREMENT PRIMARY KEY, policy_id INT, date_of_service DATE, total_billed DECIMAL(10,2), CONSTRAINT fk_claim_pol FOREIGN KEY (policy_id) REFERENCES policy_header(policy_id)) ENGINE=InnoDB;
CREATE TABLE claim_lines (line_id INT AUTO_INCREMENT PRIMARY KEY, claim_id INT, cpt_code VARCHAR(10), amount DECIMAL(10,2), CONSTRAINT fk_line_claim FOREIGN KEY (claim_id) REFERENCES claims_header(claim_id)) ENGINE=InnoDB;
CREATE TABLE claim_status_history (history_id INT AUTO_INCREMENT PRIMARY KEY, claim_id INT, status VARCHAR(20), changed_at DATETIME, CONSTRAINT fk_hist_claim FOREIGN KEY (claim_id) REFERENCES claims_header(claim_id)) ENGINE=InnoDB;
CREATE TABLE medical_codes (code VARCHAR(10) PRIMARY KEY, description TEXT) ENGINE=InnoDB;

-- --- CATEGORY 5: PAYMENTS & SUBSIDIES ---
CREATE TABLE payments (payment_id INT AUTO_INCREMENT PRIMARY KEY, claim_id INT, paid_amount DECIMAL(10,2), payment_date DATE, CONSTRAINT fk_pay_claim FOREIGN KEY (claim_id) REFERENCES claims_header(claim_id)) ENGINE=InnoDB;
CREATE TABLE bank_details (bank_id INT AUTO_INCREMENT PRIMARY KEY, member_id INT, account_number VARCHAR(20), CONSTRAINT fk_bank_mem FOREIGN KEY (member_id) REFERENCES members(member_id)) ENGINE=InnoDB;
CREATE TABLE govt_subsidies (subsidy_id INT AUTO_INCREMENT PRIMARY KEY, policy_id INT, subsidy_amount DECIMAL(10,2), CONSTRAINT fk_sub_pol FOREIGN KEY (policy_id) REFERENCES policy_header(policy_id)) ENGINE=InnoDB;
CREATE TABLE subsidy_programs (program_id INT AUTO_INCREMENT PRIMARY KEY, program_name VARCHAR(50)) ENGINE=InnoDB;

-- --- CATEGORY 6: ADMIN, AUDIT & ANALYTICS ---
CREATE TABLE audit_logs (log_id INT AUTO_INCREMENT PRIMARY KEY, table_name VARCHAR(50), action VARCHAR(20), user_id INT, ts DATETIME) ENGINE=InnoDB;
CREATE TABLE documents (doc_id INT AUTO_INCREMENT PRIMARY KEY, member_id INT, doc_type VARCHAR(50), upload_date DATE, CONSTRAINT fk_doc_mem FOREIGN KEY (member_id) REFERENCES members(member_id)) ENGINE=InnoDB;
CREATE TABLE feedback (feedback_id INT AUTO_INCREMENT PRIMARY KEY, member_id INT, rating INT, comments TEXT, CONSTRAINT fk_feed_mem FOREIGN KEY (member_id) REFERENCES members(member_id)) ENGINE=InnoDB;
CREATE TABLE pharmacy_claims (rx_id INT AUTO_INCREMENT PRIMARY KEY, claim_id INT, drug_name VARCHAR(50), cost DECIMAL(10,2), CONSTRAINT fk_rx_claim FOREIGN KEY (claim_id) REFERENCES claims_header(claim_id)) ENGINE=InnoDB;
CREATE TABLE pre_authorizations (auth_id INT AUTO_INCREMENT PRIMARY KEY, claim_id INT, status VARCHAR(20), CONSTRAINT fk_auth_claim FOREIGN KEY (claim_id) REFERENCES claims_header(claim_id)) ENGINE=InnoDB;
CREATE TABLE staff (staff_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), role VARCHAR(20)) ENGINE=InnoDB;
CREATE TABLE internal_notes (note_id INT AUTO_INCREMENT PRIMARY KEY, claim_id INT, note TEXT, CONSTRAINT fk_note_claim FOREIGN KEY (claim_id) REFERENCES claims_header(claim_id)) ENGINE=InnoDB;