public class KeithNumber2 {
    public static void main(String[] args) {
        int n = 197;
        int temp=n;
        int count = 0;
        while (temp>0){// finding the count of the given n.
            count++;
            temp=temp/10;
        }
        System.out.println(count);
        int arr[]= new int[count]; // this creates an array based on count
        temp =n;
        for (int i=count-1; i>=0; i--){// storing values of n in array
            arr[i]=temp%10;
            temp=temp/10;
            System.out.println(arr[i]);
        }
        int sum =0;
        while (sum<n){
            sum=0;
            for(int i=0; i<count; i++){// adding the array values.
                sum = sum+ arr[i];
                System.out.println("'''"+sum);
            }
            for(int i = 0; i<count-1; i++){// pushing up the below array values.
                arr[i]= arr[i + 1];
                System.out.println("***"+arr[i]);
            }
            arr[count-1]=sum;// swapping the last position of array with sum value.
            System.out.println("..."+sum);

        }
        if (sum == n){
            System.out.println(n+" is a keith Number");
        }
        else{
            System.out.println(n+" is not a keith Number");
        }
    }
}
