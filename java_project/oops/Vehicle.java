package oops;

public abstract class Vehicle {
    protected String make;
    protected int model;
    protected int currentSpeed;
    protected int maxSpeed; 
    protected String colour;
    protected boolean isEngineOn;
    protected int numOfWheels;

    public Vehicle(String make, int model, String colour, int maxSpeed, int numOfWheels) {
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.maxSpeed = maxSpeed;
        this.numOfWheels = numOfWheels;
        this.currentSpeed = 0;
        this.isEngineOn = false;
    }
    private boolean internalDiagnosticCheck() {
        System.out.println(" Running internal systems diagnostic for " + make + "...");
        System.out.println(" Systems nominal. Safety checks passed.");
        return true;
    }
    public void startEngine() {
        if (!isEngineOn) {
            if (internalDiagnosticCheck()) {
                isEngineOn = true;
                System.out.println(make + " engine started successfully.");
            }
        } else {
            System.out.println(make + " engine is already running.");
        }
    }
    public void speedUp(int increment) {
        if (isEngineOn) {
            currentSpeed += increment;
            if (currentSpeed > maxSpeed) {
                currentSpeed = maxSpeed;
                System.out.println(" WARNING: Reached max speed limit of " + maxSpeed + " km/hr!");
            }
            System.out.println(make + " (" + model + ", " + colour + ") sped up to " + currentSpeed + " km/hr");
        } else {
            System.out.println(" Error: Start the engine of the " + make + " first!");
        }
    }
    public void brake(int decrement) {
        if (isEngineOn) {
            currentSpeed -= decrement;
            if (currentSpeed < 0) {
                currentSpeed = 0;
            }
            System.out.println( make + " slowed down to " + currentSpeed + " km/hr");
        } else {
            System.out.println("Error: Cannot brake. The vehicle is turned off.");
        }
    }
    public void stopEngine() {
        if (currentSpeed == 0) {
            isEngineOn = false;
            System.out.println( make + " engine turned off.");
        } else {
            System.out.println(" Error: Cannot stop engine while moving! Bring speed to 0 km/hr first.");
        }
    }

    public abstract void drive(java.util.Scanner scanner);

    public static void main(String[] args) {
    String testMake = "BMW";
    int testModel = 2026;
    String testColour = "Red";
    int testMaxSpeed = 200;
    int testWheels = 4;

    Vehicle v1 = new Car(testMake, testModel, testColour, testMaxSpeed, testWheels);

    java.util.Scanner scanner = new java.util.Scanner(System.in);
    v1.startEngine();
    v1.drive(scanner);
    v1.brake(v1.currentSpeed);
    v1.stopEngine();
    
    System.out.println();
    
    String tesMake = "KTM";
    int tesModel = 2026;
    String tesColour = "Red";
    int tesMaxSpeed = 100;
    int tesWheels = 2;

    Vehicle v2 = new Bike(tesMake, tesModel, tesColour, tesMaxSpeed, tesWheels);

    java.util.Scanner scanner1 = new java.util.Scanner(System.in);
    v2.startEngine();
    v2.drive(scanner1);
    v2.brake(v1.currentSpeed);
    v2.stopEngine();
    scanner1.close();
}  

    
}

