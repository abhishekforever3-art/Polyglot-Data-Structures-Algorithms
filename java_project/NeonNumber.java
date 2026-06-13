public class NeonNumber {
    public static void main(String[] args) {
        
        int number = 9;

        
        int square = number * number;

        System.out.println(square);

        
        int sumOfDigits = 0;
        int tempSquare = square; 

        while (tempSquare > 0) {
            int digit = tempSquare % 10;
            sumOfDigits += digit; 
            tempSquare /= 10; 
        }

        
        if (sumOfDigits == number) {
            System.out.println(number + " is a Neon Number.");
        } else {
            System.out.println(number + " is NOT a Neon Number.");
        }
    }
}
