package oops.Banking;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== 1. CREATING CUSTOMERS ===");
        
        long personalId = bank.createPersonalCustomer(
            "Abhishek Gundabathula", 
            "Hyderabad, Telangana", 
            "9876543210", 
            "040123456"
        );
        System.out.println("Personal Customer created successfully. ID: " + personalId);

        long commercialId = bank.createCommercialCustomer(
            "Outskillai Corp", 
            "Mumbai, Maharashtra", 
            "Alex Carter", 
            "9998887776"
        );
        System.out.println("Commercial Customer created successfully. ID: " + commercialId);


        System.out.println("\n=== 2. DEPOSITING FUNDS ===");
        
        // Test deposits (Amounts must be greater than 0)
        System.out.print("Depositing 5000.00 into Personal Account: ");
        if (bank.deposit(personalId, 5000.00)) {
            System.out.println("Success!");
        } else {
            System.out.println("Failed.");
        }

        System.out.print("Depositing 12000.50 into Commercial Account: ");
        if (bank.deposit(commercialId, 12000.50)) {
            System.out.println("Success!");
        } else {
            System.out.println("Failed.");
        }


        System.out.println("\n=== 3. WITHDRAWING FUNDS ===");
        
        System.out.print("Withdrawing 2000.00 from Personal Account: ");
        int statusSuccess = bank.withdraw(personalId, 2000.00);
        System.out.println("Status Code (" + statusSuccess + ") -> Success");

        System.out.print("Withdrawing 20000.00 from Commercial Account (Overdraft Test): ");
        int statusFail = bank.withdraw(commercialId, 20000.00);
        System.out.println("Status Code (" + statusFail + ") -> Failed (Insufficient Balance)");


        System.out.println("\n=== 4. DISPLAYING SINGLE CUSTOMER DETAILS ===");
        
        Customer customerObj = bank.getCustomer(personalId);
        if (customerObj != null) {
            System.out.println("Customer Name : " + customerObj.getName());
            System.out.println("Customer ID   : " + customerObj.getCustomerId());
            System.out.println("Account Number: " + customerObj.getAccount().getAccountNumber());
            System.out.println("Current Balance: INR " + customerObj.getAccount().getBalance());
            System.out.println("Date Account Opened: " + customerObj.getAccount().getDateOpened());
        } else {
            System.out.println("Error: Customer not found.");
        }


        System.out.println("\n=== 5. DISPLAYING BANK AGGREGATE VALUE ===");
        
        double bankNetWorth = bank.totalValue();
        System.out.println("Sum total value of all accounts in system: INR " + bankNetWorth);
    }
}