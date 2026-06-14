public class FactorCounter {
    public static void main(String[] args) {
        int number = 36;
        System.out.println("Number of factors for " + number + " is: " + countFactors(number));
    }

    public static int countFactors(int n) {
        if (n <= 0) return 0;

        int count = 0;
        double sqrtN = Math.sqrt(n);

        for (int i = 1; i <= sqrtN; i++) {
            if (n % i == 0) {
                // If the divisors are the same (perfect square), count once
                if (i * i == n) {
                    count++;
                } else {
                    // Count the pair (i and n/i)
                    count += 2;
                }
            }
        }
        return count;
    }
}