package Array;

public class AverageOfElements {
    public static void main(String[] args) {
        int a[] = new int[10];
        int highest = a[0];
        int lowest = a[0];
        int sum = 0;
        //int count = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = (i + 1);
            System.out.print(a[i] + "\t");
        }
        System.out.println("original sequence");
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            if (a[i] > highest) {
                highest = a[i];
            }
            if (a[i] < lowest) {
                lowest = a[i];
            }

        }
        int filteredSum = sum - highest - lowest;
        int average = filteredSum / a.length - 2;
        System.out.println(sum + " is total sum");
        System.out.println(highest + " is highest");
        System.out.println(lowest + " is lowest");
        System.out.println(filteredSum + " is filtered sum");
        System.out.println(average + " is average");
    }
}
