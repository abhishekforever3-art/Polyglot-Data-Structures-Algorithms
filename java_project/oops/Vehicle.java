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
    
}

