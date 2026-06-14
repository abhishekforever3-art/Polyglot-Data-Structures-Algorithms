package Array.TwoDArray;

public class RotateMatrix {
    public static void main(String[] args) {
        int r=3;
        int c=3;
        int a[][] = new int[r][c];
        int counter = 1;
        System.out.println("original matrix:");
        System.out.println("--------------------");
        for (int row=0; row<a.length; row++){
            for (int col=0; col<a[row].length; col++){
                a[row][col]= counter;
                System.out.print(a[row][col]+ " \t");
                counter++;
            }
            System.out.println();
        }
        int transpose[][]= new int[r][c];
        for (int row=0; row<a.length; row++){
            for (int col=0; col<a[row].length; col++){
            transpose[col][row]= a[row][col];

            }

        }
        System.out.println("transpose Matrix"+ " ");
        System.out.println("--------------------");
        for (int row=0; row<transpose.length; row++){
            for (int col=0; col<transpose[row].length; col++){
                System.out.print(transpose[row][col] + "\t");
            }
            System.out.println();
        }
        for (int row=0; row<transpose.length;row++){
            int left=0; 
            int right= c - 1;

            while (left < right){
                int temp = transpose[row][left];
                transpose[row][left]= transpose[row][right];
                transpose[row][right]= temp;
                left++;
                right--;
            }

        }
        System.out.println("\nRotated 90 Degrees Clockwise:");
        System.out.println("--------------------");
        for (int row = 0; row<transpose.length; row++){
            for (int col=0; col<transpose[row].length; col++){
                System.out.print(transpose[row][col]+"\t");
            }
            System.out.println();
        }

    }
}
