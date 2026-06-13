package String;

public class InitialsConcatinators {
    public static void main(String[] args) {
       /*  String s1 = "Mark";
        String s2 = "stephen";
        String s3 = "Antony";
        System.out.println("Concatenation using + : " + ( s1 +" "+ s2 +" "+ s3 ) ); */

        String s1 = "ram kalyan sharma";
        String[] words = s1.split(" ");
        for (String word: words){
            System.out.println(word.charAt((0)));
            System.out.println(word + " ");
        }
    }
}
