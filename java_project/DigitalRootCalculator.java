public class DigitalRootCalculator {
    public static void main(String[] args) {
        int n = 9875;
        while (n>9){
            int temp = n;
            int sum = 0;
            while (temp>0){
                int digit = temp%10;
                sum = sum+ digit;   
                temp = temp/10;
            }
            n=sum;  
        }
        System.out.println(n);
        
       
    }
}
