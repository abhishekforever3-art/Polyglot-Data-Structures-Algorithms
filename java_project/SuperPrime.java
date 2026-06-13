 public class SuperPrime {/* 
    public static boolean isPrime(int N) {
        boolean isPrime = true;
        for(int i=2; i<N; i++){
            if(N%i==0){
        
                isPrime = false;
                break;
            }   
        }
        return isPrime;
        }
        public static boolean isSuperPrime(final int N){
            int temp = N;
            boolean flag = true;
            while (temp>0){
                if (isPrime(temp)){
                    temp=temp/10;
                    System.out.println(temp);
                }
                else {
                    flag = false;
                    break;

                }
                
                }
            
            return flag;
        }
        public static void main (String[]args){
            int N = Integer.parseInt("739397");
            if (isSuperPrime (N)){
                System.out.println(N + " is a Super Prime Number");
            }
            else{
                System.out.println(N + " is not a Super Prime Number");
            }


        
   } */
    public static void main(String[] args) {
        int N = 739397;
        int temp = N;
        boolean flag = true;

        while (temp > 0) {
            boolean isPrime = true;

            for (int i = 2; i < temp; i++) {
                if (temp % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                temp = temp / 10;
                System.out.println(temp);
            } else {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println(N + " is a Super Prime Number");
        } else {
            System.out.println(N + " is not a Super Prime Number");
        }
    }  
}
 