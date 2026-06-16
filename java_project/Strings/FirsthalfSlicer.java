package Strings;

public class FirsthalfSlicer {
    public static void main(String[] args) {
        String s1 = "Abhishek";
        String s2 = "";
        int length = s1.length();
        int midpoint = length / 2;

        for (int i =0; i<midpoint ; i++){
            s2 = s2+s1.charAt(i);
        }
        System.out.println("Original String: " + s1);
        System.out.println("Total Length   : " + length);
        System.out.println("Midpoint Index : " + midpoint);
        System.out.println("First Half Only: " + s2);
    }
}
