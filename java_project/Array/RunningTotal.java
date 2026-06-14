package Array;

public class RunningTotal {
    public static void main(String[] args) {
        int a[] = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = (i + 30) * 2;
            System.out.print(a[i] + "\t");
            

        }
        System.out.println("original sequence");
        for (int val:a){
            System.out.print(val+" ");
        }
        System.out.println();
        for (int i = 1; i < a.length; i++) {
            a[i] = a[i] + a[i - 1];
            System.out.print(a[i]+" ");

        }
        System.out.println();
        System.out.println("TRANSFORM RUNNING TOOL");
        for (int val : a) {
            System.out.print(val + " ");
        }
        System.out.println();

    }

}
