public class EmirpNumber {
    public static void main(String[] args) {
        int n = 11;
        int temp = n;
        int reversed = 0;
        boolean isPrimeOriginal = true;
        boolean isPrimeReversed = true;


        for (int i=2; i<n; i++){
            if (n%i==0){
                isPrimeOriginal = false;
            }
        }
        System.out.println(n+" the given original number is prime "+isPrimeOriginal);

        while(temp>0){
            int digit = temp%10;
            reversed = reversed*10+digit;
            temp = temp/10;
        }
        System.out.println("the reversed number is "+reversed);
        int num = reversed;

        for (int j=2; j<n; j++){
            if(num%j==0){
                isPrimeReversed = false;
            }

        }
        System.out.println("the reversed number is prime: "+isPrimeReversed);
        if (reversed==n){
            System.out.println("the given number is not a Emirp number");
        }
        else{
            System.out.println("the given number is Emirp number");
        }
    }
}
