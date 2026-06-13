public class Palendrome {
    public static void main(String[] args) {
        int n = 12321;
        int originalNumber = n;
        int reversed = 0;
        while(n>0){
            int lastdigit = n % 10;
            reversed = (reversed*10) + lastdigit;
            n = n/10;
        }
        if (originalNumber == reversed) {
            System.out.println("palendrome");
        }
        if (originalNumber!= reversed) {
            System.out.println("not a palendrome");
        }
        
    }
}