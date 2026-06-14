package Array;

public class SpecificIndexSwapper {
    public static void main(String[] args) {
        int a[]=new int [6];
        for (int i=0; i<a.length; i++){
            a[i]=i*10+1;
            System.out.print(a[i]+"\t");
        }
        System.out.println("Original sequence");
        int temp=a[1];
        a[1]=a[4];
        a[4]=temp;
        for (int i=0; i<a.length;  i++){
           System.out.print(a[i]+"\t");
        }
        System.out.println("swapped sequence");

    }
}
