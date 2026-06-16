package Arrays;

public class CountSpecificOccorances {
    public static void main(String[] args) {
        int a[]= new int[5];
        for (int i=0; i<a.length; i++){
            a[i]=1;
            System.out.print(a[i]+"\t");
        }
        System.out.println("original sequence");
        int k =1;
        int count =0;
        for (int i=0; i<a.length;i++){
            if (a[i]==k){
            count++;
        }
        }
        System.out.println("total count of "+k+" is "+count);
    }
}
