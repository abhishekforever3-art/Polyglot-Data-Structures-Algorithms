package Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        //int n[]= {1,2,3,4,4,5,6,7,7,8,9,10};
        /* if (n.length == 0) {
            System.out.println("Unique length: 0");
            return;
        }
        int temp =0;
        for (int i=1; i<n.length; i++){
            if (n[i]!=n[temp]){
                temp = temp+1;
                n[temp]=n[i];
            }
            System.out.print(n[temp]);
        }
        System.out.println();
        int length = temp+1;
        System.out.println(length+ " length");
        System.out.print("Modified Array: ");
        for (int i = 0; i < length; i++) {
            System.out.print(n[i] + " ");
        } */

        int a[] = {1,1,3,4,4,5,6,7,7,8,9,10,11,12,84};

        int i = 0;
        for (int j = 1; j < a.length; j++) {
            if (a[i] != a[j]) {
                i++;

                a[i] = a[j];
            }
        }
        System.out.println("Array after removing duplicates:");

        for (int k = 0; k <= i; k++) {
            System.out.print(a[k] + " ");
        }
    }

}
    

