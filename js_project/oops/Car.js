const Vehicle = require('./Vehicle');

class Car extends Vehicle {
    constructor(make, model, colour, maxSpeed, numOfWheels) {
        super(make, model, colour, maxSpeed, numOfWheels);
    }

    drive(speedInput) {
        console.log("\n---  Putting the ${this.make} into Drive ---");
        this.speedUp(speedInput);
    }
}

if (require.main === module) {
    const myCar = new Car("BMW", 2026, "Red", 200, 4);
    console.log( "Custom ${myCar.make} Car initialized!");

    myCar.startEngine();
    
    myCar.drive(80); 
    
    console.log("\n--- Pulling Over Safely ---");
    myCar.brake(myCar.currentSpeed);
    myCar.stopEngine();
}