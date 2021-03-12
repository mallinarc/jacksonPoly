package polyDeserialize.jacksonPoly;

import java.io.File;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class FooZoo {
    public static void main(String[] args) throws Exception
    {
      //AnimalDeserializer deserializer = new AnimalDeserializer();
      //deserializer.registerAnimal("leashColor", Dog.class);
      //deserializer.registerAnimal("favoriteToy", Cat.class);
      //deserializer.registerAnimal("wing_span", Bird.class);

      //TestObjectDeserializer deserializer = new TestObjectDeserializer();
		//deserializer.register(ONE, TestObjectOne.class); // if "one" field is present, then it's a TestObjectOne
		//deserializer.register(TWO, TestObjectTwo.class); // if "two" field is present, then it's a TestObjectTwo
		
		// Add and register the UniquePropertyPolymorphicDeserializer to the Jackson module
		//SimpleModule module = new SimpleModule("PolymorphicTestObjectDeserializer", 
		//		new Version(1, 0, 0, null, "com.sportslabs.amp", "spring-social-bootstrap"));	
		
      
        //SimpleModule module = new SimpleModule("PolymorphicAnimalDeserializerModule", new Version(1, 0, 0, null));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        UniquePropertyPolymorphicDeserializer deserializer = new UniquePropertyPolymorphicDeserializer<>(Zoo.class);
        deserializer.register("leashColor", Dog.class);
        deserializer.register("favoriteToy", Cat.class);
        
        //objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        SimpleModule module = new SimpleModule("PolymorphicTestObjectDeserializer", new Version(1, 0, 0, null));
        module.addDeserializer(Animal.class, deserializer);
        objectMapper.registerModule(module);
        

     
      //module.addDeserializer(Animal.class, deserializer);
      
      //ObjectMapper mapper = new ObjectMapper();
      
      //mapper.setPropertyNamingStrategy(new CamelCaseNamingStrategy());
      //mapper.registerModule(module);
      FooZoo foozoo = new FooZoo();
      Zoo zoo = 
      objectMapper.readValue(new File(foozoo.getClass().getClassLoader().getResource("animal.json").getFile()), Zoo.class);
      System.out.println(objectMapper.writeValueAsString(zoo));
    }
}