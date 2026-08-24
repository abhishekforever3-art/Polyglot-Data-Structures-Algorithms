// public class Compute {
//     public static void main(String[] args) {
        
//     }
// }

// class Demo {
//     public void playmusic(){
//         System.out.println("Playing music...");
//     }
//     public String getMePen(int cost){
//         if (cost>= 10)
//         return "Pen";
//         else
//         return "No Pen";
//     }
// }
// public class Compute {
//     public static void main(String[] args) {
//         Demo d = new Demo();
//         d.playmusic();
//         String item = d.getMePen(2);
//         System.out.println("Item: " + item);
//     }

// }
//----------------------------------------------

//Method Overloading means having multiple methods in the same class with the same name but different parameters (different type or number of parameters). It is a way to achieve polymorphism in Java.

// class Demo{
// public int is the return type of the method, add is the name of the method, int a and int b are the parameters of the method
//     public int  add (int a, int b){ 
//         return a+b;
//     }
//     public int add(int a, int b, int c){  // we can overload the method by changing the number of parameters or changing the data type of parameters
//         return a+b+c;
//     }
//     public double add(double a, double b){   // we can overload the method by changing the number of parameters or changing the data type of parameters
//         return a+b;
//     }
// }
// public class Compute {
//     public static void main(String[] args) {
//         Demo d = new Demo();
//         int sum = d.add(10, 20);
//         System.out.println("Sum: " + sum);
//         int sum3 = d.add(10, 20, 30);
//         System.out.println("Sum3: " + sum3);
//         double sumDouble = d.add(10.5, 20.5);
//         System.out.println("SumDouble: " + sumDouble);
//     }
// }


// class Demo{
//     int num = 10; // instance variable
//     // instance variable is a variable that is declared inside a class but outside any method, constructor or block. It is also known as a member variable. It is created when an object of the class is created and destroyed when the object is destroyed. It can be accessed by all methods of the class.
//     // these are the part of heap memory and are created when an object is created and destroyed when the object is destroyed. They are used to store the state of an object. They can be accessed by all methods of the class.
//     public int add (int a, int b){
//         // int a and int b are local variables
//         // these are the part of the stack memory and are created when a method is called and destroyed when the method is exited. They are used to store temporary data. They can only be accessed within the method in which they are declared.
//         System.out.println("Instance variable: " + num); // accessing instance variable
//         return a+b;
//     }
// }

// public class Compute {
//     public static void main(String[] args) {

//         int data = 5; // local variable
//         System.out.println("Local variable: " + data); // accessing local variable
//         Demo d = new Demo();
//         int sum = d.add(10, 20);
//         System.out.println("Sum: " + sum);
//     }
// }

public class Compute{
    public static void main(String[] args) {
        int a = 15;
        int b = 3;
         if (a > b) {
            System.out.println("a is greater than b");
            printRange(b, a);
        } else if (b > a) {
            System.out.println("b is greater than a");
            printRange(a, b);
        } else {
            System.out.println("a and b are equal: " + a);
        }
    }
    
    public static void printRange(int low, int high) {
        for (int i = low; i <= high; i++) {
            System.out.println(i);
        }
    }
}