class Shoe extends LeatherItems {
    // Static counter property unique to the Shoe class
    static counter = 1;

    constructor(itemId, category, type, sizeOfShoe, brand) {
        super(itemId, category, type);
        this._sizeOfShoe = sizeOfShoe;
        this._brand = brand;
    }

    get sizeOfShoe() {
        return this._sizeOfShoe;
    }

    get brand() {
        return this._brand;
    }

    validateSizeOfShoe() {
        if (this._sizeOfShoe >= 4 && this._sizeOfShoe <= 12) {
            return true;
        }
        return false;
    }

    validateBrand() {
        if (this.type !== null && 
           (this.type.toLowerCase() === "flat" || 
            this.type.toLowerCase() === "heels" || 
            this.type.toLowerCase() === "stilettos" || 
            this.type.toLowerCase() === "wedge")) {
            return true;
        }
        return false;
    }

    // Overriding validateType abstract method
    validateType() {
        if (this.type !== null && 
           (this.type.toLowerCase() === "flat" || 
            this.type.toLowerCase() === "heels" || 
            this.type.toLowerCase() === "stilettos" || 
            this.type.toLowerCase() === "wedge")) {
            return true;
        }
        return false;
    }

    identifyDiscountPercentage() {
        if (!this.validateBrand()) {
            console.log("Invalid Brand.");
            return 0;
        }
        
        let discount = 0;
        const currentBrand = this._brand ? this._brand.toLowerCase() : "";
        
        if (currentBrand === "reebok") {
            discount = 10.0;
        } else if (currentBrand === "nike") {
            discount = 25.0;
        } else if (currentBrand === "adidas") {
            discount = 40.0;
        }
        return discount;
    }

    identifyCost() {
        if (!this.validateSizeOfShoe() && this.validateType()) {
            console.log("Invalid Shoe Type or Size.");
            return 0;
        }
        
        let cost = 0;
        const currentType = this.type ? this.type.toLowerCase() : "";

        if (this._sizeOfShoe >= 4 && this._sizeOfShoe <= 7) {
            if (currentType === "flat") cost = 7.0;
            else if (currentType === "heels") cost = 8.0;
        } else if (this._sizeOfShoe >= 8 && this._sizeOfShoe <= 12) {
            if (currentType === "stilettos") cost = 9.0;
            else if (currentType === "wedge") cost = 10.0;
        }
        
        return cost;
    }

    calculateBillAmount() {
        if (!this.validateCategory()) {
            console.log("Invalid Category.");
            return 0;
        }
        
        const baseCostDollars = this.identifyCost();
        if (baseCostDollars <= 0) {
            console.log("Cost cannot be calculated.");
            return 0;
        }
        
        let costInRupees = baseCostDollars * 61.04;
        const discountPercent = this.identifyDiscountPercentage();
        costInRupees = costInRupees - (costInRupees * discountPercent / 100);
        
        let taxPercent = 0;
        if (this.category && this.category.toLowerCase() === "imported") {
            taxPercent = 20.0;
        }
        
        const finalBill = costInRupees + (costInRupees * taxPercent / 100);
        
        this._billId = this._brand + this.itemId + Shoe.counter;
        Shoe.counter++;

        return finalBill;
    }
}