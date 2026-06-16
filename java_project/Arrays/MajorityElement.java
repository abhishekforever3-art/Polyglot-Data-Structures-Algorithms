package Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int a[] = { 1, 2, 2, 2, 2, 2, 2, 2, 2, 4, 5, 6 };
        int candidate = 0;
        int count = 0;
        int temp = count;
        for (int i = 0; i < a.length; i++) {
            if (count == 0) {
                candidate = a[i];

            }
            if (a[i] == candidate) {
                count++;

            } else {
                count--;
            }

        }
        System.out.println(count + "-----");
        System.out.println(candidate + "*********");

        for (int i = 0; i < a.length; i++) {
            if (a[i] == candidate) {
                temp++;
            }
        }
        if (temp > a.length / 2) {
            System.out.println("Majority Element: " + candidate);
        } else {
            System.out.println("-1");
        }

    }
}
