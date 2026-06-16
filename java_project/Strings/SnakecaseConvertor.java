 package Strings;

public class SnakecaseConvertor {
    public static void main(String[] args) {
        String s1 = "myVariableName";
        String s2 = "";
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            char ch = s1.charAt(i);
            
            if (ch >= 'A' && ch <= 'Z') {
                    char lowerChi = (char) (ch + 32);

                    s2 = s2 + '_' + lowerChi;

                } else {
                    s2 = s2 + ch;
                }

        }
        System.out.println("Original camelCase: " + s1);
        System.out.println("Converted snake_case: " + s2);
    }
}
 
/* 
package String;

public class SnakecaseConvertor {
    public static void main(String[] args) {
        
        String s1 = "myVariableName";
        int length = s1.length();
        
        boolean hasCamelCase = false;
        
        for (int i = 0; i < length - 1; i++) {
            char current = s1.charAt(i);
            char next = s1.charAt(i + 1);
            
            if ((current >= 'a' && current <= 'z') && (next >= 'A' && next <= 'Z')) {
                hasCamelCase = true;
                System.out.println("CamelCase pattern found at index " + i + " to " + (i + 1) + ": \"" + current + next + "\"");
                break; 
            }
        }
        
        System.out.println("---------------------------------------");
        System.out.println("Does string have camelCase? " + hasCamelCase);
    }
} */