package Array;

public class SubbarrayWithGivenSum {
    public static void main(String[] args) {
        int n[]={1,2,3,4,5,6,7,8,9};
        int target = 15;
        int sum =0;
        int start =0;
        for (int i=0; i<n.length; i++){
            sum =sum+n[i];
            while (sum>target){
            sum = sum- n[start++];  
            }
            /* while (start<i){
                sum = sum- n[start++];
            } */
            if (sum==target){
                System.out.println("Sum found between indexes: " + start + " and " + i);
                return;
            }


        }
        System.out.println("No subarray found");

    }
    
}
