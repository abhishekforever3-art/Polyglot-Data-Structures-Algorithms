package String;

public class IndexFinder {
    public static void main(String[] args) {
        String s1 = "Hello";
        System.out.println("From 1 to 4: "+s1.substring(0, 5));
        System.out.println("Index of : "+s1.indexOf("H"));
        System.out.println("Starts with : "+s1.startsWith("Hel"));
    }
}
