package Array.TwoDArray;

public class SkewSymmentryMatrix {
    public static void main(String[] args) {
        // 1. FIXED INITIALIZATION: Setting up a true skew-symmetric matrix to test
        int a[][] = {
            { 0,  2, -3},
            {-2,  0,  4},
            { 3, -4,  0}
        };
        
        System.out.println("Matrix elements:");
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                System.out.print(a[row][col] + " \t");
            }
            System.out.println();
        }
        
        System.out.println("-----------------------------------");

        // 2. THE SKEW-SYMMETRY CHECKER LOGIC
        boolean isSkewSymmetric = true;

        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                
                // Rule 1 Check: Main diagonal must be 0
                if (row == col && a[row][col] != 0) {
                    isSkewSymmetric = false;
                    break;
                }
                
                // Rule 2 Check: Mirrored elements must be opposite in sign
                if (row != col && a[row][col] != -a[col][row]) {
                    isSkewSymmetric = false;
                    break;
                }
            }
            if (!isSkewSymmetric) {
                break; // Exit outer loop early if check fails
            }
        }

        // 3. Print the final verdict
        if (isSkewSymmetric) {
            System.out.println("Verdict: The matrix is Skew-Symmetric!");
        } else {
            System.out.println("Verdict: The matrix is NOT Skew-Symmetric.");
        }
    }
}