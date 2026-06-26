package oops.NAUGHTEEN;

public abstract class LeatherItems {
    protected String itemId;
    protected String billId;
    protected String category;
    protected String type;

    public LeatherItems(String itemId, String category, String type ){
        this.itemId = itemId;
        this.category = category;
        this.type = type;
    }
    public String getItemId() {
        return itemId;
    }

    public String getBillId() {
        return billId;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }
    public boolean validateCategory(){
        if (this.category!= null && (this.category.equalsIgnoreCase("Imported") || this.category.equalsIgnoreCase("Manufactured"))){
            return true;
        }
        return false;
    }
    public abstract boolean validateType();
    public abstract float identifyCost();
    public abstract float calculateBillAmount();
    
}
