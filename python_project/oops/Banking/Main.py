from Bank import Bank

if __name__ == "__main__":
    bank = Bank()

    print("=== 1. CREATING CUSTOMERS ===")
    
    personal_id = bank.create_personal_customer(
        "Abhishek Gundabathula", 
        "Hyderabad, Telangana", 
        "9876543210", 
        "040123456"
    )
    print(f"Personal Customer created successfully. ID: {personal_id}")

    commercial_id = bank.create_commercial_customer(
        "Outskillai Corp", 
        "Mumbai, Maharashtra", 
        "Alex Carter", 
        "9998887776"
    )
    print(f"Commercial Customer created successfully. ID: {commercial_id}")


    print("\n=== 2. DEPOSITING FUNDS ===")
    
    print("Depositing 5000.00 into Personal Account: ", end="")
    if bank.deposit(personal_id, 5000.00):
        print("Success!")
    else:
        print("Failed.")

    print("Depositing 12000.50 into Commercial Account: ", end="")
    if bank.deposit(commercial_id, 12000.50):
        print("Success!")
    else:
        print("Failed.")


    print("\n=== 3. WITHDRAWING FUNDS ===")
    
    print("Withdrawing 2000.00 from Personal Account: ", end="")
    status_success = bank.withdraw(personal_id, 2000.00)
    print(f"Status Code ({status_success}) -> Success")

    print("Withdrawing 20000.00 from Commercial Account (Overdraft Test): ", end="")
    status_fail = bank.withdraw(commercial_id, 20000.00)
    print(f"Status Code ({status_fail}) -> Failed (Insufficient Balance)")


    print("\n=== 4. DISPLAYING SINGLE CUSTOMER DETAILS ===")
    
    customer_obj = bank.get_customer(personal_id)
    if customer_obj is not None:
        print(f"Customer Name : {customer_obj.get_name()}")
        print(f"Customer ID   : {customer_obj.get_customer_id()}")
        print(f"Account Number: {customer_obj.get_account().get_account_number()}")
        print(f"Current Balance: INR {customer_obj.get_account().get_balance()}")
        print(f"Date Account Opened: {customer_obj.get_account().get_date_opened()}")
    else:
        print("Error: Customer not found.")


    print("\n=== 5. DISPLAYING BANK AGGREGATE VALUE ===")
    
    bank_net_worth = bank.total_value()
    print(f"Sum total value of all accounts in system: INR {bank_net_worth}")