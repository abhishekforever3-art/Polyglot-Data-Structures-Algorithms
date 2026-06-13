package Array.TwoDArray;

public class BorderElementIsolation {
    public static void main(String[] args) {
        int a[][] = new int[5][5];
        int counter =1;
        System.out.println("original sequence of matrix");
        System.out.println(":=============================");
        for (int row=0; row<a.length; row++){
            for (int col = 0; col<a[row].length; col++){
                a[row][col]=counter;
                System.out.print(a[row][col]+" \t");
                counter++;
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
        System.out.println("Isolated Border Frame Result:");
        System.out.println("-----------------------------");
        for(int row=0; row<a.length; row++){
            for (int col=0; col<a[row].length; col++){
                if (row==0 || row == a[col].length-1 || col==0 || col== a[row].length-1){
                    System.out.print(a[row][col]+" \t");
                }
                
                else{
                    System.out.print("0\t");
                }
            }
            System.out.println();
        }
    }
}
