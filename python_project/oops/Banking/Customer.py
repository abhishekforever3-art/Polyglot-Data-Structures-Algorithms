from abc import ABC
from Account import Account 

class Customer(ABC):  
    _id_counter = 10001

    def __init__(self, name: str):
        self.__name = name
        self.__customer_id = Customer._id_counter
        
        Customer._id_counter += 1
        
        self.__account = Account(self.__customer_id + 900000)

    def get_name(self) -> str:
        return self.__name

    def get_customer_id(self) -> int:
        return self.__customer_id

    def get_account(self) -> Account:
        return self.__account