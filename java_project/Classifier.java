public class Classifier {

    public static int sumOfFactors(int N){
        int sum = 0;
        for (int i = 1; i<N; i++){
            if(N%i==0){
                sum = sum + i;
            }

        }
        return sum;
    }
    public static void main(String[] args) {
        int N = Integer.parseInt("25");
        System.out.println(sumOfFactors(N));
        if (sumOfFactors(N)==N){
            System.out.println("Perfect Number");
        }
        if (sumOfFactors(N)>N){
            System.out.println("Deficient Number");
        }
        if (sumOfFactors(N)<N){
            System.out.println("Abonded Number");
        }
    }

    /* public static void main(String[] args) {
        int n = 143;
        int sum = 0;
        for ( int i= 1; i<n; i++){
            if (n%i==0){
                sum=sum+i;
            }
        }
        if (sum==n){
            System.out.println("Perfect Number");
        }
        if (sum<n){
            System.out.println("Abonded number");
        }
        if (sum>n){
            System.out.println("deficient Number");
        }
        
    } */
    
}
