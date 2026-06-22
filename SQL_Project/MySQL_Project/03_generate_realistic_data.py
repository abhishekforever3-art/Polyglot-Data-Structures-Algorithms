import mysql.connector
from faker import Faker
import random

# Initialize Faker
fake = Faker()

# 1. Connect to your MySQL Database
try:
    db = mysql.connector.connect(
        host="localhost",
        user="root",
        password="1234", 
        database="uplift_healthcare"
    )
    cursor = db.cursor()
    print("✅ Successfully connected to the Uplift Database!")
except Exception as e:
    print(f"❌ Connection Failed: {e}")
    exit()

# 2. Generator Functions for Tier 1
def seed_coverage_plans(num_rows=100):
    print(f"Generating {num_rows} Coverage Plans...")
    plans_data = []
    plan_types = ['PPO', 'HMO', 'EPO', 'POS', 'HDHP']
    
    for i in range(num_rows):
        plan_id = f"PLN-{fake.unique.random_int(min=10000, max=99999)}"
        plan_name = f"{fake.company()} {random.choice(plan_types)} Plan"
        plan_type = random.choice(plan_types)
        base_monthly = round(random.uniform(200.0, 1200.0), 2)
        base_annual = base_monthly * 12
        deductible = round(random.uniform(500.0, 5000.0), 2)
        copay = round(random.uniform(10.0, 75.0), 2)
        coinsurance = random.choice([10, 20, 30, 40])
        oop_max = round(random.uniform(3000.0, 15000.0), 2)
        
        plans_data.append((plan_id, plan_name, plan_type, base_monthly, base_annual, deductible, copay, coinsurance, oop_max))

    sql = """INSERT IGNORE INTO COVERAGE_PLANS 
             (plan_id, plan_name, plan_type, base_monthly_rate, base_annual_rate, annual_deductible, copay_amount, coinsurance_percentage, out_of_pocket_max) 
             VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s)"""
    
    cursor.executemany(sql, plans_data)
    db.commit()
    print("✅ Coverage Plans Seeded!")
    return [row[0] for row in plans_data] # Return the list of valid plan_ids!

def seed_facilities(num_rows=100):
    print(f"Generating {num_rows} Facilities...")
    facilities_data = []
    fac_types = ['Hospital', 'Urgent Care', 'Specialty Clinic', 'Lab', 'Rehab Center']
    net_status = ['IN-NETWORK', 'OUT-OF-NETWORK']
    
    for i in range(num_rows):
        fac_id = f"FAC-{fake.unique.random_int(min=10000, max=99999)}"
        name = f"{fake.last_name()} {random.choice(fac_types)}"
        fac_type = random.choice(fac_types)
        status = random.choice(net_status)
        address = fake.address().replace('\n', ', ')
        
        facilities_data.append((fac_id, name, fac_type, status, address))

    sql = """INSERT IGNORE INTO FACILITIES 
             (facility_id, facility_name, facility_type, network_status, facility_address) 
             VALUES (%s, %s, %s, %s, %s)"""
    
    cursor.executemany(sql, facilities_data)
    db.commit()
    print("✅ Facilities Seeded!")
    return [row[0] for row in facilities_data]

def seed_policies(valid_plan_ids, num_rows=100):
    print(f"Generating {num_rows} Policies...")
    policies_data = []
    statuses = ['ACTIVE', 'ACTIVE', 'ACTIVE', 'TERMINATED'] # Weighted towards active
    
    for i in range(num_rows):
        policy_id = f"POL-{fake.unique.random_int(min=100000, max=999999)}"
        plan_id = random.choice(valid_plan_ids)
        first_name = fake.first_name()
        last_name = fake.last_name()
        status = random.choice(statuses)
        effective_date = fake.date_between(start_date='-2y', end_date='today')
        termination_date = None if status == 'ACTIVE' else fake.date_between(start_date=effective_date, end_date='today')
        premium = round(random.uniform(300.0, 1500.0), 2)
        
        policies_data.append((policy_id, plan_id, first_name, last_name, status, effective_date, termination_date, premium))

    sql = """INSERT IGNORE INTO POLICIES 
             (policy_id, plan_id, policy_holder_first_name, policy_holder_last_name, policy_status, effective_date, termination_date, premium_amount) 
             VALUES (%s, %s, %s, %s, %s, %s, %s, %s)"""
    
    cursor.executemany(sql, policies_data)
    db.commit()
    print("✅ Policies Seeded!")
    return [row[0] for row in policies_data]

def seed_members(valid_policy_ids, num_rows=150):
    print(f"Generating {num_rows} Members (with family networks)...")
    members_data = []
    
    # First, create Primary Subscribers
    primary_member_ids = []
    for i in range(100):
        member_id = f"MEM-{fake.unique.random_int(min=100000, max=999999)}"
        policy_id = random.choice(valid_policy_ids)
        first_name = fake.first_name()
        last_name = fake.last_name()
        dob = fake.date_of_birth(minimum_age=18, maximum_age=80)
        gender = random.choice(['M', 'F'])
        
        members_data.append((member_id, policy_id, None, first_name, last_name, dob, gender, 'SELF', 'ACTIVE'))
        primary_member_ids.append(member_id)

    # Next, create Dependents linked to those Primary Subscribers
    for i in range(50):
        dependent_id = f"MEM-{fake.unique.random_int(min=100000, max=999999)}"
        primary_link = random.choice(primary_member_ids)
        # Find the policy_id of the primary member to ensure they match
        policy_id = next(m[1] for m in members_data if m[0] == primary_link)
        
        first_name = fake.first_name()
        last_name = next(m[4] for m in members_data if m[0] == primary_link) # Match family name
        dob = fake.date_of_birth(minimum_age=0, maximum_age=25)
        gender = random.choice(['M', 'F'])
        relationship = random.choice(['SPOUSE', 'CHILD'])
        
        members_data.append((dependent_id, policy_id, primary_link, first_name, last_name, dob, gender, relationship, 'ACTIVE'))

    sql = """INSERT IGNORE INTO MEMBERS 
             (member_id, policy_id, primary_member_id, first_name, last_name, date_of_birth, gender, relationship_to_holder, member_status) 
             VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s)"""
    
    cursor.executemany(sql, members_data)
    db.commit()
    print("✅ Members Seeded!")

