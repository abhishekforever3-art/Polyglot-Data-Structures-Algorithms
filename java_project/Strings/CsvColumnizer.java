package String;

public class CsvColumnizer {
    public static void main(String[] args) {
        String s1 = " Abhi, 2 1/ 2/ 1000";
        String s2 = s1.replaceAll(" ", "");
        System.out.println(s2);
    }
}
