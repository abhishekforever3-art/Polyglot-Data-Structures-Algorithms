package Patterns;

public class PasclesTriangle {
    public static void main(String[] args) {
        int n = 10;
        for (int i=0; i<=n; i++){
            for (int j=0; j<n-i; j++){
                System.out.print(" ");
            }
            int num =1;
            for (int k = 0; k<=i; k++){
                System.out.print(num+" ");
                num = num*(i-k)/(k+1);
            }
            System.out.println();
        }
    }
}
