public class NarsimhaNumber {
    public static void main(String[] args) {
        int n = 31 ;
        int temp = n;
        boolean isPrime = true;
        for (int i= 2; i<temp ; i++){
            if(temp%i==0){
                isPrime = false;
                break;
            }
            
            

        }
        //if (isPrime){
            System.out.println(n  + " is a prime number " +  isPrime);
        //}
    
        if (isPrime){
            temp = n+1;

            while (temp>1){
                if (temp%2!=0){
                    isPrime = false;
                    break;
                }
                temp = temp/2;
            }
        }
        if (isPrime){
            System.out.println(n+ " is a Narasimha Number");
        }
        else{
            System.out.println(n+ " is not a Narasimha Number");
        }
    }
    
}
