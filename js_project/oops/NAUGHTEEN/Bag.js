class Bag extends LeatherItems {
    // JavaScript implements static variables directly on the class
    static counter = 1;

    constructor(itemId, category, type, sizeOfBag) {
        // Call the parent (LeatherItems) constructor
        super(itemId, category, type);
        
        // Private/protected convention for instance variable
        this._sizeOfBag = sizeOfBag;
    }

    get sizeOfBag() {
        return this._sizeOfBag;
    }

    // Overriding validateType abstract method
    validateType() {
        if (this.type !== null && 
           (this.type.toLowerCase() === "formalbag" || this.type.toLowerCase() === "sportsbag")) {
            return true;
        }
        return false;
    }

    validateSizeOfBag() {
        if (this.type !== null && this.type.toLowerCase() === "formalbag") {
            if (this._sizeOfBag >= 15 && this._sizeOfBag <= 45) {
                return true;
            }
            return false;
        } else if (this.type !== null && this.type.toLowerCase() === "sportsbag") {
            return true;
        }
        return false;
    }

    // Overriding identifyCost abstract method
    identifyCost() {
        if (!this.validateSizeOfBag() || !this.validateType()) {
            console.log("Invalid Bag Type or Size.");
            return 0;
        }
        
        let cost = 0;

        if (this.type.toLowerCase() === "formalbag") {
            if (this._sizeOfBag >= 15 && this._sizeOfBag <= 30) {
                cost = 1.5;
            } else if (this._sizeOfBag >= 31 && this._sizeOfBag <= 45) {
                cost = 3.5;
            }
        } else if (this.type.toLowerCase() === "sportsbag") {
            if (this._sizeOfBag <= 17) {
                cost = 4.5;
            } else {
                cost = 9.5;
            }
        }

        return cost;
    }

    // Overriding calculateBillAmount abstract method
    calculateBillAmount() {
        if (!this.validateCategory()) {
            console.log("Invalid Category.");
            return 0;
        }

        const baseCostPounds = this.identifyCost();
        
        if (baseCostPounds <= 0) {
            console.log("Cost cannot be calculated.");
            return 0;
        }

        const costInRupees = baseCostPounds * 101.5;
        let taxPercentage = 0;

        if (this.category.toLowerCase() === "imported") {
            taxPercentage = 15;
        }
        
        const finalBill = costInRupees + (costInRupees * taxPercentage) / 100;

        // Generating billId and incrementing the static counter
        this._billId = this.itemId + Bag.counter;
        Bag.counter++;

        return finalBill;
    }
}