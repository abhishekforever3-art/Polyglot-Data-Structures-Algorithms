from faker import Faker
import random

# Start the Faker engine
fake = Faker()

print("-- UPLIFT HEALTH: MOCK DATA FOR FACILITIES --")

# The exact rules we built into your SQL database
network_statuses = ['In-Network', 'Out-of-Network', 'Tier 1', 'Tier 2']
facility_types = ['Urgent Care', 'Hospital', 'Specialty Clinic', 'Primary Care']

# Create 10 fake facilities
for i in range(1, 11):
    facility_id = f"FAC-{i:03d}"
    
    # Generate fake names and clean up apostrophes for SQL
    company_name = fake.company().replace("'", "''") 
    facility_name = f"{company_name} Medical Center"
    
    facility_type = random.choice(facility_types)
    status = random.choice(network_statuses)
    
    # Generate fake addresses and put them on one line
    address = fake.address().replace("\n", ", ").replace("'", "''")

    # Build the perfect SQL INSERT statement
    sql = f"INSERT INTO facilities (facility_id, facility_name, facility_type, network_status, facility_address) VALUES ('{facility_id}', '{facility_name}', '{facility_type}', '{status}', '{address}');"
    
    print(sql)