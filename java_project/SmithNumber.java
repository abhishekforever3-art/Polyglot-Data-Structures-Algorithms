public class SmithNumber {
    public static void main(String[] args) {
        int n = 58;
        int temp = n;
        int sum = 0;
        boolean isPrime = true;
        // CHECKING PRIME 
        if (n <= 3) {
            isPrime = false;
        }
        for (int i = 2; i < temp; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println(n + " is prime. Disqualified from being a Smith Number!");
            return;
        }
        //Sum of the Original Number's Digits

        while (temp > 0) {
            int digit = temp % 10;  
            sum = sum + digit;      
            temp = temp / 10;       
        }
        System.out.println("The sum of the digits = " + sum);
        
        int outerSum = sum; 

        int innerSum = 0;
        temp = n; 

        for (int i = 2; i * i <= temp; i++) {
            while (temp % i == 0) {
                int factor = i;
                while (factor > 0) {
                    innerSum = innerSum + (factor % 10);
                    factor = factor / 10;
                }
                temp = temp / i;
            }
        }

        //Handling the Remaining Prime Factor

        if (temp > 1) {
            int factor = temp;
            while (factor > 0) {
                innerSum = innerSum + (factor % 10);
                factor = factor / 10;
            }
        }
        System.out.println("The sum of prime factor digits = " + innerSum);

        if (outerSum == innerSum) {
            System.out.println(n + " is a Smith Number");
        } else {
            System.out.println(n + " is not a Smith Number");
        }
    }
}