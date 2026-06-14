public class planedrome2 {
    public static void main(String[] args) {
        int n = 12321;
        int reversed = 0;
        int original = n;
        while (n>0){
            int lastdigit = n%10;
            reversed = (reversed*10)+lastdigit;
            n = n/10;
        }
        if (original == reversed){
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}