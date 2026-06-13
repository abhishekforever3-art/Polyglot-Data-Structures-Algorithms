package Patterns;

public class Pyramid {
    public static void main(String[] args) {
        int n = 4; // Height of the pyramid

        // Outer loop for rows
        for (int i = 1; i <= n; i++) {
            
            // 1. Inner loop for printing spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // 2. Inner loop for printing stars
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            
            // Move to the next line after finishing the row
            System.out.println();
        }   
    }
}
