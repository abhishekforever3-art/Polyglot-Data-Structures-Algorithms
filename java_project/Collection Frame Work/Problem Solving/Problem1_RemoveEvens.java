import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Problem1_RemoveEvens {
    public void evenNumbersRemoval() {
        Integer[] inputArrays = {12, 7, 19, 42, 5, 88, 23, 14, 91, 30};

        List numbers = new ArrayList<>(Arrays.asList(inputArrays));
        System.out.println("Original List: " + numbers);

        Iterator iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer current = (Integer)iterator.next(); 
            if (current % 2 == 0) {
                iterator.remove(); 
            } 
        }
        System.out.println("Filtered List: " + numbers);
    }    

    public static void main(String[] args) {
        Problem1_RemoveEvens collection = new Problem1_RemoveEvens();
        collection.evenNumbersRemoval();
    }
}