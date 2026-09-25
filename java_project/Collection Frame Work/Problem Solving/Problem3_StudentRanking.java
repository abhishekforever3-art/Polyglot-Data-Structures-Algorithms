import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | GPA: " + gpa;
    }
}

public class Problem3_StudentRanking {
    public static void main(String[] args) {
        // Raw ArrayList without generics
        List students = new ArrayList();
        
        students.add(new Student(101, "Charlie", 3.8));
        students.add(new Student(102, "Alice", 3.8));
        students.add(new Student(103, "Bob", 3.5));
        students.add(new Student(104, "Diana", 4.0));

        System.out.println("--- Unsorted Students ---");
        for (Object obj : students) {
            Student s = (Student) obj; // Typecasting Object -> Student
            System.out.println(s);
        }

        // Custom Comparator using raw Object arguments and explicit casts
        Comparator gpaAndNameComparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // Step 1: Explicit typecasts
                Student s1 = (Student) o1;
                Student s2 = (Student) o2;

                // Step 2: Compare GPAs in DESCENDING order (higher GPA first)
                if (s2.getGpa() != s1.getGpa()) {
                    return Double.compare(s2.getGpa(), s1.getGpa());
                }

                // Step 3: If GPAs are equal, compare Names in ASCENDING order (alphabetical)
                return s1.getName().compareTo(s2.getName());
            }
        };

        // Sort using Collections.sort
        Collections.sort(students, gpaAndNameComparator);

        System.out.println("\n--- Ranked Students (Sorted by GPA desc, then Name asc) ---");
        for (Object obj : students) {
            Student s = (Student) obj; // Typecasting Object -> Student
            System.out.println(s);
        }
    }
}