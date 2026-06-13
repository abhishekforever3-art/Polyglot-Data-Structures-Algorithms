package Array.TwoDArray;

public class SumDiagonalElements {
    public static void main(String[] args) {
        int a[][] = new int[3][3];
        int counter =1;

        int mainDiagonalSum = 0;
        int crossDiagonalSum = 0;

        for (int row=0; row<a.length; row++){
            for(int col=0; col<a[row].length; col++){
                a[row][col]= counter;
                System.out.print(a[row][col]+ "\t");
                counter++;
                if (row == col) {
                    mainDiagonalSum = mainDiagonalSum+a[row][col];
                }
                if ((row + col) == a.length - 1) {
                    crossDiagonalSum = crossDiagonalSum+a[row][col];
                }
            }
            System.out.println();
        }
        System.out.println("-------------");
        System.out.println("Main Diagonal Sum : " + mainDiagonalSum);
        System.out.println("Cross Diagonal Sum : " + crossDiagonalSum);
       

    }
}
