package Array.TwoDArray;

public class IdentityMatrixValidator {
    public static void main(String[] args) {
         int a[][] = {
            { 1,  0, 0},
            { 0,  1,  0},
            { 0, 0,  1}
        }; 
        //int a[][]= {{1}};
    
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                if (a[row].length==1 && a[col].length==1){
                    System.out.println("the give matrix is not a Identity matrix");
                
                }

                System.out.print(a[row][col] + "\t");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
        boolean isIdentity = true;
        
        for (int row =0; row<a.length; row++){
            for (int col=0; col<a[row].length; col++){
                if (row == col && a[row][col] != 1) {
                    isIdentity = false;
                    break;
                }
                if (row!=col && a[row][col]!=0){
                    isIdentity = false;
                    break;
                }
                
            }
            if (!isIdentity){
                break;
            }
        }
        if(isIdentity){
            System.out.println("the given matix is identity matrix");
        }
        else{
            System.out.println("the give matrix is not identity matrix");
        }
    }
}
