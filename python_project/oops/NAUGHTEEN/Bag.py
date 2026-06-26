from LeatherItems import LeatherItem

class Bag(LeatherItem):
    counter = 1

    def __init__(self, item_id, category, item_type, size_of_bag):
        super().__init__(item_id, category, item_type)
        self.size_of_bag = size_of_bag

    def validate_type(self):
        return self.item_type.lower() in ["formalbag", "sportsbag"]

    def validate_size_of_bag(self):
        if self.item_type.lower() == "formalbag":
            return 15 <= self.size_of_bag <= 45
        elif self.item_type.lower() == "sportsbag":
            return True
        return False

    def identify_cost(self):
        if not self.validate_type() or not self.validate_size_of_bag():
            print("Invalid Bag Type or Size.")
            return 0.0
        
        if self.item_type.lower() == "formalbag":
            return 1.5 if 15 <= self.size_of_bag <= 30 else 3.5
        else:
            return 4.5 if self.size_of_bag <= 17 else 9.5

    def calculate_bill_amount(self):
        if not self.validate_category():
            print("Invalid Category.")
            return 0.0
        
        base_cost = self.identify_cost()
        if base_cost <= 0:
            return 0.0
            
        cost_in_rupees = base_cost * 101.5
        tax = 0.15 if self.category.lower() == "imported" else 0.0
        
        self.bill_id = f"{self.item_id}{Bag.counter}"
        Bag.counter += 1
        
        return cost_in_rupees * (1 + tax)