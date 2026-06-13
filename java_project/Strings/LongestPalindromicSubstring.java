package String;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s1 = "Abhba";
        int n = s1.length();
        if (n<1){
            System.out.println("Empty string provided.");
            return;
        }
        int maxLength = 0;
        int bestStart = 0;
        for (int i =0; i<n; i++){
            int left1 =i;
            int right1 = i;
            while (left1>=0 && right1 < n && s1.charAt(left1) == s1.charAt(right1)){
                int currentLen = right1 - left1 + 1;
                if (currentLen > maxLength) {
                    maxLength = currentLen;
                    bestStart = left1;
                }
                left1--;
                right1++;
            }
            int left2 = i;
            int right2 = i;
            while(left2>=0 && right2 < n && s1.charAt(left2)== s1.charAt(right2)){
                int currentLen = right2 - left2 + 1;
                if (currentLen > maxLength) {
                    maxLength = currentLen;
                    bestStart = left2;
                }
                left2 --;
                right2 ++ ;
            }
        }
        String longestPalindrome = "";
        for (int i = bestStart; i < bestStart + maxLength; i++) {
            longestPalindrome = longestPalindrome + s1.charAt(i);
        }
        System.out.println("Original String   : " + s1);
        System.out.println("Max Palindrome Len: " + maxLength);
        System.out.println("Longest Substring : \"" + longestPalindrome + "\"");
    }
}
