public class DisariumNumber {
    public static void main(String[] args) {
        int n = 135;
        int temp = n;
        int count = 0;
        int sum = 0;
        while (temp>0){
            count ++;
            temp = temp/10;

        }
        temp = n;
        while (temp>0){
            int digit = temp %10;
            sum = sum+(int)Math.pow(digit, count);
            count --;
            temp = temp/10;
        }
        if (sum ==n){
            System.out.println(n+" Disarium Number");
        }
        else{
            System.out.println(n+"  Not Disarium Number");
        }
        

    }
    
}
