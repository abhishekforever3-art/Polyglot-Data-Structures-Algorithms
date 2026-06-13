package Array.TwoDArray;

public class MaxNumberOfOnes {
    public static void main(String[] args) {
        int a[][]={
            {0,1,1,1},
            {1,1,1,1},
            {0,0,1,1},
            {0,0,0,1}
        };
        System.out.println("origibnal sequence");
        for (int row = 0; row<a.length; row++){
            for (int col = 0; col<a[row].length; col++){
                System.out.print(a[row][col]+" \t");
            }
            System.out.println();
        }
        int row =0; 
        int column = a[0].length-1;
        int max = 0;

        while (row<a.length && column>=0){
            if (a[row][column]==1){
                max=row;
                column--;
            }
            else{
                row++;
            }

        }
        System.out.println("The row with the maximum number of 1s is Row Index: "  + max);
    }
}
