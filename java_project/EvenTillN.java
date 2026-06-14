//import java.util.Scanner;

public class EvenTillN {
    /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        System.out.println("Even numbers up to " + n + ":");

        // Start at 0 or 2 depending on your requirements
        for (int i = 0; i <= n; i += 2) {
            System.out.print(i + " ");
        }
    } */
   public static void printEvenNumbers (final int LIMIT){
        for (int i = 0; i<= LIMIT ; i++ ){
            if (i%2==0){
                System.out.println(i);
            }
        }
    }
        public static void main(String[] args) {
            printEvenNumbers(20);
        }
   
}