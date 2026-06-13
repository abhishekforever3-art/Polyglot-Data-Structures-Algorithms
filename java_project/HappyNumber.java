public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        final int q = 10;
        while (n!=1 && n!= 4){
            int sum = 0;
            int temp = n;
            while (temp>0){
                int digit =temp% q;
                sum = sum+digit*digit;
                temp = temp/q;
            }
            n= sum;
            System.out.println("1 "+ sum);
            System.out.println("2 "+ temp);
        }
        if (n==1){
            System.out.println(n+" is a happy number");
        }
        else{
            System.out.println(n+" is not a happy number");
        }
    }
}
