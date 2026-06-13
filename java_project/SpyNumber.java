public class SpyNumber {
    public static void main(String[] args) {
        int n = 132;
        int q = n;
        int temp = n;
        int sum = 0;
        int product = 1;
        

        while(temp>0){
            int digit = temp%10;
            sum= sum+digit;
            product = product*digit;
            temp = temp/10;

        }
        System.out.println("the sum of the digits = "+sum);
        //int product = 1;

        /* while (n>0){
            int digit = n%10;
            product = product*digit;
            n = n/10;
        } */
        System.out.println("the sum of the digits = "+product);
        if (sum == product){
            System.out.println(q+" is a Spy Number");
        }
        else{
            System.out.println(q+" is not a Spy Number");
        }
    }
    
}
