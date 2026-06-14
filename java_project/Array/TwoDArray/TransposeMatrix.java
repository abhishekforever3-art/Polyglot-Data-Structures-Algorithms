package Array.TwoDArray;

public class TransposeMatrix {
    public static void main(String[] args) {
        int a[][]= new int[3][3];
        int counter = 1;
        
        for (int row=0; row<a.length; row++){
            for(int col=0; col<a[row].length; col++){
                a[row][col]= counter;
                System.out.print(a[row][col]+"\t");
                counter++;
            }
            System.out.println();
        }

        int transpose[][]= new int[3][3];
        for (int row=0; row<a.length; row++){
            for (int col=0 ; col<a[row].length;col++ ){
                transpose[col][row]=a[row][col];
            }
        }
        System.out.print("transpose Matrix"+ " ");
        System.out.println();
        for (int row=0; row<transpose.length; row++){
            for (int col=0; col<transpose[row].length; col++){
                System.out.print(transpose[row][col] + "\t");
            }
            System.out.println();
        }
    }
}
