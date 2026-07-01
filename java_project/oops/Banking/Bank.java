package oops.Banking;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers = new ArrayList<>();

    public long createPersonalCustomer(String name, String address, String homePhone, String workPhone) {
        PersonalCustomer pc = new PersonalCustomer(name);
        pc.setAddress(address);
        pc.setHomePhone(homePhone);
        pc.setWorkPhone(workPhone);
        
        customers.add(pc); 
        return pc.getCustomerId();
    }

    public long createCommercialCustomer(String name, String address, String contactPersonName, String contactPersonPhone) {
        CommercialCustomer cc = new CommercialCustomer(name);
        cc.setAddress(address);
        cc.setContactPerson(contactPersonName);
        cc.setContactPersonPhone(contactPersonPhone);
        
        customers.add(cc);
        return cc.getCustomerId();
    }

    public Customer getCustomer(long customerId) {
        for (Customer c : customers) {
            if (c.getCustomerId() == customerId) {
                return c;
            }
        }
        return null;
    }

    public boolean deposit(long customerId, double amount) {
        Customer c = getCustomer(customerId);
        if (c == null || amount <= 0) return false;
        c.getAccount().deposit(amount);
        return true;
    }

    public int withdraw(long customerId, double amount) {
        Customer c = getCustomer(customerId);
        if (c == null) return 0; 
        if (amount <= 0) return -1;
        if (c.getAccount().getBalance() < amount) return -2;
        
        c.getAccount().withdraw(amount);
        return 1;
    }

    public double totalValue() {
        double sum = 0;
        for (Customer c : customers) {
            sum += c.getAccount().getBalance();
        }
        return sum;
    }
}