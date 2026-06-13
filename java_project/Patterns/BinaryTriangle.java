package Patterns;

public class BinaryTriangle {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i <= n; i++) {
            /* if (i % 2 == 0) {
                System.out.println("0");

            } else {
                System.out.println("1");
            } */
             for (int j = 0; j <i ; j++) {
                if ((i+j) % 2 == 0) {
                    System.out.print("0");

                } else {
                    System.out.print("1");
                }
            } 
             System.out.println();
        }
    }
}
