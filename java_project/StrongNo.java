public class StrongNo {
    public static void main(String[] args) {
        int n = 145;
        int sum = 0;
        int temp = n;
        while (temp>0){
            int lastdigit = temp%10;
            int factorial = 1;
            for (int i = 1; i <= lastdigit; i++){
                factorial = factorial * i;
            }
            sum =  sum + factorial;
            temp = temp/10;
        }
        if (sum == n){
            System.out.println(n+" is a Strong Number");
        } else {
            System.out.println(n+" is not a Strong Number");
        }
    }
}