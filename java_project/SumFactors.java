/* import java.util.Scanner;

public class SumFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Sum of factors of " + n + " is: " + getSumOfFactors(n));
    }

    public static int getSumOfFactors(int n) {
        if (n <= 0) return 0;
        
        int sum = 0;
        double sqrtN = Math.sqrt(n);

        for (int i = 1; i <= sqrtN; i++) {
            if (n % i == 0) {
                // If factors are equal (e.g., 6x6 = 36), add only once
                if (i * i == n) {
                    sum += i;
                } else {
                    // Add both the divisor (i) and the quotient (n/i)
                    sum += i + (n / i);
                }
            }
        }
        return sum;
    } 
    
} */