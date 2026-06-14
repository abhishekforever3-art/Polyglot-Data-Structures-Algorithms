package Array.TwoDArray;

public class MatrixScalerMultiplier {
    public static void main(String[] args) {
        float a[][]= new float[3][3];
        float k =5.2f;
        float counter =1;
        for (int row=0; row<a.length; row++){
            for (int col=0; col<a[row].length; col++){
                a[row][col]=counter;
                System.out.print(a[row][col]+ " \t");
                counter++;
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Multiplying every element by scalar K = " + k + "...");
        System.out.println("-------------------------------------------------");
        for (int row=0; row<a.length; row++){
            for (int col=0; col<a[row].length; col++){
                a[row][col]= a[row][col]*k;

            }
        }
        System.out.println("Resulting Matrix Grid:");
        for (int row=0; row<a.length; row++){
            for (int col=0; col<a[row].length; col++){
                System.out.print(a[row][col]+ " \t");
            }
            System.out.println();
        }
    }
}
