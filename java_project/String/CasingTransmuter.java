package String;

public class CasingTransmuter {
    public static void main(String[] args) {
        String s1 = "abhi";
        int length = s1.length();
        String s2 = "";
        for (int i =0; i<length; i++){
            char ch = s1.charAt(i);
            if (i%2==0){    
                if (ch >= 'a' && ch <= 'z') {
                    ch = (char) (ch - 32);
                }
                s2 = s2 + ch;
            }
            else{
                if (ch >= 'A' && ch <= 'Z') {
                    ch = (char) (ch + 32);
                }
                s2 = s2 + ch;
            }
        }
        System.out.println("Original Text: " + s1);
        System.out.println("Transmuted   : " + s2);
    }
}
