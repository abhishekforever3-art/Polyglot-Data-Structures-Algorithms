public class UglyNumber {
    public static void main(String[] args) {
        int n = 14;
        int temp = n;

        if (n < 0) {
            System.out.println(temp + " is not a Ugly number");
        } else {
            while (n % 2 == 0) {
                n = n / 2;

            }
            while (n % 3 == 0) {
                n = n / 3;
            }
            while (n%5 == 0){
                n = n/5;
            
            }
            if (n==1){
                System.out.println(temp+ " is a Ugly number");
            }
            else {
                System.out.println(temp+ " is not a ugly number");
            }


        }

    }
}
