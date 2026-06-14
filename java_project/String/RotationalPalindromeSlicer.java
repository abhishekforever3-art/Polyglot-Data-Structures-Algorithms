package String;

public class RotationalPalindromeSlicer {
    public static void main(String[] args) {
        String s1 = "radars";
        int n = s1.length();
        int length = n-1;
        
        boolean palindromeSliceFound = false;
        String s2 = "";
        for (int start = 0; start < n- length; start++){
            String s3 = "";
            for (int j =0; j<length ; j++){
                s3 = s3+ s1.charAt(start+j);
                System.out.println(s3);
            }
            int left = 0;
            int right =s3.length()-1;
            boolean ispalendrome = true;
            while (left<right){
                if (s3.charAt(left)!=s3.charAt(right)){
                    ispalendrome = false;
                    break;
                }
                right --;
                left ++;
            }
            if (ispalendrome){
                palindromeSliceFound = true;
                s2=s3;
                break;
            }
        }
        System.out.println("Original Text (" + n + " letters): " + s1);
        System.out.println("Target Slice Size (N-1) : " + length);
        System.out.println("----------------------------------------");
        if (palindromeSliceFound) {
            System.out.println("Result: TRUE! Found a palindrome slice: \"" + s2 + "\"");
        } else {
            System.out.println("Result: FALSE. No substring slice of length " + length + " is a palindrome.");
        }
    }
}
