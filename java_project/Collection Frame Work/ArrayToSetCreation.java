import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayToSetCreation {
    public void arrayToSetAddingEach(){
        Set<Integer> set = new HashSet<>();
        int a[] = new int[10];
        for(int i=0; i<a.length; i++){
            a[i] = (i + 1)* 5;
            set.add(a[i]);
        }
        System.out.println("Adding Each element one by one :"+ set+ "\t");
    }
    public void arrayToSetUsingWrapper(){
        Integer[] a = {5, 10, 15, 20, 25, 30};
        // Option A: Mutable HashSet (ignores duplicates automatically)
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(a));
        System.out.println("HashSet from wrapper array: " + hashSet);

        // Option B: Immutable Set (Java 9+)
        // Note: Set.of() throws IllegalArgumentException if duplicates exist in array
        // Use Set.copyOf(Arrays.asList(numbers)) if duplicates are present
        Set<Integer> immutableSet = Set.copyOf(Arrays.asList(a));
        System.out.println("Immutable Set: " + immutableSet);

    }
    public static void main(String[] args) {
        ArrayToSetCreation collection = new ArrayToSetCreation();
        collection.arrayToSetAddingEach();
        collection.arrayToSetUsingWrapper();
    }
}
