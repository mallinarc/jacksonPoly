package polyDeserialize.jacksonPoly;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car extends Vehicle {
	@JsonProperty("@Type")
	private int seatingCapacity;
	private double topSpeed;

	public Car(String make, String model, int seatingCapacity, double topSpeed) {
		super(make, model);
		this.seatingCapacity = seatingCapacity;
		this.topSpeed = topSpeed;
	}

	public Car() {
		super();
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public double getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(double topSpeed) {
		this.topSpeed = topSpeed;
	}

	// no-arg constructor, getters and setters
}
