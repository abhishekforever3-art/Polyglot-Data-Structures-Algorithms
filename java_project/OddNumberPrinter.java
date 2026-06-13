import java.util.Scanner;

/* public class OddTillN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        System.out.println("Odd numbers up to " + n + ":");

        // Start at 1, increment by 2
        for (int i = 1; i <= n; i += 2) {
            System.out.print(i + " ");
        }
    } */
   

public class OddNumberPrinter {

    
    public static void printOdds(int limit) {
        System.out.println("Odd numbers up to " + limit + ":");
        for (int i = 1; i <= limit; i++) {
            
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the limit: ");
        int n = sc.nextInt();

        
        printOdds(n); 
        
        sc.close();
    }
}
