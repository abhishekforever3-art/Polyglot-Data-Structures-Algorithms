from LeatherItems import LeatherItem

class Shoe  (LeatherItem):
    counter = 1
    
    def __init__(self, item_id, category, item_type, size_of_shoe, brand):
        super().__init__(item_id, category, item_type)
        self.size_of_shoe = size_of_shoe
        self.brand = brand
        
    def validate_type(self):
        return self.item_type.lower() in ["flat", "heels", "stilettos", "wedge"]
    
    def validate_brand(self):
        return self.brand.lower() in ["reebok", "nike", "adidas"]
    
    def identify_discount_percentage(self):
        discount = {"reebok": 10.0, "nike": 25.0, "adidas": 40.0}
        return discount.get(self.brand.lower(), 0.0)
    
    def identify_cost(self):
        if not (4 <= self.size_of_shoe <= 12) or not self.validate_type:
            print ("Invalid Shoe Type or Size.")
            return
        if 4 <= self.size_of_shoe <= 7:
            return 7.0 if self.item_type.lower() == "flat" else 8.0
        else:
            return 9.0 if self.item_type.lower() == "stilettos" else 10.0
        
    def calculate_bill_amount(self):
        if not self.validate_category():
            print("Invalid Category.")
            return 0.0
        
        base_cost = self.identify_cost()
        if base_cost <= 0:
            return 0.0
        
        cost_in_rupees = base_cost * 61.04
        
        discount = self.identify_discount_percentage()
        
        cost_in_rupees = cost_in_rupees-(cost_in_rupees * (discount/100))
        
        tax = 0.20 if self.category.lower() == "imported" else 0.0
        
        combined_info = self.brand + self.item_id
        
        counter_as_text = str(Shoe.counter)
        
        self.bill_id = combined_info + counter_as_text
        
        Shoe.counter = Shoe.counter + 1
        
        return cost_in_rupees * (1 + tax)