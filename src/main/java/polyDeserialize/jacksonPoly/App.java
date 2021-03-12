package polyDeserialize.jacksonPoly;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Hello World!");
		App app = new App();
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		File file = new File(app.getClass().getClassLoader().getResource("input.json").getFile());
		// Fleet deserializedFleet = mapper.readValue(file, Fleet.class);
		Company deserializedFleet = mapper.readValue(file, Company.class);
		System.out.println(mapper.writeValueAsString(deserializedFleet));

		File file1 = new File(app.getClass().getClassLoader().getResource("truck.json").getFile());
		CompanyOne deserializedTruck = mapper.readValue(file1, CompanyOne.class);
		System.out.println("...........Truck Desserialized:" + mapper.writeValueAsString(deserializedTruck));

	}
}
