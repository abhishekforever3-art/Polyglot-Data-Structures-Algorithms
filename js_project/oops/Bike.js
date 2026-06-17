const Vehicle = require('./Vehicle');

class Bike extends Vehicle {
    constructor(make, model, colour, maxSpeed, numOfWheels) {
        super(make, model, colour, maxSpeed, numOfWheels);
    }

    drive(speedInput) {
        console.log("\n---  Putting the ${this.make} into Drive ---");
        this.speedUp(speedInput);
    }
}

if (require.main === module) {
    const myBike = new Bike("tvs", 2026, "Red", 200, 2);
    console.log( "Custom ${myBike.make} Car initialized!");

    myBike.startEngine();
    
    myBike.drive(80); 
    
    console.log("\n--- Pulling Over Safely ---");
    myBike.brake(myBike.currentSpeed);
    myBike.stopEngine();
}