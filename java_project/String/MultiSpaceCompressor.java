package String;

public class MultiSpaceCompressor {
    public static void main(String[] args) {
        
        String text = "Java   is    fun   2026";
        int length = text.length();
        
        String compressedResult = "";
        
        boolean spaceAlreadyPrinted = false;
        
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            
            if (ch == ' ') {
                if (spaceAlreadyPrinted == false) {
                    compressedResult = compressedResult + ch;
                    spaceAlreadyPrinted = true; 
                }
            } 
            else {
                compressedResult = compressedResult + ch;
                spaceAlreadyPrinted = false; 
            }
        }
        
        System.out.println("Original Text   : \"" + text + "\"");
        System.out.println("Compressed Text : \"" + compressedResult + "\"");
    }
}