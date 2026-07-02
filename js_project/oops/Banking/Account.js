class Account{
    #accountNumber;
    #balance;
    #dateOpened;
    constructor(accountNumber){
        this.#accountNumber = accountNumber;
        this.#balance= 0.0;
        this.#dateOpened = new Date();

    }
    getAccountNumber(){
        return this.#accountNumber;
    }

    getBalance(){
        return this.#balance;
    }

    getDateOpened(){
        return this.#dateOpened;
    }

    deposit(amount){
        if(amount>0){
            this.#balance += amount;
        }
    }

    withDraw(amount){
        if (amount>0 && amount<=this.#balance){
            this.#balance -= amount;
        }
    }

}

module.exports = Account;