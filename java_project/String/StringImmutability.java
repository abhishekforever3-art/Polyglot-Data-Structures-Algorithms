package String;

public class StringImmutability {
    public static void main(String[] args) {
        
        String text = "A";
        
        System.out.println("--- Starting Condition ---");
       
        System.out.println("Initial Text   : " + text);
        System.out.println("Initial Address: " + System.identityHashCode(text));
        System.out.println("--------------------------\n");
        
        System.out.println("--- Starting Loop (Appending 5 Times) ---");

        for (int i=0; i<=5; i++){
            text = text + "X";

            System.out.println("Step " + i + " Text   : " + text);
            System.out.println("Step " + i + " Text   : " + System.identityHashCode(text));
            System.out.println();
        }  
    } 
} 