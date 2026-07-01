from Customer import Customer 

class CommercialCustomer(Customer):
    def __init__(self, name: str):
        super().__init__(name)  
        self.__address = None
        self.__contact_person = None
        self.__contact_person_phone = None

    def get_address(self) -> str:
        return self.__address

    def set_address(self, address: str) -> None:
        self.__address = address

    def get_contact_person(self) -> str:
        return self.__contact_person

    def set_contact_person(self, contact_person: str) -> None:
        self.__contact_person = contact_person

    def get_contact_person_phone(self) -> str:
        return self.__contact_person_phone

    def set_contact_person_phone(self, contact_person_phone: str) -> None:
        self.__contact_person_phone = contact_person_phone