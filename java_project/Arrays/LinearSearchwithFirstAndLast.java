package Array;

public class LinearSearchwithFirstAndLast {
    public static void main(String[] args) {
        int a[]={3,4,5,6,7,5,4,3};
        int target =5;
        int firstIndex = -1;
        int lastIndex = -1;
        for (int i=0; i<a.length ; i++ ){
            if (a[i]==target){
                if (firstIndex == -1) {
                    firstIndex = i;
                }
                lastIndex=i;
            }
        }
        System.out.println(target+" is the target number");
        System.out.println(firstIndex);
        System.out.println(lastIndex);
    }
}
