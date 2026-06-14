import java.util.Scanner;

public class EvenNumbers {
    /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Lower Limit (LL): ");
        int ll = sc.nextInt();
        
        System.out.print("Enter Higher Limit (HL): ");
        int hl = sc.nextInt();

        System.out.println("Even numbers between " + ll + " and " + hl + ":");
        
        // Loop from LL to HL
        for (int i = ll; i <= hl; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    } */
    // The FUNCTION: Takes lower and higher limits as parameters
    public static void printEvensInRange(int ll, int hl) {
        System.out.println("Even numbers between " + ll + " and " + hl + ":");
        
        // Loop starts at LL and ends at HL
        for (int i = ll; i <= hl; i++) {
            // Logic: Check if the number is even
            if (i % 2 == 0) {
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
        printEvensInRange(lower, higher);

        sc.close();
    }

}
