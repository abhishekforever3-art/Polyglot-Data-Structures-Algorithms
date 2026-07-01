""" from oops.NAUGHTEEN.bag import Bag
from oops.NAUGHTEEN.shoe import Shoe

def main():

    my_bag = Bag("B101", "Imported", "FormalBag", 25)
    print("--- Bag Billing ---")
    bill_amount = my_bag.calculate_bill_amount()
    
    if bill_amount > 0:
        print("Bill ID:", my_bag.bill_id)
        print("Final Bill Amount: {:.2f}".format(bill_amount))
    else:
        print("Error: Could not calculate Bag bill.")
        
    my_shoe = Shoe("S202", "Imported", "Flat", 5, "Nike")
    
    print("\n--- Shoe Billing ---")
    bill_amount_shoe = my_shoe.calculate_bill_amount()
    
    if bill_amount_shoe > 0:
        print("Bill ID:", my_shoe.bill_id)
        print("Final Bill Amount: {:.2f}".format(bill_amount_shoe))
    else:
        print("Error: Could not calculate Shoe bill.")
    
    if __name__ == "__main__":
        main() """