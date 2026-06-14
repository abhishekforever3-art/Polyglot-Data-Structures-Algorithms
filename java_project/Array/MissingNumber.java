/* package Array;

public class MissingNumber {
    public static void main(String[] args) {

        int a[] = {11, 12, 15, 18};

        for (int i = 0; i < a.length - 1; i++) {

            int current = a[i];
            int next = a[i + 1];

            for (int j = current + 1; j < next; j++) {
                System.out.println("Missing Number: " + j);
            }
        }
    }
} */

package Array;

public class MissingNumber {
    public static void main(String[] args) {
        // Your hardcoded array with multiple gaps
        int[] n = { 11, 12, 15, 18 };
        
        // Grab the start and end boundaries
        int min = n[0];
        int max = n[n.length - 1];

        // Create a checklist from 0 up to our max value (size needs to be max + 1)
        // This array starts filled with 'false' at every position
        boolean[] checklist = new boolean[max + 1];

        // Step 1: Place a checkmark (set to true) for every number present in our array
        for (int i = 0; i < n.length; i++) {
            int presentNumber = n[i];
            checklist[presentNumber] = true; 
        }

        // Step 2: Walk through our checklist from min to max and spot the false entries
        System.out.print("The missing numbers are: ");
        for (int i = min; i <= max; i++) {
            // If the box is still false, it means that number never showed up
            if (checklist[i] == false) {
                System.out.print(i + " ");
            }
        }
    }
}