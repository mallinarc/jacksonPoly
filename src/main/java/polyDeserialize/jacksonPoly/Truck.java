package polyDeserialize.jacksonPoly;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

public class Truck extends Vehicle {
	@JsonProperty("@Type")
	private double payloadCapacity;

	public Truck(String make, String model, double payloadCapacity) {
		super(make, model);
		this.setPayloadCapacity(payloadCapacity);
	}

	public Truck() {
		super();
	}

	public double getPayloadCapacity() {
		return payloadCapacity;
	}

	public void setPayloadCapacity(double payloadCapacity) {
		this.payloadCapacity = payloadCapacity;
	}

	// no-arg constructor, getters and setters
}