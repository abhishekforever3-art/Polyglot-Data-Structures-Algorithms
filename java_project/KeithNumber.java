public class KeithNumber {
    public static void main(String[] args) {
        int n = 198;
        int temp =n;
        /* int sum = 0;
        int count = 0; */
        int temp2 = 0;
        if (n < 10) {
            System.out.println(n + " is NOT a Keith number.");
            return;
        }    
        while (temp>0){
            temp2++;
            temp/=10;
        }
        System.out.println(temp2);
        int[] digits = new int [n];
        temp = n;
        for(int i=n-1; i>0; i--){
            digits[i]= temp%10;
            temp/=10;
        } 
        int currentSum =0;
        int index = 0;
        while (currentSum<n){
            currentSum=0;
            for (int i=0; i<n; i++){
                currentSum+= digits[i];
            }
            digits[index % n] = currentSum;
            index++;
        }
        if (currentSum == n) {
            System.out.println(n + " is a Keith number.");
        } else {
            System.out.println(n + " is NOT a Keith number.");
        }
        

       /*  while (n>0){
            n=n/10;
            count++;
        }
        System.out.println(count);
        while (temp>0){
            int digit = temp%10;
            sum+=digit;
            temp/=10;
        }
        System.out.println(sum);
         */

    }
    
}
