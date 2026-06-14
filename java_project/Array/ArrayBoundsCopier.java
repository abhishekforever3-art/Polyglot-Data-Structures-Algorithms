package Array;

public class ArrayBoundsCopier {
    public static void main(String[] args) {
        int l=5;
        int p =10;
        int q=2;
        int a[]= new int[l];
        int b[]= new int [a.length];
        for (int i =0; i<a.length; i++){
            a[i]=i+1*p;
            System.out.print(a[i]+"\t");
        }
        System.out.println("Sequence of A ");
        for (int i =0; i<b.length; i++){
            b[i]=i+1*10;
            System.out.print(b[i]+"\t");
        }
        System.out.println("Sequence of b ");
        for (int i =0; i<b.length; i++){
            if (i%2!=0){
                b[i]=b[i]*q;
                System.out.print(b[i]+"\t");
            }
        }
        System.out.println("multiples of 2");
        for (int i=0; i<b.length; i++){
            System.out.print(b[i]+"\t");    
        }
        System.out.println("replaced odd positions with 2 multiples");
    }
}
