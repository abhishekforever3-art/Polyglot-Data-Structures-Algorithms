from Vehicle import Vehicle

class Car(Vehicle):
    
    def __init__(self, make: str, model: int, colour: str, max_speed: int, num_of_wheels: int):
        super().__init__(make, model, colour, max_speed, num_of_wheels)

    def drive(self):
        print(f"\n---  Putting the {self.make} into Drive ---")
        
        try:
            speed_input = int(input("Step on the gas! Enter acceleration speed (km/hr): "))
            self.speed_up(speed_input)
        except ValueError:
            print(" Invalid input! Please enter a whole number for speed.")


if __name__ == "__main__":
    print("=== CAR CONFIGURATOR ===")
    
    user_make = input("Enter Car Brand/Make (e.g., BMW, Audi): ")
    user_model = int(input("Enter Model Year (e.g., 2026): "))
    user_colour = input("Enter Colour: ")
    user_max_speed = int(input("Enter Maximum Speed Limit (km/hr): "))
    
    car_wheels = 4

    my_car = Car(user_make, user_model, user_colour, user_max_speed, car_wheels)
    print(f"\n Custom {my_car.make} Car configured successfully!")

    my_car.start_engine()  
    my_car.drive()        
    
    print("\n--- Pulling Over Safely ---")
    my_car.brake(my_car.current_speed) 
    my_car.stop_engine()                