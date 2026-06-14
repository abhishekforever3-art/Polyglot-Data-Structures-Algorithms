public class AutomorphicNumber {

    public static int getDigitsCount( final int N) {
        int count =0;
        int temp=N;
        while (temp>0){
            temp=temp/10;
            count++;
        }
        return count;
   }
   public static int square(int N){

    return N*N;

   }
   
   public static int getDivisorOfDigits(int N){
        int divisor = 1;
        for (int i=1; i<=getDigitsCount(N); i++){
            divisor= divisor*10;

        }
        return divisor;
    }
    public static boolean isAutomrphic(int N){
        return square(N)% Math.pow(N,getDigitsCount (N))==N;

    }
    public static void main(String[] args) {
        int N = Integer.parseInt("25");
        System.out.println(getDigitsCount(N));
        System.out.println(square(N));
        System.out.println(getDivisorOfDigits(N));
        if(isAutomrphic(N))
        {
            
            System.out.println("Antomorphic Number");
        }
        else{
            System.out.println("Not Antomorphic Number");
        }
    }
 
   /*   public static void main(String[] args) {
        int num = 25;
        int count =0;
        int temp=num;
        while (temp>0){
            temp=temp/10;
            count++;
        }
        System.out.println(count); 
        int square = num*num;
        System.out.println(square); 

        int divisor=1;
        for(int i=1; i<=count ; i++){
            divisor=divisor*10;
        }
        System.out.println(divisor);
        if (square%divisor==num){
            System.out.println("Automorphic Number");
        }
        else{
            System.out.println("Not AutomorphicNumber");
        }
    } */
}
 

