import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Floor {
	
	private int floorNumber;
    private Map<String, List<VehicleSpace>> vehicleSpaces;

    public Floor(int floorNumber, int capacityPerVehicleType) {
        this.floorNumber = floorNumber;
        this.vehicleSpaces = new HashMap<>();
        initializeVehicleSpaces(capacityPerVehicleType);
    }

    public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public Map<String, List<VehicleSpace>> getVehicleSpaces() {
		return vehicleSpaces;
	}



	public void setVehicleSpaces(Map<String, List<VehicleSpace>> vehicleSpaces) {
		this.vehicleSpaces = vehicleSpaces;
	}



	@Override
	public String toString() {
		return "Floor [floorNumber=" + floorNumber + ", vehicleSpaces=" + vehicleSpaces + "]";
	}


	// Initialize vehicle spaces for each type
	private void initializeVehicleSpaces(int capacityPerVehicleType) {

        vehicleSpaces.put("Bike", new ArrayList<>());
        vehicleSpaces.put("Car", new ArrayList<>());
        vehicleSpaces.put("Bus", new ArrayList<>());


        for (Map.Entry<String, List<VehicleSpace>> entry : vehicleSpaces.entrySet()) {
            for (int i = 1; i <= capacityPerVehicleType; i++) {
                entry.getValue().add(new VehicleSpace(i, entry.getKey()));
            }
        }
    }

	public boolean isSpaceAvailable(String vehicleType) {
	    List<VehicleSpace> spaces = vehicleSpaces.get(vehicleType);
	    if (spaces != null) {
	        for (VehicleSpace space : spaces) {
	            if (space.isAvailability()) {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	public VehicleSpace parkVehicle(String vehicleType, Vehicle vehicle) {
	    List<VehicleSpace> spaces = vehicleSpaces.get(vehicleType);
	    if (spaces != null) {
	        for (VehicleSpace space : spaces) {
	            if (space.isAvailability()) {
	                space.parkVehicle(vehicle);
	                return space;
	            }
	        }
	    }
	    return null;
	}

    
    
}
