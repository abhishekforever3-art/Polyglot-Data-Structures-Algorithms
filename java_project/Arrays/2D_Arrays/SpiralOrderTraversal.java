package Array.TwoDArray;

public class SpiralOrderTraversal {
    public static void main(String[] args) {
        int r = 5;
        int c = 5;
        int a[][]= new int[r][c];
        int counter = 1;
        System.out.println("Original sequence");
        System.out.println("-------------------------");
        for (int row=0; row<a.length; row++){
            for(int col=0; col<a[row].length; col++){
                a[row][col]= counter;       
                System.out.print(a[row][col]+"\t");
                counter++;

            }
            System.out.println();
        }
        int top = 0;
        int bottom = a.length -1;
        int left = 0;
        int right = a[0].length - 1;
        System.out.println("Spiral Order:");
        while (top<=bottom && left<=right){
            for (int i= left ; i<=right; i++){
                System.out.print(a[top][i]+" ");
            }
            top++;
            for (int i=top; i<=bottom; i++){
                System.out.print(a[i][right]+" ");
            }
            right--;
            if (top<=bottom){
                for (int i = right; i >= left; i--) {
                    System.out.print(a[bottom][i] + " ");
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(a[i][left] + " ");
                }
                left++;
            }
        }

    }
}
