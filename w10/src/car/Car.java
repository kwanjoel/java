package car;

import java.io.Serializable;

public class Car implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String model;
	String colour;
	int mileage;
	int plate;
	
	//Constructor with no plate;
	public Car(String model, String colour, int milage) {
		super();
		this.model = model;
		this.colour = colour;
		this.mileage = milage;
	}
	
	//Getters and Setters
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public int getMilage() {
		return mileage;
	}
	public void setMilage(int mileage) {
		this.mileage = mileage;
	}
	public int getPlate() {
		return plate;
	}
	public void setPlate(int plate) {
		this.plate = plate;
	}
	
	//toString();
	@Override
	public String toString() {
		return "Car [model=" + model + ", colour=" + colour + ", mileage=" + mileage + ", plate=" + plate + "]";
	}

	
	
}
