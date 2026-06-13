public class TribonacciSequence {
    public static void main(String[] args) {
        int a=0;
        int b=0;
        int c=1;
        int n=10;
        for (int i=1; i<n; i++){
            int d = a+b+c;
            a = b;
            b = c;
            c = d;
            System.out.print(a+" ");
        }
    }
}
