import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayToListCreation {

    public void arrayCreation() {
        int a[] = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = (i + 1) * 5;
            System.out.print(a[i] + "\t");
        }
    }
    public void listCreation(){

        List<Integer> list = new ArrayList<>();
        int a[] = new int[10];
        System.out.println("Array into list");
        for (int i = 0; i < a.length; i++) {
            a[i] = (i + 1) * 5;
            list.add(a[i]); // Auto-boxing converts int to Integer
            System.out.print(a[i] + "\t");
        }
    }
    public void wrapperArrayToList(){
        Integer[]a = new Integer[10];
        for(int i=0; i<a.length; i++){
            a[i] = (i+1) * 5;
        }
        List<Integer> list = new ArrayList<>(Arrays.asList(a));

        System.out.println("list with wrapper is "+ list);
    }


    public static void main(String[] args) {
        ArrayToListCreation collection = new ArrayToListCreation();
        collection.listCreation();
        collection.wrapperArrayToList();
    }
    
}
