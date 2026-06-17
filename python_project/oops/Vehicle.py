from abc import ABC, abstractmethod

class Vehicle(ABC):
    def __init__(self, make: str, model: int, colour: str, max_speed: int, num_of_wheels: int):
        self.make = make
        self.model = model
        self.colour = colour
        self.max_speed = max_speed
        self.num_of_wheels = num_of_wheels
        self.current_speed = 0
        self.is_engine_on = False

    def __internal_diagnostic_check(self) -> bool:
        print(f" Running internal systems diagnostic for {self.make}...")
        print(" Systems nominal. Safety checks passed.")
        return True

    def start_engine(self):
        if not self.is_engine_on:
            if self.__internal_diagnostic_check():
                self.is_engine_on = True
                print(f" {self.make} engine started successfully.")
        else:
            print(f"{self.make} engine is already running.")

    def speed_up(self, increment: int):
        if self.is_engine_on:
            self.current_speed += increment
            if self.current_speed > self.max_speed:
                self.current_speed = self.max_speed
                print(f" WARNING: Reached max speed limit of {self.max_speed} km/hr!")
            print(f" {self.make} ({self.model}, {self.colour}) sped up to {self.current_speed} km/hr")
        else:
            print(f" Error: Start the engine of the {self.make} first!")

    def brake(self, decrement: int):
        if self.is_engine_on:
            self.current_speed -= decrement
            if self.current_speed < 0:
                self.current_speed = 0
            print(f" {self.make} slowed down to {self.current_speed} km/hr")
        else:
            print("Error: Cannot brake. The vehicle is turned off.")

    def stop_engine(self):
        if self.current_speed == 0:
            self.is_engine_on = False
            print(f" {self.make} engine turned off.")
        else:
            print("❌ Error: Cannot stop engine while moving! Bring speed to 0 km/hr first.")

    @abstractmethod
    def drive(self):
        pass