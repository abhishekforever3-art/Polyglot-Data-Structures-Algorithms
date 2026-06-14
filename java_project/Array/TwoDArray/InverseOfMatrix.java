package Array.TwoDArray;

public class InverseOfMatrix {
    public static void main(String[] args) {
        // CHANGED VALUES: We use a non-singular matrix example so the determinant is
        // not 0
        double[][] a = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("Original Matrix A:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");

        // STEP 1: CALCULATE DETERMINANT OF 3x3 MATRIX
        double determinant = a[0][0] * (a[1][1] * a[2][2] - a[1][2] * a[2][1])
                - a[0][1] * (a[1][0] * a[2][2] - a[1][2] * a[2][0])
                + a[0][2] * (a[1][0] * a[2][1] - a[1][1] * a[2][0]);

        System.out.println("Determinant (|A|): " + determinant);
        System.out.println("-----------------------------------");

        // DEFENSIVE CHECK: Exit if the matrix is singular
        if (determinant == 0) {
            System.out.println("The matrix is Singular and cannot be inverted!");
            return;
        }

        // STEP 2 & 3: HARD-CODE THE COFACTOR MATRIX SLOTS (Including Sign Patterns)
        double[][] cofactor = new double[3][3];

        cofactor[0][0] = (a[1][1] * a[2][2] - a[1][2] * a[2][1]);
        cofactor[0][1] = -(a[1][0] * a[2][2] - a[1][2] * a[2][0]);
        cofactor[0][2] = (a[1][0] * a[2][1] - a[1][1] * a[2][0]);

        cofactor[1][0] = -(a[0][1] * a[2][2] - a[0][2] * a[2][1]);
        cofactor[1][1] = (a[0][0] * a[2][2] - a[0][2] * a[2][0]);
        cofactor[1][2] = -(a[0][0] * a[2][1] - a[0][1] * a[2][0]);

        cofactor[2][0] = (a[0][1] * a[1][2] - a[0][2] * a[1][1]);
        cofactor[2][1] = -(a[0][0] * a[1][2] - a[0][2] * a[1][0]);
        cofactor[2][2] = (a[0][0] * a[1][1] - a[0][1] * a[1][0]);

        // STEP 4: TRANSPOSE COFACTOR TO GET ADJOINT
        double[][] adjoint = new double[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                adjoint[col][row] = cofactor[row][col];
            }
        }

        // STEP 5: DIVIDE ADJOINT BY DETERMINANT TO GET FINAL INVERSE
        double[][] inverse = new double[3][3];
        System.out.println("Inverse Matrix (A^-1):");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                inverse[row][col] = adjoint[row][col] / determinant;

                // Format the print output to 2 decimal places for neatness
                System.out.printf("%.2f\t", inverse[row][col]);
            }
            System.out.println();
        }
    }
}