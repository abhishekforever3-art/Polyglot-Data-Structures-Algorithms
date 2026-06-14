package String;

public class ExtensionIsolator {
    public static void main(String[] args) {
        String s1 = "abhishek.forever3@.gmail.com";
        int dotIndex = -1;
        int length = s1.length();
         
        for (int i = length - 1; i >= 0; i--) {
            if (s1.charAt(i) == '.'){
                dotIndex = i;
                break;
            }
        
        }

        if (dotIndex== -1 || dotIndex== length -1){
            System.out.println("Error: No valid file extension found.");
        }
        else{
            String extension = "";
            for (int i=dotIndex + 1; i<length; i++){
                extension =    extension + s1.charAt(i);
            }
            System.out.println("Full Filename : " + s1);
            System.out.println("Dot Located At: Index " + dotIndex);
            System.out.println("Extension Only: " + extension);
        }
    }
}
