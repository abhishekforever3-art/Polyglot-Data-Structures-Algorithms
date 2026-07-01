package oops.Banking;

public class CommercialCustomer extends Customer {
    private String address;
    private String contactPerson;
    private String contactPersonPhone;

    // Constructor takes only the name as required
    public CommercialCustomer(String name) {
        super(name);
    }

    // Write get/set methods for address, contact person, and contact person phone
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPersonPhone() {
        return contactPersonPhone;
    }

    public void setContactPersonPhone(String contactPersonPhone) {
        this.contactPersonPhone = contactPersonPhone;
    }
}