package Array.TwoDArray;

public class SumOfAllElements {
    public static void main(String[] args) {
        int a[][]= new int[3][3];
        int b[][]= new int [3][3];
        int counter=1;
        int totalSum =0;
        for (int row=0; row<a.length; row++){
            for(int col=0; col<a[row].length; col++){
                a[row][col]= counter;
                System.out.print(a[row][col]+ "\t");
                counter++;
                totalSum = totalSum + a[row][col];

            }
            System.out.println();
        }
        System.out.println("Sum of all elements in Matrix A: " + totalSum);
        int count =1;
        int Sum=0;
        for (int row=0; row<a.length; row++){
            for(int col=0; col<b[row].length; col++){
                b[row][col]= count;
                System.out.print(b[row][col]+ "\t");
                count++;
                Sum = Sum + b[row][col];
            }
            System.out.println();
        }
        System.out.println("Sum of all elements in Matrix B: " + Sum);

        int CombinedSum = totalSum + Sum;
        System.out.println(CombinedSum+" is combined sum of A and B");

    }
}
