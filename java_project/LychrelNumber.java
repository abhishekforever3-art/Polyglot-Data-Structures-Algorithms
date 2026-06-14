public class LychrelNumber {
    public static void main(String[] args) {
        int n = 196;
        int l = n;
        int maxIterations = 50;
        boolean isLyrichrelNumber = false;
        for (int i = 1; i <= maxIterations; i++) {
            int temp = n;
            int rev = 0;
            while (temp > 0) {// reversing the original number.
                int digit = temp % 10;
                rev = rev * 10 + digit;
                temp = temp / 10;
            }
            int add = n + rev;// adding the rev and original.
            n = add;
            temp = add;
            int reverseadd = 0;
            while (temp > 0) {// looping the reversing process.
                int digit = temp % 10;
                reverseadd = reverseadd * 10 + digit;
                temp = temp / 10;
            }
            if (add == reverseadd) {// checking the palandrome sequence.
                isLyrichrelNumber = true;
                break;

            }
            n = add;

        }
        if (!isLyrichrelNumber) {
            //System.out.println("No palindrome found within " + maxIterations + " iterations.");
            System.out.println(l+" This number is a likely Lychrel candidate ");
        }
        else{
            System.out.println(l+" This number is not a likely Lychrel candidate ");
        }
        /*
         * if (isLyrichrelNumber) {
         * System.out.println(n + " Lychrel Number");
         * } else {
         * System.out.println(n + "Not a Lychrel Number");
         * 
         * }
         */
    }
}
