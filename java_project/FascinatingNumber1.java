/* public class FascinatingNumber1 {
    public static void main(String[] args) {
        int n = 192;
        int digitCount = 0;
        
        // We use long for 'y' because combining 9 multiples creates a very large number
        long y = 0; 
       
        for (int i = 1; i <= 9; i++) {
            int p = n * i;
            int tempQ = p;
            
            System.out.println("Multiple " + i + ": " + p);

            // 1. Count the digits of the current multiple 'p'
            int count = 0;
            int temp = p;
            while (temp > 0) {
                count++;
                temp = temp / 10;
            }

            // 2. Generate the exact divisor for this multiple
            long divisor = 1;
            for (int j = 1; j < count + 1; j++) {
                divisor = divisor * 10;
            }

            // 3. Concatenate 'p' to the back of our growing number 'y'
            y = y * divisor + p;
        }

        System.out.println("Final Grand Concatenated Number: " + y);
        
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        int a4 = 0;
        int a5 = 0;
        int a6 = 0;
        int a7 = 0;
        int a8 = 0;
        int a9 = 0;
        long tempY = y;

        while (tempY > 0) {
            int digit = (int) (tempY % 10);
            tempY = tempY / 10; 
            
            // Corrected to check each specific digit from 1 to 9
            if (digit == 1) {
                a1++;
            }
            if (digit == 2) {
                a2++;
            }
            if (digit == 3) {
                a3++;
            }
            if (digit == 4) {
                a4++;
            }
            if (digit == 5) {
                a5++;
            }
            if (digit == 6) {
                a6++;
            }
            if (digit == 7) {
                a7++;
            }
            if (digit == 8) {
                a8++;
            }
            if (digit == 9) {
                a9++;
            }
        }

        // Check if every digit from 1 to 9 appeared exactly once
        if (a1 == 1 && a2 == 1 && a3 == 1 && a4 == 1 && a5 == 1 && a6 == 1 && a7 == 1 && a8 == 1 && a9 == 1) {
            System.out.println(n + " Fascinating number");
        } else {
            System.out.println(n + " Not fascinating number");
        } 
    }
} */