public class Perfectno {
   /*  public static void main(String[] args) {
        int n = 28;
        if (isPerfect(n)) {
            System.out.println(n + " is a perfect number.");
        } else {
            System.out.println(n + " is not a perfect number.");
        }
    }

    public static boolean isPerfect(int n) {
        if (n < 2) return false;

        int sum = 1; // Start with 1 because it's a proper divisor of every n > 1
        double sqrtN = Math.sqrt(n);

        for (int i = 2; i <= sqrtN; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    sum += i;
                } else {
                    sum += i + (n / i);
                }
            }
        }
        return sum == n;
    } */

    // This method wasn't needed for the Perfect Number logic, 
    // but here it is fixed for syntax:
    public static int factor(final int N) {
        int result = 1;
        for (int i = 1; i <= N; i++) { 
            if (N % i == 0) {          
                result = result * i;
            }
        }
        return result;
    }

    public static int sumFactors(final int N) {
        int sum = 0;
        for (int i = 1; i < N; i++) { 
            if (N % i == 0) {
                sum = sum + i;
            }
        }
        return sum; 
    }

    public static void main(String[] args) {
        int N = Integer.parseInt("6"); 

        if (sumFactors(N) == N) {
            System.out.println(N + " is a perfect number");
        } else {
            System.out.println(N + " is not a perfect number");
        }
    }

}
