public class KaprekarNumber {
    public static void main(String[] args) {
        int n = 297;
        int count = 0;
        int temp = n;
        while (temp>0){
            count ++;
            temp = temp/10;
        }
        System.out.println(count);


        int sqr = (int)Math.pow(n, 2);
        System.out.println(sqr);

        int divisor= 1;
        for (int i=1; i<count+1; i++){
            divisor = divisor*10;
        }
        System.out.println(divisor);

        int firstHalf = sqr/divisor;
        int seconHalf = sqr%divisor;

        if(firstHalf+seconHalf==n){
            System.out.println(n+" is a Kaprekar Number");
        }
        else{
            System.out.println(n+" is not a Kaprekar number");
        }

        


    }
}
