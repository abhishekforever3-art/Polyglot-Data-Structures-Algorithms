public class DuckNumber {
    public static void main(String[] args) {
        int N = 10;
        int temp = N ; 
        boolean foundMiddleZero = false;


        if (N < 0) {
            System.out.println(N + " Not a Duck Number");
            return;
        }

        if (N % 10 == 0) {
            System.out.println(N + " Not a Duck Number");
            return;
        }

        
        
        while (temp >0) {
            int currentDigit = temp % 10;
            if (currentDigit == 0) {
                foundMiddleZero = true;
                break;
            }
            temp = temp / 10;
        }
            /* System.out.println(N + " matches criteria? " + foundMiddleZero); */

        if (foundMiddleZero) {
             System.out.println(" Duck Number");
        } else {
             System.out.println(" Not a Duck Number");
        } 
    }
}