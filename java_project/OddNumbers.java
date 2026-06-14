import java.util.Scanner;

/* public class OddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Lower Limit (LL): ");
        int ll = sc.nextInt();
        
        System.out.print("Enter Higher Limit (HL): ");
        int hl = sc.nextInt();

        System.out.println("Odd numbers between " + ll + " and " + hl + ":");
        
        // Approach 1: Basic loop with if-condition
        for (int i = ll; i <= hl; i++) {
            if (i % 2 != 0) { // Check if number is odd
                System.out.print(i + " ");
            }
        }
    }
} */


public class OddNumbers{

    // The FUNCTION: Takes lower and higher limits as parameters
    public static void printOddsInRange(int ll, int hl) {
        System.out.println("Odd numbers between " + ll + " and " + hl + ":");
        
        // Loop starts at LL and ends at HL
        for (int i = ll; i <= hl; i++) {
            // Logic: Check if the number is odd
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Lower Limit (LL): ");
        int lower = sc.nextInt();

        System.out.print("Enter Higher Limit (HL): ");
        int higher = sc.nextInt();

        // Calling the function
        printOddsInRange(lower, higher);

        sc.close();
    }
}