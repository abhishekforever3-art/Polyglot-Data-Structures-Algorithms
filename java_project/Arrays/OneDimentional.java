package Arrays;

public class OneDimentional {
    public static void main(String[] args) {
        int a[] = new int [5];
        /* a[0]=1;
        a[1]=2;
        a[2]=3;
        a[3]=4;

        System.out.println(a[0]); */
        for (int i=0; i<a.length; i++){
            a[i]=i*10+1;
            System.out.println(a[i]);
        }
    }
}
