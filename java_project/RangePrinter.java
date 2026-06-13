/* import java.util.Scanner;

public class PrintRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Lower Limit (LL): ");
        int ll = sc.nextInt();
        
        System.out.print("Enter Higher Limit (HL): ");
        int hl = sc.nextInt();

        System.out.println("Numbers between " + ll + " and " + hl + ":");
        
        // Loop from LL to HL
        for (int i = ll; i <= hl; i++) {
            System.out.print(i + " ");
        }
    }
} 
import java.util.Scanner;

public class RangePrinter {

    // The FUNCTION: Takes two parameters (lower limit and higher limit)
    public static void printRange(int ll, int hl) {
        System.out.println("Printing numbers from " + ll + " to " + hl + ":");
        
        for (int i = ll; i <= hl; i++) {
            System.out.print(i + " ");
        }
        System.out.println(); // Moves to a new line after printing
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Lower Limit (LL): ");
        int lower = sc.nextInt();

        System.out.print("Enter Higher Limit (HL): ");
        int higher = sc.nextInt();

        // Calling the function with our two inputs
        printRange(lower, higher);

        sc.close();
    }
} */