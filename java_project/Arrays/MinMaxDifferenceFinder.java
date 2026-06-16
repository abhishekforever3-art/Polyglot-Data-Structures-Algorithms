package Arrays;

public class MinMaxDifferenceFinder {
    public static void main(String[] args) {
        float a[]= new float [5];
        for (int i=0; i<a.length; i++){
            a[i]= (float) ((i+1)*2.5);
            System.out.print(a[i]+"\t");
        }
        System.out.println("original array");
        float min= a[0];
        float max= a[0];

        for (int i=0; i<a.length; i++){
            if (a[i]<min){
                min = a[i];
            }
            if (a[i]>max){
                max=a[i];
            }
        }
        float difference = max-min;
        System.out.println(min+" is the min value");
        System.out.println(max+" is the max value");
        System.out.println(difference+" is the difference of max and min");
    }
}
