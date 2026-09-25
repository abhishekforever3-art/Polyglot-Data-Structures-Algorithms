import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class ArrayToMapCreation {
    public void arrayToMapAddingEach(){
        Map<Integer, Integer> map = new HashMap<>();
        int[] a = new int[10];
        for (int i=0; i<a.length; i++){
            a[i]= (i + 1)*5;
            map.put(i, a[i]);
        }
        System.out.println("Adding Each element one by one to HashMap: " + map);
    }
    public void arrayToTreeMapUsingWrapper(){
        Integer[] a = {25, 5, 30, 10, 20, 15};
        Map<Integer, String> treeMap = new TreeMap<>();
        for (Integer num : a){
            treeMap.put(num,"Value_"+num);
        } 
        System.out.println("TreeMap from wrapper array (Sorted Keys): " + treeMap);
    }
    public void twoDArrayToMap() {
        String[][] keyValues = {
            {"101", "Apple"},
            {"102", "Banana"},
            {"103", "Cherry"}
        };

        Map<String, String> hashMap = new HashMap<>();
        for (String[] pair : keyValues) {
            hashMap.put(pair[0], pair[1]); 
        }

        System.out.println("HashMap from 2D Array: " + hashMap);
    }

    public static void main(String[] args) {
        ArrayToMapCreation collection = new ArrayToMapCreation();
        
        collection.arrayToMapAddingEach();
        collection.arrayToTreeMapUsingWrapper();
        collection.twoDArrayToMap();
    }
}
