package Array.TwoDArray;

public class DeclareAndInitialize {
    public static void main(String[] args) {
        int a[][] = new int[3][3];
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                a[row][col] = row * col + 8;
                System.out.print(a[row][col]+ " ");
            }
            System.out.println();
        }

    }
}
