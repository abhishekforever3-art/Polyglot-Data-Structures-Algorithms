    package String;

    public class ReverseString {
        public static void main(String[] args) {
            String text = "Abhishek";
            int k = 3;
            int length = text.length();
            
            String rotatedResult = "";
            
        
            for (int i = length - 1; i >= length - k; i--) {
                rotatedResult = rotatedResult + text.charAt(i);
            }
            
            
            for (int i = 0; i < length - k; i++) {
                rotatedResult = rotatedResult + text.charAt(i);
            }
            
            // 3. Print the final result
            System.out.println("Original String: " + text);
            System.out.println("Rotated by K'th Position Result  : " + rotatedResult);
        

        }
    }
            
        

