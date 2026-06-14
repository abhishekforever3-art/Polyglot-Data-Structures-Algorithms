public class SeparatingNumber {
    public static void main(String[] args) {
        int num = 1234;
        
        // 1. Find the highest place value divisor (for 1234, it is 1000)
        int divisor = 1;
        int temp = num;
        while (temp >= 10) {
            divisor *= 10;
            temp /= 10;
        }
        
        // 2. Extract and print digits from left to right
        temp = num;
        while (divisor > 0) {
            int digit = temp / divisor; // Extracts the leftmost digit
            
            System.out.print(digit);
            
            temp %= divisor;            // Removes the leftmost digit from temp
            divisor /= 10;              // Moves the divisor down (1000 -> 100 -> 10 -> 1)
            
            // Just adding commas between numbers for clean formatting
            if (divisor >= 0) {
                System.out.print(", ");
            }
        }
    }
}