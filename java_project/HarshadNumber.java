public class HarshadNumber {
    public static void main(String[] args) {
        int n = 18;
        int temp = n;
        int sum = 0;

        while (temp>0){
            int digit = temp%10;
            sum = sum+digit;
            temp = temp/10;
        }
        System.out.println("the given original number sum is: "+sum);
        if (n%sum == 0){
            System.out.println("the given original number is Harshad number");
        }
        else{
            System.out.println("the given original number is not a Harshad Number");
        }
    }
    
   
        
   
}
