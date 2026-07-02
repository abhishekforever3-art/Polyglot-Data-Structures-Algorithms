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

    public Customer getCustomer(long customerId) throws CustomerNotFoundException {
        for (Customer c : customers) {
            if (c.getCustomerId() == customerId) {
                return c;
            }
        }
        throw new CustomerNotFoundException("Business Error: Customer with ID " + customerId + " does not exist.");
    }

    public void deposit(long customerId, double amount) throws CustomerNotFoundException, InvalidAmountException {
        Customer c = getCustomer(customerId); 
        c.getAccount().deposit(amount);       
    }

    

    public void withdraw(long customerId, double amount) throws CustomerNotFoundException, InvalidAmountException, InsufficientFundsException {
        Customer c = getCustomer(customerId); 
        c.getAccount().withdraw(amount);      
    }

    public double totalValue() {
        double sum = 0;
        for (Customer c : customers) {
            sum += c.getAccount().getBalance();
        }
        return sum;
    }
}