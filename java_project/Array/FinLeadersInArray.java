package Array;

import java.util.Arrays;

public class FinLeadersInArray {
    public static void main(String[] args) {
        int[] a = { 16, 17,5, 4, 2 };
        System.out.println("Original Array: " + Arrays.toString(a));


        int leads = a.length - 1;
        System.out.println("Ther current leader is : " );
        int maxFromRight = a[leads];
        System.out.print(maxFromRight+ " ");

        for (int i = leads-1 ; i>=0; i--){
            if ( a[i]> maxFromRight){
                System.out.print(a[i]+ "  ");

                maxFromRight = a[i];
            }
        }

    }
}
