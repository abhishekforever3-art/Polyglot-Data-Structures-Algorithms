package Array.TwoDArray;

public class CordinatesOfElements {
    public static void main(String[] args) {
        int a[][]= new int [3][3];
        int x =3;
        int counter = 1;
        for (int row=0; row<a.length; row++){
            for (int col=0; col<a[row].length; col++){
                a[row][col]=counter;
                System.out.print(a[row][col]+" \t");
                counter ++;
            }
            System.out.println();
        }
        boolean found = false;
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                
                
                if (a[row][col] == x) {
                    System.out.println("Target " + x + " found at coordinate pair: [" + row + ", " + col + "]");
                    found = true; 
                    break;       
                }
                
            }
            if (found) {
                break;
            }
        }

        if (!found) {
            System.out.println("[-1, -1]");
        }
    }
}