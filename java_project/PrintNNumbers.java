

public class PrintNNumbers {
    /* public static void main(String[] args) {
        int n = 10; 
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    } */

    /**
     * Logic to determine if a number is prime.
     */
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        
        // We only need to check up to the square root of the number
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Logic to print all primes up to n.
     */
    public static void printPrimesUpTo(int n) {
        System.out.println("Primes between 1 and " + n + ":");
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); // New line for cleanliness
    }

    public static void main(String[] args) {
        // Hardcoded value for n
        int n = 30; 
        
        // Calling the function
        printPrimesUpTo(n);
    }

}