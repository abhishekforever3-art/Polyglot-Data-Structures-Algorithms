package Strings;

public class NegativeBoundaryNormalizer {
    public static void main(String[] args) {
        String s1 = "Abhishek";
        int start = -3;
        int end = -1;
        int length = s1.length();
        if (start<0){
            start = length + start;
        }
        if (end<0){
            end = length + end;
        }
        if (start < 0 || end > length || start > end) {
            System.out.println("Error: Normalized indices out of practical string bounds.");
        }
        else {
            String Sliced = "";

            for (int i =start;i<end ; i++ ){
                Sliced = Sliced+ s1.charAt(i);
            }
            System.out.println("------------------------------------");
            System.out.println("Normalized Positive Start: " + start);
            System.out.println("Normalized Positive End  : " + end);
            System.out.println("Extracted Result         : \"" + Sliced + "\"");
        }
    }
}
