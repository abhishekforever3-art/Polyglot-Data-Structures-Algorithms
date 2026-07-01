function main() {
    const bag = new Bag("B101", "Imported", "FormalBag", 25);

    console.log(" --- Bag Billing ---");

    const bagBill = bag.calculateBillAmount();
    console.log("Bill ID: " + bag.billId);
    console.log("Bill Amount: " + bagBill);

    console.log("-------------------------------------");

    const shoe = new Shoe("S202", "Imported", "Flat", 5, "Nike");
    
    console.log("\n--- Shoe Billing ---");
    
    const shoeBill = shoe.calculateBillAmount();
    console.log("Bill ID: " + shoe.brand + shoe.itemId + "1");
    console.log("Final Bill Amount: " + shoeBill);
}

main();