def seed_tier3_and_4(valid_facility_ids):
    print("Fetching generated Member IDs...")
    # Fetch the members we just created straight from the database
    cursor.execute("SELECT member_id FROM MEMBERS")
    valid_members = [row[0] for row in cursor.fetchall()]

    print("Generating Static Lookups & 50 Practitioners...")
    # Insert required Tier 1 lookups safely (IGNORE prevents errors if run twice)
    cursor.execute("INSERT IGNORE INTO SPECIALTIES (specialty_id, specialty_name) VALUES ('SPEC-01', 'General Practice')")
    cursor.execute("INSERT IGNORE INTO DENIAL_REASON_CODES (denial_code, description) VALUES ('DEN-001', 'Not Covered')")

    prac_data = []
    for i in range(50):
        prac_id = f"DOC-{fake.unique.random_int(min=10000, max=99999)}"
        prac_data.append((prac_id, 'SPEC-01', fake.first_name(), fake.last_name(), f"LIC-{fake.unique.random_int(min=100000, max=999999)}", 'IN-NETWORK'))
    
    # UPDATE 1: Added IGNORE here
    cursor.executemany("""INSERT IGNORE INTO PRACTITIONERS 
                          (practitioner_id, specialty_id, first_name, last_name, license_number, network_status) 
                          VALUES (%s, %s, %s, %s, %s, %s)""", prac_data)
    valid_practitioners = [row[0] for row in prac_data]

    print("Generating 200 Encounters (Prior Auths, Claims, & Line Items)...")
    auth_data = []
    header_data = []
    line_data = []
    
    for i in range(200):
        # 1. Gatekeeper: Prior Auth
        auth_id = f"AUTH-{fake.unique.random_int(min=100000, max=999999)}"
        mem_id = random.choice(valid_members)
        prac_id = random.choice(valid_practitioners)
        eff_date = fake.date_between(start_date='-1y', end_date='today')
        auth_data.append((auth_id, mem_id, prac_id, '99213', 'APPROVED', eff_date, eff_date))

        # 2. Hub: Claim Header
        claim_id = f"CLM-{fake.unique.random_int(min=1000000, max=9999999)}"
        fac_id = random.choice(valid_facility_ids)
        billed_total = round(random.uniform(200.0, 5000.0), 2)
        header_data.append((claim_id, mem_id, fac_id, prac_id, auth_id, eff_date, billed_total, 'PROCESSING'))

        # 3. Child: Claim Line Item (Simulating 1 major procedure per claim)
        line_id = f"LIN-{fake.unique.random_int(min=10000000, max=99999999)}"
        allowed = round(billed_total * 0.8, 2) # Insurance negotiates 20% off
        paid = round(allowed * 0.9, 2)         # Insurance pays 90% of allowed
        line_data.append((line_id, claim_id, '99213', 'Z00.0', billed_total, round(billed_total - allowed, 2), allowed, paid))

    # UPDATE 2: Added IGNORE here
    cursor.executemany("""INSERT IGNORE INTO PRIOR_AUTHORIZATIONS 
                          (auth_id, member_id, requesting_practitioner_id, procedure_code, auth_status, effective_date, expiration_date) 
                          VALUES (%s, %s, %s, %s, %s, %s, %s)""", auth_data)
    
    # UPDATE 3: Added IGNORE here
    cursor.executemany("""INSERT IGNORE INTO CLAIMS_HEADER 
                          (claim_id, member_id, facility_id, rendering_practitioner_id, prior_auth_id, date_of_service, total_billed_amount, claim_status) 
                          VALUES (%s, %s, %s, %s, %s, %s, %s, %s)""", header_data)
    
    # UPDATE 4: Added IGNORE here
    cursor.executemany("""INSERT IGNORE INTO CLAIM_LINE_ITEMS 
                          (line_item_id, claim_id, procedure_code, diagnosis_code, billed_amount, contractual_write_off, allowed_amount, paid_amount) 
                          VALUES (%s, %s, %s, %s, %s, %s, %s, %s)""", line_data)

    db.commit()
    print("✅ Tier 3 & Tier 4 Core Workflow Seeded!")

# 3. Execution Block
print("🚀 Starting Data Generation...")

valid_plan_ids = seed_coverage_plans(100)
valid_facility_ids = seed_facilities(100)

valid_policy_ids = seed_policies(valid_plan_ids, 100)
seed_members(valid_policy_ids, 150)

# Pass the valid hospital IDs to the final workflow generator
seed_tier3_and_4(valid_facility_ids)

print("🎉 Enterprise Database Fully Generated!")

cursor.close()
db.close()