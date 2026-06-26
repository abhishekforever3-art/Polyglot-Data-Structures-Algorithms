package oops.NAUGHTEEN;

public class Bag extends LeatherItems{
    private int sizeOfBag;
    private static int counter = 1;

    public Bag (String itemId, String category, String type, int sizeOfBag){
        super(itemId, category, type); 
        this.sizeOfBag = sizeOfBag;
    }
    public int getSizeOfBag(){
        return sizeOfBag;
    }
    @Override
    public boolean validateType(){
        if (this.type != null && 
           (this.type.equalsIgnoreCase("FormalBag") || this.type.equalsIgnoreCase("SportsBag"))) {
            return true;
        }
        return false;
    }
    public  boolean validateSizeOfBag(){
        if (this.type != null && this.type.equalsIgnoreCase("FormalBag") ){
            if (this.sizeOfBag>=15 && this.sizeOfBag<=45){
                return true;
            }
            return false;
            
        }
        else if ( this.type !=null && this.type.equalsIgnoreCase("SportsBag")) {
            return true;
        }
        return false;
    }
    @Override
    public float identifyCost(){
        if (!validateSizeOfBag() || !validateType()){
            System.out.println("Invalid Bag Type or Size.");
            return 0f;
        }
        float cost = 0f;

        if (this.type.equalsIgnoreCase("FormalBag")){
            if (this.sizeOfBag>=15 && this.sizeOfBag<=30){
                cost = 1.5f;
            }
            else if (this.sizeOfBag>= 31 && this.sizeOfBag<=45){
                cost = 3.5f;
            }
        }else if (this.type.equalsIgnoreCase("SportsBag")){
            if (this.sizeOfBag <= 17){
                cost = 4.5f;
            }
            else {
                cost = 9.5f;
            }
        }

        return cost;

    }
    @Override
    public float calculateBillAmount(){
        if (!validateCategory()){
            System.out.println("Invalid Category.");
            return 0f;
        }

        float baseCostPounds = identifyCost();
        
        if (baseCostPounds <= 0) {
            System.out.println("Cost cannot be calculated.");
            return 0f;
        }

        float costInRupees = baseCostPounds * 101.5f;
        float taxPercentage = 0f;

        if(this.category.equalsIgnoreCase("Imported")){
            taxPercentage = 15f;
        }
        float finalBill = costInRupees + (costInRupees * taxPercentage) / 100;

        this.billId = this.itemId + counter;
        counter++;

        return finalBill;
        
        
    }
    

    
}
