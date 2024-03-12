package Model;

import Model.Vehicle;

public class VehicleSpace {
	
	
	private int spaceNumber;
    private boolean availability;
    private String vehicleType;
    private Vehicle parkedVehicle;

    public VehicleSpace(int spaceNumber, String vehicleType) {
        this.spaceNumber = spaceNumber;
        this.availability = true;
        this.vehicleType = vehicleType;
    }
    
    

    public int getSpaceNumber() {
		return spaceNumber;
	}



	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}



	public boolean isAvailability() {
		return availability;
	}



	public void setAvailability(boolean availability) {
		this.availability = availability;
	}



	public String getVehicleType() {
		return vehicleType;
	}



	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}



	public Vehicle getParkedVehicle() {
		return parkedVehicle;
	}



	public void setParkedVehicle(Vehicle parkedVehicle) {
		this.parkedVehicle = parkedVehicle;
	}



	@Override
	public String toString() {
		return "Model.VehicleSpace [spaceNumber=" + spaceNumber + ", availability=" + availability + ", vehicleType="
				+ vehicleType + ", parkedVehicle=" + parkedVehicle + "]";
	}

	public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.availability = false;
    }

	public Vehicle removeVehicle() {
        Vehicle removedVehicle = parkedVehicle;
        this.parkedVehicle = null;
        this.availability = true;
        return removedVehicle;
    }
		
 
}
