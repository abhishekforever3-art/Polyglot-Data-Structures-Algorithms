from datetime import datetime

class Account:
    def __init__(self, account_number: int):
        self.__account_number = account_number
        self.__balance = 0.0
        self.__date_opened = datetime.now()

    def get_account_number(self) -> int:
        return self.__account_number
    
    def get_balance(self) -> float:
        return self.__balance

    def get_date_opened(self) -> datetime:
        return self.__date_opened

    def deposit(self, amount: float) -> None:
        if amount > 0:
            self.__balance += amount

    def withdraw(self, amount: float) -> None:
        if amount > 0 and amount <= self.__balance:
            self.__balance -= amount