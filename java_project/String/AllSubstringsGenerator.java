package String;

public class AllSubstringsGenerator {
    public static void main(String[] args) {
        String s1 = "abc";
        int length = s1.length();
        System.out.println("Generating all possible substrings for \"" + s1 + "\":\n");
        for (int start =0; start < length; start ++){
            for (int end = start; end < length; end ++){
                String sub = "";
                for (int i = start; i <= end; i++) {
                    sub = sub + s1.charAt(i);
                }
                System.out.println("Start: " + start + ", End: " + end + " -> \"" + sub + "\"");
            }
        }
    }
}
