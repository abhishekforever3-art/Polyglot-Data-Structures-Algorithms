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

    public void deposit(double amount){
        if (amount >0){
            this.balance +=amount;
        }
    }

    public void withdraw (double amount){
        if (amount >0 && amount<=this.balance){
            this.balance -= amount;
        }
    }

    
}
