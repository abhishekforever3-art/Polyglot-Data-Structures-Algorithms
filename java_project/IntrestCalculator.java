public class IntrestCalculator {
    public static void main(String[] args) {
        int principle = 100000;
        int rate = 7;
        int totalYears = 5;

        int compoundAmount = principle;
            
        
        int totalSI = 0;
        int totalCI = 0;

        System.out.println("Year\tSI Amount\tCI Amount\tTotal with Compound\ttotal with simple");
        System.out.println("-----------------------------------------------------------------------");

        for (int i = 1; i <= totalYears; i++) {
            
            int simpleIntrest = (principle * rate * 1) / 100;// SI is calculated for 1 single year using the original principle

            
            int currentYearCI = (compoundAmount * rate) / 100;// CI is calculated for 1 single year using the updated compound amount
            
            
            compoundAmount = compoundAmount + currentYearCI;// Update the running compound amount for the next year

            // Add this year's interest to our grand totals
            totalSI = totalSI + simpleIntrest;
            totalCI = totalCI + currentYearCI;

            int l = totalSI+principle;

            // Printing year by year results
            
            System.out.println("Year " + i + "\t" + simpleIntrest + "\t\t" + currentYearCI+"\t\t" +compoundAmount+"\t\t"+ l );
            //System.out.printf("%4d | %22.2f | %24.2f %n",i,simpleIntrest,currentYearCI);
            //System.out.println("*************************");
            //System.out.println("CompoundAmount----> "+compoundAmount);
            //System.out.println("Simple Amount-----> "+l);
            //System.out.println("*************************");
        }

        
        System.out.println("-------------------------------------");
        System.out.println("Total Simple Interest earned: " + totalSI);
        System.out.println("Total Compound Interest earned: " + totalCI);
    }
}