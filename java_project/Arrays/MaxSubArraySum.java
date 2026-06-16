package Arrays;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        
        int currentSum = arr[0];
        int maxSum = arr[0];

        
        for (int i = 1; i < arr.length; i++) {
            
           
            if (arr[i] > currentSum + arr[i]) {
                currentSum = arr[i]; 
            } else {
                currentSum = currentSum + arr[i]; 
            }

            
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        System.out.println("Maximum Contiguous Subarray Sum is: " + maxSum);
    }
}