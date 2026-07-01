from Customer import Customer 

class PersonalCustomer(Customer): 
    def __init__(self, name: str):
        super().__init__(name)  
        self.__address = None
        self.__home_phone = None
        self.__work_phone = None

    def get_address(self) -> str:
        return self.__address

    def set_address(self, address: str) -> None:
        self.__address = address

    def get_home_phone(self) -> str:
        return self.__home_phone    

    def set_home_phone(self, home_phone: str) -> None:
        self.__home_phone = home_phone

    def get_work_phone(self) -> str:
        return self.__work_phone

    def set_work_phone(self, work_phone: str) -> None:
        self.__work_phone = work_phone