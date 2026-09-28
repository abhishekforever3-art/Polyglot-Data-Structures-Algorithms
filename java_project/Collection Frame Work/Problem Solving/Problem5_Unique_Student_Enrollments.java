import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Objects;

class Student {
    private int id;
    private String name;

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }
    public int getId(){
        return id;
    }
    public String getnName(){
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() { 
        return Objects.hash(id, name);
    }
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

public class Problem5_Unique_Student_Enrollments {
    public static void main(String[] args) {
        Set<Student> uniqueStudents = new HashSet<>();
        Student s1 = new Student(101, "Alice");
        Student s2 = new Student(102, "Bob");
        Student s3 = new Student(101, "Alice");

        System.out.println("Adding s1 (Alice)... " + uniqueStudents.add(s1));
        System.out.println("Adding s2 (Bob)... " + uniqueStudents.add(s2));
        System.out.println("Adding s3 (Duplicate Alice)... " + uniqueStudents.add(s3));

        System.out.println("\nTotal Unique Students in Set: " + uniqueStudents.size());
        System.out.println("--- Student Roster ---");

        for (Object obj : uniqueStudents) {
            Student s = (Student) obj; 
            System.out.println(s);
        }
    }
}
