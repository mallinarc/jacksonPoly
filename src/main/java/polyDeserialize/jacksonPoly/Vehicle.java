package polyDeserialize.jacksonPoly;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = Car.class, name = "car"), @Type(value = Truck.class, name = "truck")
})
public abstract class Vehicle {
	private String make;
	private String model;

	protected Vehicle(String make, String model) {
		this.setMake(make);
		this.setModel(model);
	}

	protected Vehicle() {
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
