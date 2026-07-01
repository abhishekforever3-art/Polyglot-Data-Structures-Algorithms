package oops.Banking;



public class PersonalCustomer extends Customer {
    private String address;
    private String homePhone;
    private String workPhone;

    public PersonalCustomer(String name){
        super(name);
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getHomePhone(){
        return homePhone;
    }
    public void setHomePhone(String  homePhone){
        this.homePhone = homePhone;
    }
    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    
}
