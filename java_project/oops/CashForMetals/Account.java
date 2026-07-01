package oops.CashForMetals;

import java.util.Calendar;

public class Account {
    private long accountNumber;
    private double balance;
    private Calendar dateOpened;
    private double interestRate;

    public Account(long accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0; // Default balance is 0 [cite: 36]
        this.dateOpened = Calendar.getInstance(); // Uses current date/time 
        this.interestRate = 0.03; // Default rate of 3% [cite: 36]
    }

    // Get methods for each attribute [cite: 37]
    public long getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public Calendar getDateOpened() { return dateOpened; }
    public double getInterestRate() { return interestRate; }

    public void makeDeposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public double makeWithdrawal(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            return amount; // Returns actual amount withdrawn [cite: 37]
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return String.format("Account No: %d | Balance: $%.2f | Rate: %.1f%%", 
                accountNumber, balance, interestRate * 100);
    }
}
