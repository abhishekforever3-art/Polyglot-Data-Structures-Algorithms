package Array.TwoDArray;

public class SymmenticMatrix {
    public static void main(String[] args) {
        int a[][]= new int[3][3];
        //int counter = 1;
        for (int row=0; row<a.length; row++){
            for (int col=0; col<a[row].length; col++){
                //a[row][col]= counter;
                a[row][col] = row + col + 1;
                System.out.print(a[row][col]+" \t");
                //counter ++;
            }
            System.out.println();
        }
        boolean isSymmentric = true;
        for (int row = 0; row<a.length; row ++){
            for (int col=0; col<a[row].length; col++){
                if (a[row][col]!=a[col][row]){
                    isSymmentric = false;
                    break;
                }
            }
            if (!isSymmentric) {
                break;
            }
        }
        if (isSymmentric){
            System.out.println( "Verdict: The matrix is Symmetric!");
        }
        else{
            System.out.println("Verdict: The matrix is not Symmetric!");
        }
    }
}
