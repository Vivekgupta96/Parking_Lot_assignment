# Parking_Lot_assignment
## Parking System

This project is a simple implementation of a car parking system in Java. It supports multiple types of vehicles and a configurable cost strategy. The system provides functionalities to initialize the parking lot, add vehicles, remove vehicles, and check the availability of spaces.



## Tech Stack

- Language: Java
- Console base

## Getting Started

1. **Clone the repository:**

   git clone https://github.com/Vivekgupta96/Parking_Lot_assignment.git

   ## Functionality

The car parking system provides the following functionalities:

1. Initialize the parking lot:
   - The system allows initialization with a given number of floors and car spaces per floor.

2. Add vehicle details:
   - Users can add vehicle details to the parking lot, including the vehicle type (car, sports car, truck, bus), registration number, and color.

3. Remove a vehicle:
   - Vehicles can be removed from the parking lot based on either the registration number or the parking slot number.

4. Check availability:
   - Users can check the availability of vehicle spaces on a specific floor for a given vehicle type.

5. Cost strategy:
   - The system supports a configurable cost strategy for parking, with varying costs based on the vehicle type.

6. Use Case:
   - Initializing the Parking Lot for a specified number of cars.
   - Adding vehicle details with timestamp values, generating a token ID for each car.
   - Checking the validity of a token ID and timestamp to retrieve car details and calculate the total parking fee.
   - Handling full capacity scenarios, where attempting to enter a new car displays an error message.
