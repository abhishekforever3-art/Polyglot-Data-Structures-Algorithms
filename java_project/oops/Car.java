package oops;

import java.util.Scanner;

public class Car extends Vehicle {

    public Car(String make, int model, String colour, int maxSpeed, int numOfWheels){
        super (make, model, colour, maxSpeed, numOfWheels);
    }
    public void drive(Scanner scanner) {
        System.out.println(" Putting the " + make + " into Drive ---");
        System.out.print("Step on the gas! Enter acceleration speed (km/hr): ");
        int speedInput = scanner.nextInt();
        
       speedUp(speedInput);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== BIKE REGISTRATION ===");
        System.out.print("Enter Bike Brand/Make (e.g., BMW, Honda): ");
        String make = scanner.nextLine();

        System.out.print("Enter Model Year: ");
        int model = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Colour: ");
        String colour = scanner.nextLine();

        System.out.print("Enter Max Speed Limit: ");
        int maxSpeed = scanner.nextInt();

        int wheels = 4; 

        Bike myBike = new Bike(make, model, colour, maxSpeed, wheels);
        System.out.println( make + " Bike setup complete!");

        myBike.startEngine(); 
        
        myBike.drive(scanner); 
        
        System.out.println("\n--- Pulling Over ---");
        myBike.brake(myBike.currentSpeed); 
        myBike.stopEngine();               

        scanner.close();
    }
    
}
