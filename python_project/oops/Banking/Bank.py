# Assuming the customer and customer type classes are imported properly
from Customer import Customer
from PersonalCustomer import PersonalCustomer
from CommercialCustomer import CommercialCustomer

class Bank:
    def __init__(self):
        self.__customers = []

    def create_personal_customer(self, name: str, address: str, home_phone: str, work_phone: str) -> int:
        pc = PersonalCustomer(name)
        pc.set_address(address)
        pc.set_home_phone(home_phone)
        pc.set_work_phone(work_phone)
        
        self.__customers.append(pc) 
        return pc.get_customer_id()

    def create_commercial_customer(self, name: str, address: str, contact_person_name: str, contact_person_phone: str) -> int:
        cc = CommercialCustomer(name)
        cc.set_address(address)
        cc.set_contact_person(contact_person_name)
        cc.set_contact_person_phone(contact_person_phone)
        
        self.__customers.append(cc)
        return cc.get_customer_id()

    def get_customer(self, customer_id: int) -> Customer:
        for c in self.__customers:
            if c.get_customer_id() == customer_id:
                return c
        return None  

    def deposit(self, customer_id: int, amount: float) -> bool:
        c = self.get_customer(customer_id)
        if c is None or amount <= 0:
            return False
        
        c.get_account().deposit(amount)
        return True

    def withdraw(self, customer_id: int, amount: float) -> int:
        c = self.get_customer(customer_id)
        if c is None:
            return 0
        if amount <= 0:
            return -1
        if c.get_account().get_balance() < amount:
            return -2
            
        c.get_account().withdraw(amount)
        return 1

    def total_value(self) -> float:
        total_sum = 0.0
        for c in self.__customers:
            total_sum += c.get_account().get_balance()
        return total_sum