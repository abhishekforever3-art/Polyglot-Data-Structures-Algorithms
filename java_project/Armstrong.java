    public class Armstrong {
    /*  public static void main(String[] args) {
        int n = 1635;
        int original = n;
        int temp = n;
        int count = 0;
        double result = 0;
        while (temp>0){
            temp = temp / 10;
            count ++;

     }
     temp = n;
     while (temp>0){
          int lastdigit = temp%10;
          result= result + Math.pow(lastdigit, count);
          temp = temp / 10;

     }
     if ((int)result==original){
          System.out.println(original + " is an armstrong number");
     }
     else {
          System.out.println(original + " is not armstrong number");
     } */

     // Worker 1: Counts the digits in a number
    public static int countDigits(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

    // Worker 2: Checks if the number is an Armstrong number
    public static boolean isArmstrong(int n) {
        int original = n;
        int count = countDigits(n); // Call our first function
        double result = 0;
        int temp = n;

        while (temp > 0) {
            int lastDigit = temp % 10;
            result = result + Math.pow(lastDigit, count);
            temp = temp / 10;
        }

        return (int)result == original;
    }

    public static void main(String[] args) {
        int number = 153;

        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number");
        } else {
            System.out.println(number + " is not an Armstrong number");
        }
    }

}

