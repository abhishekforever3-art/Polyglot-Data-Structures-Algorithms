class Vehicle{
    constructor(make,model,colour,maxSpeed,numOfWheels){
        if (this.constructor === Vehicle){
            throw new Error(" Error: Cannot instantiate abstract class Vehicle directly.");
        }
        this .make = make;
        //this .made = made;
        this .colour = colour;
        this .maxSpeed = maxSpeed;
        this . numOfWheels = numOfWheels;
        this.currentSpeed = 0;
        this.isEngineOn = false;
    }
    #internalDiagnosticCheck() {
        console.log (` Running internal systems diagnostic for ${this.make}...`);
        console.log (" Systems nominal. Safety checks passed.");
        return true;
    }
    startEngine(){
        if (!this.isEngineOn) {
            if (this.#internalDiagnosticCheck()) {
                this.isEngineOn = true;
                console.log(` ${this.make} engine started successfully.`);
            }
        } else {
            console.log(`${this.make} engine is already running.`);
        }
    }
    speedUp(increment){
        if(this.isEngineOn){
            this.currentSpeed += increment;
            this.currentSpeed = Math.min(this.currentSpeed, this.maxSpeed);
            console.log("{this.make} (${this.model}, ${this.colour}) sped up to ${this.currentSpeed} km/hr");
        }
        else{
            console.log("Error: Start the engine of the ${this.make} first!");
        }  
    }
    brake(decrement){
        if(this.isEngineOn){
            this.currentSpeed-= decrement;
            this.currentSpeed = Math.max(this.currentSpeed, 0);
            console.log("is.make} slowed down to ${this.currentSpeed} km/hr");

        }else {
            console.log(" Error: Cannot brake. The vehicle is turned off.");
        }   
    }
    stopEngine(){
        if (this.currentSpeed===0){
            this.isEngineOn = false;
            console.log("{this.make} engine turned off");
        }else {
            console.log(" Error: Cannot stop engine while moving! Bring speed to 0 km/hr first.");
        }
    }
    drive() {
        throw new Error(" Error: You must implement the 'drive()' method in your child class.");
    }
}
module.exports = Vehicle;