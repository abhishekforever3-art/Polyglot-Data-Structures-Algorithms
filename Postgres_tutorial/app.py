# import psycopg2

# conn = psycopg2.connect(database="postgres",
#                         host="localhost",
#                         user="postgres",
#                         password="abcd",
#                         port="5432")

# cur = conn.cursor()

# # Create table

# # cur.execute("CREATE TABLE IF NOT EXISTS users (id serial PRIMARY KEY, name varchar(255), email varchar(255), password varchar(255))")
# # print("Table created successfully")

# # Insert data

# # cur.execute("INSERT INTO users (name, email, password) VALUES (%s, %s, %s)", ("emily", "emily@snow.com", "1111111111"))
# # conn.commit()

# # Get data

# cur.execute("SELECT * FROM users")

# rows = cur.fetchall()

# for row in rows:
#     print(row)

# # Close connection

# conn.close()

# # this is a simple example of how to connect to a Postgres database using psycopg2 in Python. The code establishes a connection to the database, creates a cursor object, and demonstrates how to create a table, insert data, retrieve data, and close the connection.
# # this can able to create tables, insert data, and retrieve data from the Postgres database. You can modify the code to suit your specific requirements, such as changing the table name, column names, and data types.