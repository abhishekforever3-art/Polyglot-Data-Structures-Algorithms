package oops.Banking;



public abstract class Customer {
    private String name;
    private long customerId;
    private Account account;

    private static long idCounter = 10001L;

    public Customer (String name){
        this.name = name;
        this.customerId =idCounter++;
        this.account = new Account (this.customerId+900000L);
    }
    public String getName (){
        return name;
    }
    public long getCustomerId(){
        return customerId;
    }
    public Account getAccount(){
        return account;
    }
    
}
