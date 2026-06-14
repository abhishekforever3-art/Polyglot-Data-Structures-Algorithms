package Array;

import java.util.Arrays;

public class MoveAllZeors {
    public static void main(String[] args) {
        int a[]= {1,0,3,0,12,14,0};
        System.out.println("Original Array: " + Arrays.toString(a));
        int track = 0;
        for (int i=0; i<a.length; i++){
            if (a[i]!=0){
                int temp =  a[i];
                a[i]=a[track];
                a[track]= temp;
                track++;
                //System.out.println(temp);
            }
            //System.out.println("Modified Array: " + Arrays.toString(a));
            
        }
        System.out.println("Modified  Array: " + Arrays.toString(a));
    }
}
