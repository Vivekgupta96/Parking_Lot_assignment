package Model;

public class Vehicle {
	
	private String type;
    private String registrationNumber;
    private String color;

    public Vehicle(String type, String registrationNumber, String color) {
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	@Override
	public String toString() {
		return "Model.Vehicle [type=" + type + ", registrationNumber=" + registrationNumber + ", color=" + color + "]";
	}
    
	    

}
