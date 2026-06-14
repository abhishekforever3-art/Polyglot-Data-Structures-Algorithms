package Array;

public class ArraySorting {
    public static void main(String[] args) {
        //int[] a = { 2, 5, 8, 12, 20 };
        int a[]=new int[5];
        for (int i = 0; i<a.length; i++){
            a[i]= (i+2)*5;
            System.out.print(a[i]+"\t");
        }
        System.out.println("original sequence");

        // Assume the array is sorted at the start
        boolean isSorted = true;

        // Loop to compare adjacent pairs safely
        for (int i = 0; i < a.length - 1; i++) {
            // Check if a current element is larger than its right neighbor
            if (a[i] > a[i + 1]) {
                isSorted = false; // Rule broken! It's not sorted.
                break; // Exit the loop immediately
            }
        }

        // Print the final evaluation result
        System.out.println("Is the array sorted? " + isSorted);
    }
}
