package Strings;

public class UniversalCharacterMapper {
    public static void main(String[] args) {
        String s1 = "abhishek🚀";
        int rawCodeUnits = s1.length();
        
       
        int visualSymbols = s1.codePointCount(0, s1.length());
        
        
        System.out.println("Original Text   : " + s1);
        System.out.println("---------------------------------------");
        System.out.println("Internal Code Units (text.length()) : " + rawCodeUnits);
        System.out.println("Visual Symbols (codePointCount)     : " + visualSymbols);
        System.out.println("---------------------------------------");
        
        
        System.out.println("CRITICAL LESSON: Printing using a standard char loop:");
        System.out.print("Output: ");
        for (int i = 0; i < s1.length(); i++) {
            System.out.print("[" + s1.charAt(i) + "] ");
        }
        //System.out.println("\n(Notice how the rocket emoji was split into two broken pieces!)");
    }
}
