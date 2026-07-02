const Account = require('./Account');

class Customer{
    static #idCounter = 10001;

    #name
    #customerId;
    #account;

    constructor(name){
        if (new.target === Customer) {
            throw new Error("Cannot instantiate an abstract class directly.");
        }

        this.#name = name;
        this.#customerId = customerId.#idCounter;
        customerId.idCounter++;

        this.#account = new Account (this.#customerId + 900000);

    }

    getName(){
        return this.#name;
    }

    getCustomerId(){
        return this.#customerId;
    }

    getAccount(){
        return this.#account;
    }
}

module.export = Customer;