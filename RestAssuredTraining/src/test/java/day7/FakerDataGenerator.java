package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	
	@Test
	void testGeneratorDummyData() {
		
		Faker faker=new Faker();
		
		String fullName=faker.name().fullName();
		String firstName=faker.name().firstName();
		String username=faker.name().username();
		String password=faker.internet().password();
		String safeEmailAddress=faker.internet().safeEmailAddress();
		
		System.out.println(fullName);
		System.out.println(firstName);
		System.out.println(username);
		System.out.println(password);
		System.out.println(safeEmailAddress);
	}

}
