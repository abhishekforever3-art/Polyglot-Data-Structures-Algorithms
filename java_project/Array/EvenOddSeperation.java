package Array;

public class EvenOddSeperation {
    public static void main(String[] args) {
        int a[]=new int[10];
        int b[]=new int[a.length];
        for (int i=0; i<a.length;i++){
            a[i]=i+1;
            //System.out.print(a[i]+"\t");
            if (i%2==0){
                System.out.print(i+"\t");
            }
        }
        System.out.println("even sequence");
        for (int i=0; i<b.length;i++){
            b[i]=i+1;
            //System.out.print(b[i]+"\t");
            if (i%2!=0){
                System.out.print(i+"\t");
            }
        }
        System.out.println("Odd sequence");

    }
}
