package oops.CashForMetals;


import java.util.ArrayList;

public abstract class Customer {
    private String name;
    private long customerId;
    private Account account;
    private ArrayList<Transaction> transactions;

    private static long idCounter = 20001L;

    public Customer(String name) {
        this.name = name;
        this.customerId = idCounter++;
        this.account = new Account(this.customerId + 800000L); // Created when customer is created [cite: 38]
        this.transactions = new ArrayList<>();
    }

    public String getName() { return name; }
    public long getCustomerId() { return customerId; }
    public Account getAccount() { return account; }
    public ArrayList<Transaction> getTransactions() { return transactions; }

    public void addTransaction(Transaction tx) {
        this.transactions.add(tx); // Added to the Customer [cite: 44]
    }

    @Override
    public String toString() {
        return "ID: " + customerId + " | Name: " + name;
    }
}
