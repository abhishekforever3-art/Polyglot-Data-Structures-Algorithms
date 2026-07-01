package oops.CashForMetals;


public class CommercialCustomer extends Customer {
    private String address;
    private String contactPerson;
    private String contactPersonPhone;

    public CommercialCustomer(String name) {
        super(name); // Takes 1 String [cite: 29]
    }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }

    public String getContactPersonPhone() { return contactPersonPhone; }
    public void setContactPersonPhone(String contactPersonPhone) { this.contactPersonPhone = contactPersonPhone; }

    @Override
    public String toString() {
        return super.toString() + " (Commercial) | Contact: " + contactPerson;
    }
}
