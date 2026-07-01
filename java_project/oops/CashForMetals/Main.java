package oops.CashForMetals;


import java.util.ArrayList;

public class Main {
    private static ArrayList<Customer> customerList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("*** Welcome to Cash for Metals Calculator!!! ***\n");

        PersonalCustomer pCust = new PersonalCustomer("Abhishek Gundabathula");
        pCust.setAddress("Vijayawada, AP");
        customerList.add(pCust);

        CommercialCustomer cCust = new CommercialCustomer("Global Bullion LLC");
        cCust.setAddress("Mumbai, MH");
        cCust.setContactPerson("Sarah Jenkins");
        customerList.add(cCust);

        recordMetalTransaction(pCust.getCustomerId(), 2.5, 12.0); // Personal
        recordMetalTransaction(cCust.getCustomerId(), 5.0, 40.0); // Commercial (Gets +3% bonus) 

        System.out.println("\n--- Processing Withdrawal ---");
        Customer c = findCustomer(pCust.getCustomerId());
        if (c != null) {
            double withdrawn = c.getAccount().makeWithdrawal(300.00);
            System.out.printf("Successfully withdrew: $%.2f from %s's account.\n", withdrawn, c.getName());
        }

        System.out.println("\n--- Grand Summary (All Customers) ---"); 
        for (Customer cust : customerList) {
            System.out.println(cust);
            System.out.println("  " + cust.getAccount());
            System.out.println("  Transactions:");
            for (Transaction tx : cust.getTransactions()) {
                System.out.println("    " + tx);
            }
        }

        System.out.println("\n--- Customer Summary Totals ---");
        System.out.println("Total Registered Customers: " + customerList.size());
        double totalBankCash = 0;
        for (Customer cust : customerList) {
            totalBankCash += cust.getAccount().getBalance();
        }
        System.out.printf("Sum Total Value of All Accounts: $%.2f\n", totalBankCash); 
    }

    private static void recordMetalTransaction(long id, double goldOz, double silverOz) {
        Customer cust = findCustomer(id);
        if (cust == null) {
            System.out.println("Error: Customer ID " + id + " not found."); 
            return;
        }

        Transaction tx = new Transaction();
        tx.setWeightGold(goldOz);
        tx.setWeightSilver(silverOz);
        
        boolean isComm = (cust instanceof CommercialCustomer);
        tx.calculateValue(isComm);

        cust.getAccount().makeDeposit(tx.getTotalValue());
        cust.addTransaction(tx);

        System.out.printf("Recorded transaction for %s. Deposited: $%.2f\n", cust.getName(), tx.getTotalValue());
    }

    private static Customer findCustomer(long id) {
        for (Customer cust : customerList) {
            if (cust.getCustomerId() == id) return cust;
        }
        return null;
    }
}