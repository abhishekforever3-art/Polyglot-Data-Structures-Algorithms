package Array.TwoDArray;

public class RowSumColSumOfMatrix {
   /* public static void main(String[] args) {
        int a[][] = new int[3][3];
        int b[][] = new int[3][3];
        
       
        int colSumA[] = new int[3]; 
        int colSumB[] = new int[3]; 

        System.out.println("Matrix A with Row Sums:");
        int counter = 1;
        for (int row = 0; row < a.length; row++) {
            int rowSum = 0;
            for (int col = 0; col < a[row].length; col++) {
                a[row][col] = counter;
                System.out.print(a[row][col] + "\t");
                counter++;
                
                rowSum = rowSum + a[row][col];
                
                
                colSumA[col] = colSumA[col] + a[row][col]; 
            }
            System.out.println("| Row Sum: " + rowSum);
        }
        
        
        System.out.print("Col Sum:\t");
        for (int col = 0; col < colSumA.length; col++) {
            System.out.print(colSumA[col] + "\t");
        }
        System.out.println("\n-----------------------");

        System.out.println("Matrix B with Row Sums:");
        int count = 1;
        for (int row = 0; row < b.length; row++) {
            int rowSum = 0;
            for (int col = 0; col < b[row].length; col++) {
                b[row][col] = count;
                System.out.print(b[row][col] + "\t");
                count++;
                
                rowSum = rowSum + b[row][col];
                
                
                colSumB[col] = colSumB[col] + b[row][col];
            }
            System.out.println("| Row Sum: " + rowSum);
        }
        
        
        System.out.print("Col Sum:\t");
        for (int col = 0; col < colSumB.length; col++) {
            System.out.print(colSumB[col] + "\t");
        }
        System.out.println("\n-----------------------");
    } */
    public static void main(String[] args) {

        int a[][] = new int[3][3];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = i * j + 5;
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        int rowSum[][] = new int[4][4];

        for (int i = 0; i < a.length; i++) {
            int sum = 0;

            for (int j = 0; j < a[i].length; j++) {
                rowSum[i][j] = a[i][j];
                sum += a[i][j];
            }

            rowSum[i][3] = sum;
        }

        for (int j = 0; j < a[0].length; j++) {
            int sum = 0;

            for (int i = 0; i < a.length; i++) {
                sum += a[i][j];
            }

            rowSum[3][j] = sum;
        }
        int totalSum = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                totalSum += a[i][j];
            }
        }

        rowSum[3][3] = totalSum;

        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < rowSum[i].length; j++) {
                System.out.print(rowSum[i][j] + " ");
            }
            System.out.println();
        } 
    }
}