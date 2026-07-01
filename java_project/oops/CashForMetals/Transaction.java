package oops.CashForMetals;


import java.util.Calendar;

public class Transaction {
    private long transactionId;
    private Calendar transactionDate;
    private double weightGold;
    private double weightSilver;
    private double totalValue;

    private static long idCounter = 50001L;
    
    // Metal value constants 
    public static final double GOLD_PRICE_PER_OUNCE = 400.50;
    public static final double SILVER_PRICE_PER_OUNCE = 6.25;

    public Transaction() {
        this.transactionId = idCounter++;
        this.transactionDate = Calendar.getInstance(); // Current date/time [cite: 40]
    }

    // Getters and Setters [cite: 41, 42]
    public long getTransactionId() { return transactionId; }
    public Calendar getTransactionDate() { return transactionDate; }
    
    public double getWeightGold() { return weightGold; }
    public void setWeightGold(double weightGold) { this.weightGold = weightGold; }

    public double getWeightSilver() { return weightSilver; }
    public void setWeightSilver(double weightSilver) { this.weightSilver = weightSilver; }

    public double getTotalValue() { return totalValue; }

    // Calculates baseline value before any customer-specific bonuses
    public void calculateValue(boolean isCommercial) {
        double baseValue = (this.weightGold * GOLD_PRICE_PER_OUNCE) + (this.weightSilver * SILVER_PRICE_PER_OUNCE);
        if (isCommercial) {
            this.totalValue = baseValue * 1.03; // Commercial get 3% more 
        } else {
            this.totalValue = baseValue;
        }
    }

    @Override
    public String toString() {
        return String.format("TX ID: %d | Gold: %.2f oz | Silver: %.2f oz | Total: $%.2f", 
                transactionId, weightGold, weightSilver, totalValue);
    }
}
