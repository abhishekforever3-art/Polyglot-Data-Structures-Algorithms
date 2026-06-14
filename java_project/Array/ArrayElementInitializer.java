package Array;

public class ArrayElementInitializer {
    public static void main(String[] args) {
        int a[]= new int [10];
        for (int i=0; i<a.length; i++){
            a[i]=(i+1)*5;
            System.out.print(a[i]+"\t");
        }
        System.out.println("--the correct order");
         for (int i=a.length-1; i>=0; i--){
           // System.out.println("The reverse order ");
            System.out.print(a[i]+"\t");
        }
        System.out.println("--The reverse order "); 
    }
}
