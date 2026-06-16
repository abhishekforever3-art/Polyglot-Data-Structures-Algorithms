package Strings;

public class SlidingSubstringUniqeCharector {
    public static void main(String[] args) {
        String s1 = "abhishek";
        int n = s1.length();
        int maxLength = 0;
        int left = 0;
        int[] Counts = new int[128];
        for (int right = 0; right < n; right++) {
            char rightChar = s1.charAt(right);
            Counts[rightChar]++;
            while (Counts [rightChar]> 1){
                char leftChar = s1.charAt(left);
                Counts[leftChar]--;
                left++;
            }
            int currentWindowLength = right - left + 1;
            if (currentWindowLength > maxLength) {
                maxLength = currentWindowLength;
            }
        }
        System.out.println("Original String: " + s1);
        System.out.println("Max Unique Substring Length: " + maxLength);
    }
}
