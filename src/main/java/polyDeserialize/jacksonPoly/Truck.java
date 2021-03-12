package polyDeserialize.jacksonPoly;

public class Truck extends Vehicle {
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