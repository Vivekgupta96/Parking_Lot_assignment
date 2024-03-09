import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ParkingLot implements ParkingInterface{
	   
	private int totalNumberFloors;
    private int capacityPerVehicleType;
    private List<Floor> floors;
    private CostStrategy costStrategy;
    private Map<String, Token> vehicleTokens;

    public ParkingLot(int totalFloors, int capacityPerVehicleType) {
        this.totalNumberFloors = totalFloors;
        this.capacityPerVehicleType = capacityPerVehicleType;
        this.floors = new ArrayList<>();
        this.costStrategy = new CostStrategy();
        initializeFloors();
    }

    private void initializeFloors() {
        for (int i = 1; i <= totalNumberFloors; i++) {
            floors.add(new Floor(i, capacityPerVehicleType));
        }
    }
    
    public void init(int totalFloors, int capacityPerVehicleType) {
        this.totalNumberFloors = totalFloors;
        this.capacityPerVehicleType = capacityPerVehicleType;
        this.floors = new ArrayList<>();
        this.vehicleTokens = new HashMap<>();
        initializeFloors();
    }

    public boolean addVehicle(String vehicleType, String registrationNumber, String color) {
        Vehicle vehicle = new Vehicle(vehicleType, registrationNumber, color);

        for (Floor floor : floors) {
            if (floor.isSpaceAvailable(vehicleType)) {
                VehicleSpace parkingSpace = floor.parkVehicle(vehicleType, vehicle);
                if (parkingSpace != null) {
                    System.out.println("Vehicle parked successfully. Space Number: " + parkingSpace.getSpaceNumber());
                    return true;
                }
            }
        }

        System.out.println("Parking lot is full for " + vehicleType + ". Unable to park the vehicle.");
        return false;
    }

    public Vehicle removeVehicle(String registrationNumber) {
        for (Floor floor : floors) {
            for (Map.Entry<String, List<VehicleSpace>> entry : floor.getVehicleSpaces().entrySet()) {
                for (VehicleSpace space : entry.getValue()) {
                    if (!space.isAvailability() && space.removeVehicle().getRegistrationNumber().equals(registrationNumber)) {
                        System.out.println("Vehicle removed successfully from Space Number: " + space.getSpaceNumber());
                        return space.removeVehicle();
                    }
                }
            }
        }

        System.out.println("Vehicle with registration number " + registrationNumber + " not found in the parking lot.");
        return null;
    }

    public boolean checkAvailability(int floorNumber, String vehicleType) {
        if (floorNumber < 1 || floorNumber > totalNumberFloors) {
            System.out.println("Invalid floor number.");
            return false;
        }

        Floor floor = floors.get(floorNumber - 1);
        return floor.isSpaceAvailable(vehicleType);
   }

	@Override
	public String toString() {
		return "ParkingLot [totalNumberFloors=" + totalNumberFloors + ", capacityPerVehicleType="
				+ capacityPerVehicleType + ", floors=" + floors + ", costStrategy=" + costStrategy + "]";
	}
    
}
