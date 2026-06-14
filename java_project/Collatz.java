public class Collatz {
    public static final int X=2;
    public static final int Y = 3;

    public static int isCollatz(int n){
        int count = 0;
    
        while (n!= 1){
            count ++;
            System.out.println("The Iteration no is : " + n);
            if (n%X==0){
                n=n/X;
            }
            else {
                n=n*Y+1;
            }
            
        
        }  
        return count;      
    }
    public static void main(String[] args) {
            int n = Integer.parseInt("10");
            int result = isCollatz(n);
            System.out.println("count of iterations is: " + result);
    }
    /* public static void main(String[] args) {
        int n = 35;
        int count = 0;
        while(n!=1){
            count ++;
            System.out.println("The Iteration no is : " + n);
            if (n%2 ==0){
            n= n/2;
        }
        else {
            n=n*3+1;
        }
           
        }
        System.out.println(count);
    } */
}
