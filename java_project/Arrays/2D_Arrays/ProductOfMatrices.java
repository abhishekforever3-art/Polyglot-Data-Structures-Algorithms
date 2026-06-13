package Array.TwoDArray;

public class ProductOfMatrices {
    public static void main(String[] args) {
        int a[][] = new int[3][3];
        int b[][] = new int[3][3];
        int c[][] = new int[3][3];
        int counter =1;
        if (a.length == b.length && a[0].length == b[0].length) {

            System.out.println("Dimension Check Passed! Both matrices are matching sizes.");
            System.out.println("-------------------------------------------------");
           
            System.out.println("Matrix A:");
            for (int row = 0; row < a.length; row++) {
                for (int col = 0; col < a[row].length; col++) {
                    a[row][col] = counter;
                    System.out.print(a[row][col] + "\t");
                    counter++;
                }
                System.out.println();
            }
        }
        System.out.println("-------------");
        System.out.println("Matrix A:");
        int count =1;
        for (int row=0; row<a.length; row++){
            for(int col=0; col<b[row].length; col++){
                b[row][col]= count;
                System.out.print(b[row][col]+ "\t");
                count++;
            }
            System.out.println();
        }
        System.out.println("--------------------------");

        System.out.println("Sum Matrix (C = A * B):");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                
                c[row][col] = 0; 
                
                
                for (int k = 0; k < 3; k++) {
                    c[row][col] =c[row][col]+ a[row][k] * b[k][col];
                }
                
                System.out.print(c[row][col] + "\t");
            }
            System.out.println();
        }
        
    }
}
