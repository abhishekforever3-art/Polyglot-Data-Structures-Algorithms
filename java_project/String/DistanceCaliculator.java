package String;

public class DistanceCaliculator {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "xyz";
        int totalDistance =0;
        for (int i =0; i<s1.length(); i++){
            int val1 = s1.charAt(i);
            int val2 = s2.charAt(i);
            
            int ascii1= (int)val1;
            int ascii2 = (int)val2;

            
            System.out.println("The ascii value of "+val1+" "+ ascii1);
            System.out.println("The ascii value of "+val2+" "+ ascii2);

            int currentdistance = Math.abs(val1-val2);
            System.out.println(currentdistance+"========");
            totalDistance= totalDistance+ currentdistance;
        }
        System.out.println("String 1: " + s1);
        System.out.println("String 2: " + s2);
        System.out.println("---------------------------------");
        
        System.out.println("Cumulative ASCII Distance: " + totalDistance);
        

    }
}
