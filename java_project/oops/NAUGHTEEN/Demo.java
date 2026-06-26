package oops.NAUGHTEEN;

public class Demo {
    public static void main(String[] args) {
        Bag bag = new Bag("B101", "Imported", "FormalBag", 25);

        System.out.println(" --- Bag Billing ---");

        float   bagBill = bag.calculateBillAmount();
        System.out.println("Bill ID: "+ bag.getBillId());
        System.out.println("Bill Amount "+ bagBill);

        System.out.println("-------------------------------------");

        Shoe shoe = new Shoe("S202", "Imported", "Flat", 5, "Nike");
        
        System.out.println("\n--- Shoe Billing ---");
        float shoeBill = shoe.calculateBillAmount();
        System.out.println("Bill ID: " + shoe.getBrand() + shoe.getItemId() + "1");
        System.out.println("Final Bill Amount: " + shoeBill);
    }
}
