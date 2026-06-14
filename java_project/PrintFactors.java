/* import java.util.*;

public class PrintFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            System.out.println("Factors of " + n + " are:");
            printFactors(n);
        }
    }

    public static void printFactors(int n) {
    
        Set<Integer> factors = new TreeSet<>();
        
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                factors.add(i);       
                factors.add(n / i);     
            }
        }
        
        // Print the sorted set
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
    }
} */