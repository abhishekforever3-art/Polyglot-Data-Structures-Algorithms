package oops.Banking;

import java.util.Date;


public class Account {
    private long accountNumber ;
    private double balance;
    private Date dateOpened;

    public Account (long accountNumber){
        this.accountNumber = accountNumber;
        this. balance = 0.0;
        this.dateOpened = new Date();

    }

    public long getAccountNumber(){
        return accountNumber;
    }   

    public double getBalance (){
        return balance;
    }

    public Date getDateOpened(){
        return dateOpened;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Business Error: Deposit amount must be greater than zero. Attempted: " + amount);
        }
        this.balance += amount;
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Business Error: Withdrawal amount must be greater than zero. Attempted: " + amount);
        }
        if (amount > this.balance) {
            throw new InsufficientFundsException("Business Error: Insufficient funds. Current Balance: " + this.balance + ", Requested: " + amount);
        }
        this.balance -= amount;
    }

    
}
