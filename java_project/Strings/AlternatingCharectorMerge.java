package String;

public class AlternatingCharectorMerge {
    public static void main(String[] args) {
        String s1 = "Acegi";
        String s2 = "bdfhj";
        String s3 = "";
        for (int i =0; i<s1.length();i++){
            s3 = s3+s1.charAt(i);
            s3 = s3+ s2.charAt(i);

            System.out.println(s3+" ");

        }

    }
}
