package oops.NAUGHTEEN;

public class Shoe extends LeatherItems {
    private int sizeOfShoe ;
    private String brand;
    private static int counter =1;

    public Shoe (String itemId, String category, String type, int sizeOfShoe, String brand){
        super (itemId, category, type);
        this.sizeOfShoe = sizeOfShoe;
        this.brand = brand;
    }
    public int getSizeOfShoe(){
        return sizeOfShoe;
    }
    public String getBrand(){
        return brand;
    }
    public boolean validateSizeOfShoe(){
        if (this.sizeOfShoe >= 4 && this.sizeOfShoe <= 12){
            return true;
        }
        return false;
    }
    public boolean validateBrand(){
        if (this.type != null && 
           (this.type.equalsIgnoreCase("Flat") || 
            this.type.equalsIgnoreCase("Heels") || 
            this.type.equalsIgnoreCase("Stilettos") || 
            this.type.equalsIgnoreCase("Wedge"))) {
            return true;
        }
        return false;
    }
    @Override
    public boolean validateType() {
        if (this.type != null && 
           (this.type.equalsIgnoreCase("Flat") || 
            this.type.equalsIgnoreCase("Heels") || 
            this.type.equalsIgnoreCase("Stilettos") || 
            this.type.equalsIgnoreCase("Wedge"))) {
            return true;
        }
        return false; 
    }
    public float identifyDiscountPercentage(){
        if (!validateBrand()){
            System.out.println("Invalid Brand.");
            return 0f;
        }
        float discount = 0f;
        if (this.brand.equalsIgnoreCase("Reebok")) {
            discount = 10.0f;
        } else if (this.brand.equalsIgnoreCase("Nike")) {
            discount = 25.0f;
        } else if (this.brand.equalsIgnoreCase("Adidas")) {
            discount = 40.0f;
        }
        return discount;    
    }
    @Override
    public float identifyCost(){
        if (!validateSizeOfShoe() && validateType()){
            System.out.println("Invalid Shoe Type or Size.");
            return 0f;
        }
        float cost = 0f;
        if (this.sizeOfShoe >=4 && this.sizeOfShoe<=7){
            if (this.type.equalsIgnoreCase("Flat")) cost = 7.0f;
            else if (this.type.equalsIgnoreCase("Heels")) cost = 8.0f;
        } else if (this.sizeOfShoe >= 8 && this.sizeOfShoe <= 12) {
            if (this.type.equalsIgnoreCase("Stilettos")) cost = 9.0f;
            else if (this.type.equalsIgnoreCase("Wedge")) cost = 10.0f;
        }
        
        return cost;
       
    }
     @Override
        public float calculateBillAmount(){
            if (!validateCategory()){
                System.out.println("Invalid Category.");
                return 0f;
            }
            float baseCostDollers = identifyCost();
            if (baseCostDollers <=0){
                System.out.println("Cost cannot be calculated.");
                return 0f;
            }
            float costInRupees = baseCostDollers * 61.04f;
            float discountPrcent = this.identifyDiscountPercentage();
            costInRupees= costInRupees-(costInRupees * discountPrcent / 100);
            float taxPercent = 0f;
            if (this.category.equalsIgnoreCase("Imported")) {
             taxPercent= 20f;
            }
            float finalBill = costInRupees + (costInRupees * taxPercent / 100);
            this.billId = this.brand + this.itemId + counter;
            counter++;

            return finalBill;
        }
}
