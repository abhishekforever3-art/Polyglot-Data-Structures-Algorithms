package String;

public class AlphaNumaricCounter {
    public static void main(String[] args) {
        String s1 = "Abhi 2026!";
        int letterCount = 0;
        int digitcount = 0;
        int symboleCount = 0;
        //String s3 = " ";
        for (int i=0; i<s1.length(); i++){
            char x = s1.charAt(i);
            if (Character.isLetter(x)){
                letterCount++;
            }
            else if (Character.isDigit(x)){
                digitcount++;

            }
            else if (Character.isWhitespace(x) ){
                
            }
            else {
                symboleCount++;
            }
        }
        System.out.println("Original Text: \"" + s1 + "\"");
        System.out.println("-------------------------");
        System.out.println("Letters count: " + letterCount);
        System.out.println("Digits count : " + digitcount);
        System.out.println("Symbols count: " + symboleCount);
    }
}
