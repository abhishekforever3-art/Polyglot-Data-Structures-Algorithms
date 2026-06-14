public class CyclicNumber {

   public static int getDigitsCount( final int N){
    int temp = N;
    int count = 0;
    while (temp>0){
        count ++;
        temp = temp/10;
    
    }
    return count ;

   }
   public static int getDivisor ( final int N){
    int divisor = 1;
    for (int i=1; i<getDigitsCount(N); i++){
        divisor = divisor*10;
    }
    return divisor;

   }
   public static boolean rotateDigits( final int N, final int Multiple){
    int temp =N ;
    int rotate =1;
        do{
            int digits = temp%10;
            int  num = temp/10;
            rotate = (digits*getDivisor(N))+num;
            if (rotate == Multiple){
                return true;
            }
            temp = rotate;
            System.out.println("The rated num is "+ rotate);
        }while (temp!=N);
        

        return false; 
   }


   public static boolean isCyclicNumber(final int N){
        for (int i=2; i<=getDigitsCount(N); i++){
            int multiple = N*i;
            if (!rotateDigits(N, multiple)){
                return false;
            }

        }
        return true;
    }
   

   public static void main(String[] args) {
    int N = Integer.parseInt("142857");
   /*  int res = getDigitsCount(N);
    System.out.println(res);
    int res2 = getDivisor(N);
    System.out.println(res2);
    int res3= rotateDigits(N, multiple);
    System.out.println(res3);  */
    boolean res4 = isCyclicNumber(N);
    System.out.println(res4);
   }

      /* public static void main(String[] args) {
        int n = 142857;
        int temp = n;
    
        int count = 0;

        while (temp>0){
            count ++;
            temp = temp/10;
        }
        temp = n;

        int divisor = 1;
        for (int i=1; i<= count-1; i++){
            divisor = divisor*10;
        }
        System.out.println(divisor);

        do{
            int digits = temp%10;
            int  num = temp/10;
            int rotate = (digits*divisor)+num;
            System.out.println("The rated num is "+ rotate);
            temp = rotate;
        }

        while (temp!=n);  

    } */  
}
