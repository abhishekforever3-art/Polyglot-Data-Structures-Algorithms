package Strings;

public class VowelMaskingEngine {
    public static void main(String[] args) {
        String s1 = " abhishek";
        String s2 = "";
        int length = s1.length();
        for (int i =0; i<length ; i++){
            char ch = s1.charAt(i);
            if (ch == 'a' ||ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u' ||
                ch == 'A' ||ch == 'E' ||ch == 'I' ||ch == 'O' ||ch == 'U' ){
                s2 = s2+"*";
            }
            else{
                s2 = s2+ ch;
            }

        }
        System.out.println("Original Sentence: \"" + s1 + "\"");
        System.out.println("Masked Output    : \"" + s2 + "\"");

    }
}
