package String;

public class LeetSpeakTranslator {
    public static void main(String[] args) {
        
        String text = "I am a software engineer";
        int length = text.length();
        
        String leetResult = "";
        
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            
            switch (ch) {
                case 'a':
                case 'A':
                    leetResult = leetResult + '4';
                    break;
                    
                case 'e':
                case 'E':
                    leetResult = leetResult + '3';
                    break;
                    
                case 'i':
                case 'I':
                    leetResult = leetResult + '1';
                    break;
                    
                case 'o':
                case 'O':
                    leetResult = leetResult + '0';
                    break;
                    
                case 's':
                case 'S':
                    leetResult = leetResult + '5';
                    break;
                    
                default:
                    leetResult = leetResult + ch;
                    break;
            }
        }
        
        System.out.println("Original Text: \"" + text + "\"");
        System.out.println("Leet Translation: \"" + leetResult + "\"");
    }
}