from Vehicle import Vehicle

class Bike(Vehicle):
    
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
    print("=== Bike CONFIGURATOR ===")
    
    user_make = input("Enter Bike Brand/Make (e.g., TVS, KTM): ")
    user_model = int(input("Enter Model Year (e.g., 2026): "))
    user_colour = input("Enter Colour: ")
    user_max_speed = int(input("Enter Maximum Speed Limit (km/hr): "))
    
    bike_wheels = 2

    my_bike = Bike(user_make, user_model, user_colour, user_max_speed, bike_wheels)
    print(f"\n Custom {my_bike.make} Car configured successfully!")

    my_bike.start_engine()  
    my_bike.drive()        
    
    print("\n--- Pulling Over Safely ---")
    my_bike.brake(my_bike.current_speed) 
    my_bike.stop_engine()                