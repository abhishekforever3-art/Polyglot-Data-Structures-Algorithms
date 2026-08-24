employee_data = {101: {'Name': 'Satya', 'Age': 27, 'Department': 'HR', 'Salary': 50000}}

def search_employee(emp_id):
    if emp_id in employee_data:
        print (f"employee id: {emp_id}")
        print (f"Name :{employee_data[emp_id]["Name"]}")
        print (f"Age :{employee_data[emp_id]["Age"]}")
        print (f"Department :{employee_data[emp_id]["Department"]}")
        print (f"Salary: Rs {employee_data[emp_id]["Salary"]}")
    else:
        print ("employee not found!")

def add_employee (emp_id, name , age , department, salary):
    if emp_id in employee_data:
        print ("employee already exists! please enter a new ID.")
    else:
        employee_data[emp_id] = {"Name": name , "Age": age , "Department": department, "Salary": salary}
        print ("employee added successfully!")
        
def view_employees ():
    if not employee_data:
        print ("No employees available.")
        return
    print(f"{'ID':<10} {'Name':<20} {'Age':<5} {'Department':<15} {'Salary':<10}")
    print("-" * 65)
    for emp_id, details in employee_data.items():
        name = details.get("Name", "N/A")
        age = details.get("Age", "N/A")
        dept = details.get("Department", "N/A")
        salary = details.get("Salary", "N/A")
        
        print(f"{emp_id:<10} {name:<20} {age:<5} {dept:<15} Rs {salary:<10}")
        
def main_menu():
    while True:
        print("\n--- Employee Management System ---")
        print("1. Add Employee")
        print("2. View All Employees")
        print("3. Search for Employee")
        print("4. Exit")
        
        choice = input("Enter your choice (1-4): ").strip()
        
        if choice == "1":
            emp_id = int(input("Enter Employee ID: "))
            name = input("Enter Name: ")
            age = int(input("Enter Age: "))
            dept = input("Enter Department: ")
            salary = float(input("Enter Salary: "))
            add_employee(emp_id, name, age, dept, salary)
            
        elif choice == "2":
            view_employees()
            
        elif choice == "3":
            emp_id = int(input("Enter Employee ID to search: "))
            search_employee(emp_id)
            
        elif choice == "4":
            print("Exiting system. Goodbye!")
            break
            
        else:
            print("Invalid choice! Please enter a number between 1 and 4.")
            
main_menu()