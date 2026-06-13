package Patterns;

public class NumberButterfly {
    public static void main(String[] args) {
        int n =5;
        // top half
        for (int i =1; i<=n; i++){
            //left wing
            for (int j=1; j<=i; j++){
                System.out.print(j);
            }
            // space gap
            for (int j = 1; j<=2*(n-i);j++){
                System.out.print(" ");
            }
            //right wing
            for (int j=i; j>=1; j-- ){
                System.out.print(j);

            }
            System.out.println();
            
        }
       /*  //bottom half
        for(int i=n-1; i>=1;i--){
            //left wing
            for (int j=1; j<=i; j++){
                System.out.print(j);
            }
            // space gap
            for (int j = 1; j<=2*(n-i);j++){
                System.out.print(" ");
            }
            //right wing
            for (int j=i; j>=1; j-- ){
                System.out.print(j);

            }
            System.out.println();

        } */
    }
}
