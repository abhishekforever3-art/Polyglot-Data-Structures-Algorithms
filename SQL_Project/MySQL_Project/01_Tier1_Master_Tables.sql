-- 1. Create and switch to your new database
CREATE DATABASE IF NOT EXISTS uplift_healthcare;
USE uplift_healthcare;

-- 2. Set strict mode to prevent bad data
SET SESSION sql_mode = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- 3. Create Tier 1 Tables
CREATE TABLE COVERAGE_PLANS (
    plan_id VARCHAR(10) PRIMARY KEY,
    plan_name VARCHAR(50) NOT NULL,
    plan_type VARCHAR(20) NOT NULL,
    base_monthly_rate DECIMAL(10,2) NOT NULL,
    base_annual_rate DECIMAL(10,2) NOT NULL,
    annual_deductible DECIMAL(10,2) NOT NULL,
    copay_amount DECIMAL(10,2) NOT NULL,
    coinsurance_percentage INT NOT NULL,
    out_of_pocket_max DECIMAL(10,2) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE RIDERS (
    rider_id VARCHAR(10) PRIMARY KEY,
    rider_name VARCHAR(50) NOT NULL,
    rider_type VARCHAR(30) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE FACILITIES (
    facility_id VARCHAR(15) PRIMARY KEY,
    facility_name VARCHAR(100) NOT NULL,
    facility_type VARCHAR(30) NOT NULL,
    network_status VARCHAR(15) NOT NULL,
    facility_address VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE SPECIALTIES (
    specialty_id VARCHAR(10) PRIMARY KEY,
    specialty_name VARCHAR(50) NOT NULL,
    description VARCHAR(255)
) ENGINE=InnoDB;

CREATE TABLE DENIAL_REASON_CODES (
    denial_code VARCHAR(10) PRIMARY KEY,
    description VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE WELLNESS_BENEFITS (
    benefit_perk_id VARCHAR(10) PRIMARY KEY,
    perk_name VARCHAR(100) NOT NULL,
    reward_type VARCHAR(30) NOT NULL,
    reward_value DECIMAL(10,2) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE GOVERNMENT_PROGRAMS (
    program_id VARCHAR(10) PRIMARY KEY,
    program_name VARCHAR(50) NOT NULL,
    government_agency VARCHAR(50) NOT NULL,
    funding_type VARCHAR(255) NOT NULL
) ENGINE=InnoDB;