package Array;

import java.util.Arrays;

public class ReverseArray {
   public static void main(String[] args) {
      
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Original Array: " + Arrays.toString(arr));

        
        int left = 0;
        int right = arr.length - 1;

       
        while (left < right) {
            
          
            int temp = arr[left];   
            arr[left] = arr[right]; 
            arr[right] = temp;      

            
            left++;
            right--;
        }

       
        System.out.println("Reversed Array: " + Arrays.toString(arr));
    }
}
