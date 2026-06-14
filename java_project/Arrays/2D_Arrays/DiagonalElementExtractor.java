package Array.TwoDArray;

public class DiagonalElementExtractor {
    public static void main(String[] args) {
        int a[][] = new int[3][3];
        int counter = 1;
        System.out.println("Original sequenmce");
        System.out.println("====================");
        for (int row=0; row<a.length; row++){
            for (int col=0; col<a[row].length; col++){
                a[row][col]= counter;
                System.out.print(a[row][col]+"\t");
                counter++;
            }
            System.out.println();
            
        }
        System.out.println("-----------------------");
        System.out.println("main Diagonal elements");
        for (int row=0; row<a.length; row++){
            for (int col=0; col<a[row].length; col++){
                if (row==col){
                    System.out.print(a[row][col]+ " ");
                }
                
            }
        }
        System.out.println();
        System.out.println("=======================");
        System.out.println("cross Diagonal elements");
        for (int row=0; row<a.length; row++){
            for (int col=0; col<a[row].length; col++){
                if ((row+col)==a.length-1){
                    System.out.print(a[row][col]+" ");
                }
                
            }
        }
        System.out.println();
    }
}
