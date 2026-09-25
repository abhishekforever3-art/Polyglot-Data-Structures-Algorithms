import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class Collection {

    public void listElements() {
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5));
        System.out.println("List elements: " + list);
    }
    public void linkedListElements() {
        List<String> linkedList = new ArrayList<>(List.of("A", "B", "C", "D"));
        System.out.println("LinkedList elements: " + linkedList);
    }

    public void setElements() {
        Set<String> set = Set.of("A", "B", "C", "D");
        System.out.println("Set elements: " + set);
    }
    public void hashSetElements() {
        Set<Integer> hashSet = Set.of(1, 2, 3, 4, 5);
        System.out.println("HashSet elements: " + hashSet);
    }
    public void linkedHashSetElements() {
        Set<String> linkedHashSet = Set.of("A", "B", "C", "D");
        System.out.println("LinkedHashSet elements: " + linkedHashSet);
    }
    public void treeSetElements() {
        Set<String> treeSet = Set.of("X", "Y", "Z");
        System.out.println("TreeSet elements: " + treeSet);
    }

    public void mapElements() {
        Map<Integer, String> map = Map.of(1, "One", 2, "Two", 3, "Three");
        System.out.println("Map elements: " + map);
    }

    public void hashMapElements() {
        Map<String, Integer> hashMap = Map.of("A", 1, "B", 2, "C", 3);
        System.out.println("HashMap elements: " + hashMap);
    }

    public void linkedHashMapElements() {
        Map<String, Integer> linkedHashMap = Map.of("X", 10, "Y", 20, "Z", 30);
        System.out.println("LinkedHashMap elements: " + linkedHashMap);
    }
    public void treeMapElements() {
        Map<Integer, String> treeMap = Map.of(1, "One", 2, "Two", 3, "Three");
        System.out.println("TreeMap elements: " + treeMap);
    }

    public void iterateElements() {
        List<String> list = new ArrayList<>(List.of("Apple", "Banana", "Cherry"));
        System.out.println("Iterating over list elements:");
        for (String element : list) {
            System.out.println(element);
        }
    }
    public void iterateSetElements() {
        Set<String> set = Set.of("X", "Y", "Z");
        System.out.println("Iterating over set elements:");
        for (String element : set) {
            System.out.println(element);
        }
    }
    public void iterateMapElements() {
        Map<Integer, String> map = Map.of(1, "One", 2, "Two", 3, "Three");
        System.out.println("Iterating over map elements:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Collection collection = new Collection();
        collection.listElements();
        collection.linkedListElements();
        collection.setElements();
        collection.hashSetElements();
        collection.linkedHashSetElements();
        collection.treeSetElements();
        collection.mapElements();
        collection.hashMapElements();
        collection.linkedHashMapElements();
        collection.treeMapElements();
        collection.iterateElements();
        collection.iterateSetElements();
        collection.iterateMapElements();
        System.out.println("Collection elements are listed successfully.");

    }
}