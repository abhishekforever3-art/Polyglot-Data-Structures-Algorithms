public class CircularPrime {
/* 
    
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    
    public static int getDigitCount(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }

    
    public static int rotateDigits(int n) {
        int count = getDigitCount(n);
        int lastDigit = n % 10;
        int remainingNum = n / 10;
        
        
        return (int) (lastDigit * Math.pow(10, count - 1)) + remainingNum;
    }

    
    public static boolean isCircularPrime(int n) {
        int temp = n;
        int count = getDigitCount(n);

        for (int i = 0; i < count; i++) {
            if (!isPrime(temp)) {
                return false;
            }
            temp = rotateDigits(temp);
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 131;
        if (isCircularPrime(num)) {
            System.out.println(num + " is a Circular Prime.");
        } else {
            System.out.println(num + " is NOT a Circular Prime.");
        }
    } */
    public static void main(String[] args) {
        int num = 131;
        int temp = num;
        int digitCount = 0;
        int countTemp = num;
        while (countTemp > 0) {
            digitCount++;
            countTemp /= 10;
        }

        boolean isCircularPrime = true;

        
        for (int i = 0; i < digitCount; i++) {
            
          
            boolean isCurrentPrime = true;
            if (temp <= 1) {
                isCurrentPrime = false;
            } else {
                for (int j = 2; j <= Math.sqrt(temp); j++) {
                    if (temp % j == 0) {
                        isCurrentPrime = false;
                        break;
                    }
                }
            }

            
            if (!isCurrentPrime) {
                isCircularPrime = false;
                break;
            }

           
            int lastDigit = temp % 10;
            int remainingNum = temp / 10;
            
           
            int currentDigitCount = 0;
            int rotationCountTemp = temp;
            while (rotationCountTemp > 0) {
                currentDigitCount++;
                rotationCountTemp /= 10;
            }

            
            temp = (int) (lastDigit * Math.pow(10, currentDigitCount - 1)) + remainingNum;
        }

        
        if (isCircularPrime) {
            System.out.println(num + " is a Circular Prime.");
        } else {
            System.out.println(num + " is NOT a Circular Prime.");
        }
    }

}