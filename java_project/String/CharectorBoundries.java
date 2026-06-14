package String;

public class CharectorBoundries {
    public static void main(String[] args) {
        String s1 = "java";
        System.out.println(s1);
        
        if (s1 == null || s1.length() == 0) {
            
            System.out.println("Graceful Message: The provided string is empty!");
            
        }
        else{
        System.out.println("Get length of s1: "+  s1.length());
        System.out.println("first charector of the s1: "+s1.charAt(0));
        System.out.println("last charector of the s1: "+s1.charAt(s1.length()-1));

        }
    }
}
