package Strings;

public class SegmentPuller {
    public static void main(String[] args) {
        String text = "abcdef";
        char startChar = 'b';
        char endChar = 'e';
        
        int startIndex = -1;
        int endIndex = -1;
        int length = text.length();
        
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == startChar) {
                startIndex = i;
                break; 
            }
        }
        
        if (startIndex != -1) {
            for (int i = startIndex + 1; i < length; i++) {
                if (text.charAt(i) == endChar) {
                    endIndex = i;
                    break; 
                }
            }
        }
        
        if (startIndex == -1 || endIndex == -1) {
            System.out.println("Error: One or both boundary characters were not found.");
        } else {
            
            String trappedText = "";
            
            for (int i = startIndex + 1; i < endIndex; i++) {
                trappedText = trappedText + text.charAt(i);
            }
            
            System.out.println("Original Text   : " + text);
            System.out.println("Start Border    : '" + startChar + "' at index " + startIndex);
            System.out.println("End Border      : '" + endChar + "' at index " + endIndex);
            System.out.println("Trapped Segment : \"" + trappedText + "\"");
        }
    }
}
