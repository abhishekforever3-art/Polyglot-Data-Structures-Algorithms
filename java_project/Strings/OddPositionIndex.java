package String;

public class OddPositionIndex {
    public static void main(String[] args) {
        String s1 = "Abhishek Java";
        for (int i=0; i<s1.length()-1; i++){
            if (i%2!=0){
                System.out.print(s1.charAt(i)+ " ");
            }
        }

    }
}
