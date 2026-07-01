package oops.CashForMetals;


public class PersonalCustomer extends Customer {
    private String address;
    private String homePhone;
    private String workPhone;

    public PersonalCustomer(String name) {
        super(name); // Takes 1 String [cite: 24]
    }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getHomePhone() { return homePhone; }
    public void setHomePhone(String homePhone) { this.homePhone = homePhone; }

    public String getWorkPhone() { return workPhone; }
    public void setWorkPhone(String workPhone) { this.workPhone = workPhone; }

    @Override
    public String toString() {
        return super.toString() + " (Personal) | Address: " + address;
    }
}
