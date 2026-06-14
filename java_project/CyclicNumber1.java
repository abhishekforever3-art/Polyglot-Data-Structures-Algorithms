public class CyclicNumber1{

    public static int getDigitCount(final int N){
        int temp=N;
        int count=0;
        while(temp>0){
            count++;
            temp=temp/10;
        }
        return count;
    }

    public static int getDivisor(final int N){
        int divisor=1;
        for(int i=1;i<getDigitCount(N);i++){
            divisor=divisor*10;
        }
        return divisor;
    }
    public static boolean rotateDigits(final int N,final int Multiples){
        int temp=N;
        int rotate=1;
        do{
            int digits=temp%10;
            int num=temp/10;
            rotate=digits*getDivisor(N)+num;
            System.out.println("The rotated number :"+rotate);
            if(rotate==Multiples){
                return true;
            }
            temp=rotate;
        }while(temp!=N);
        
        return false;
    }

    public static boolean isCyclicNumber(final int N){
       for(int i=2;i<=getDigitCount(N);i++){
        int multiple=N*i;

        if(!rotateDigits(N, multiple)){
            return false;
        }
       }
       return true;
    }
    public static void main(String[] args) {
        int N=Integer.parseInt("123456");
        boolean res=isCyclicNumber(N);
        System.out.println(res);

    
    }
}