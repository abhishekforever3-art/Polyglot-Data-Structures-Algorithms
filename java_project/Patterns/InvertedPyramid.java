package Patterns;

public class InvertedPyramid {
    public static void main(String[] args) {
        int n = 4; // Height of the pyramid

        // Outer loop runs BACKWARDS (from n down to 1)
        for (int i = n; i >= 1; i--) {
            
            //  Inner loop for printing spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            
            //  Inner loop for printing stars
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            
            // Move to the next line
            System.out.println();
        }
    }
}
