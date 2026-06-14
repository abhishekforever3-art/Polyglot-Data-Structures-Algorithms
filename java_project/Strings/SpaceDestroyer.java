package String;

public class SpaceDestroyer {
    public static void main(String[] args) {
        String s1 = "  Hello World  ";
        int length = s1.length();

        int start = 0;
        int end = s1.length()-1;

        while (start < length && s1.charAt(start) == ' ') {
            start++;
        }
        while (end >= 0 && s1.charAt(end)== ' '){
            end--;
        }
        if (start > end) {
            System.out.println("Result: Empty string or full of spaces.");
        } else {
            
            String cleanedText = "";

            for (int i= start; i<= end ; i++){
                cleanedText = cleanedText+s1.charAt(i);
            }
            System.out.println("Original String : \"" + s1 + "\"");
            System.out.println("Left Boundary   : Index " + start);
            System.out.println("Right Boundary  : Index " + end);
            System.out.println("Cleaned String  : \"" + cleanedText + "\"");
        }
            
    }
}
