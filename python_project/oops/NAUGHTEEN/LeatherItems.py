from abc import ABC, abstractmethod


class LeatherIteams(ABC):
    def __init__(self, item_id, category,item_type):
        self. item_id = item_id
        self. category = category
        self.item_type = item_type
        self.bill_id = None

    def validate_category(self):
        return self.category.lower()in ["imported", "manufactured"]
        
    @abstractmethod
    def validate_type(self):
        pass
    @abstractmethod
    def identify_cost(self):
        pass
    @abstractmethod
    def calculate_bill_amount(self):
        pass
        