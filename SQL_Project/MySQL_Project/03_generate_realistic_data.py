import random
from faker import Faker
import datetime

fake = Faker()

# Configuration
NUM_MEMBERS = 100
NUM_FACILITIES = 20
NUM_CLAIMS = 200

print("-- MOCK DATA FOR UPLIFT HEALTH INSURANCE --")
print("SET FOREIGN_KEY_CHECKS = 0;\n")

# 1. Members
members = []
for i in range(NUM_MEMBERS):
    m_id = i + 1
    members.append(m_id)
    print(f"INSERT INTO members VALUES ({m_id}, '{fake.first_name()}', '{fake.last_name()}', '{fake.date_of_birth(minimum_age=18, maximum_age=80)}', '{random.choice(['M', 'F'])}', '{fake.ssn()}');")

# 2. Facilities
for i in range(1, NUM_FACILITIES + 1):
    print(f"INSERT INTO facilities VALUES ({i}, '{fake.company()} Medical Center', '{random.choice(['Hospital', 'Clinic', 'Urgent Care'])}');")

# 3. Claims (Linking to existing Members/Facilities)
# We generate 200 claims
for i in range(1, NUM_CLAIMS + 1):
    m_id = random.choice(members)
    f_id = random.randint(1, NUM_FACILITIES)
    bill = round(random.uniform(100.0, 5000.0), 2)
    c_date = fake.date_between(start_date='-1y', end_date='today')
    print(f"INSERT INTO claims_header (claim_id, policy_id, date_of_service, total_billed) VALUES ({i}, {m_id}, '{c_date}', {bill});")

# 4. Payments (Linking to existing Claims)
for i in range(1, NUM_CLAIMS + 1):
    pay = round(random.uniform(50.0, 3000.0), 2)
    p_date = fake.date_between(start_date='-1y', end_date='today')
    print(f"INSERT INTO payments (payment_id, claim_id, paid_amount, payment_date) VALUES ({i}, {i}, {pay}, '{p_date}');")

print("\nSET FOREIGN_KEY_CHECKS = 1;")