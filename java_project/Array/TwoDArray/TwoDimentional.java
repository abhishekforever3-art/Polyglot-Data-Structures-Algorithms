package Array.TwoDArray;

public class TwoDimentional {
    public static void main(String[] args) {
        int[][] a= new int[3][4];
        for (int i=0; i<a.length;i++){
            for (int j=0; j<a[i].length; j++){
                a[i][j]=i*j+1;
                System.out.print(a[i][j]+"\t");

            }
            System.out.println();
        }
        //System.out.println(a[i][j]);
    }
}
