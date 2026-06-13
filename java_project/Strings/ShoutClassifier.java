package String;

public class ShoutClassifier {
    public static void main(String[] args) {
        String s1 = " Abhi 2026!";
        String s2 = "";
        for (int i = 0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            if (ch >= 'a' && ch <= 'z'){
                char upperCh = (char) (ch - 32);
                s2 = s2 + upperCh;
            }
            else{
                s2 = s2+ch;
            }
            
        }
        System.out.println("Original Input  : \"" + s1 + "\"");
        System.out.println("Shout Conversion: \"" + s2 + "\"");
    }
}
