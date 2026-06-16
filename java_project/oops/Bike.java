package oops;

import java.util.Scanner;

public class Bike extends Vehicle {

    public Bike(String make, int model, String colour, int maxSpeed, int numOfWheels) {
        super(make, model, colour, maxSpeed, numOfWheels);
    }

    /* // Overriding the abstract drive method from the Vehicle class
    //@Override */
    public void drive(Scanner scanner) {
        if (!isEngineOn) {
            System.out.println(" Cannot drive! Start the " + make + "'s engine first.");
            return;
        }

        System.out.println("\n---Let's Ride the " + make + " ---");
        System.out.print("How much do you want to accelerate? Enter speed (km/hr): ");
        int speedInput = scanner.nextInt();
        
        speedUp(speedInput);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== BIKE REGISTRATION ===");
        System.out.print("Enter Bike Brand/Make (e.g., TVS, Yamaha): ");
        String make = scanner.nextLine();

        System.out.print("Enter Model Year: ");
        int model = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Colour: ");
        String colour = scanner.nextLine();

        System.out.print("Enter Max Speed Limit: ");
        int maxSpeed = scanner.nextInt();

        int wheels = 2; 

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