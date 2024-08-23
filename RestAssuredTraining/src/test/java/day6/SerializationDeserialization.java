package day6;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



//POJO --> Serialization --> JSON Object --> Deserialization --> POJO
class pojoStudent{
	
	String name;
	String location;
	String phone;
	String [] courses;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
}

//POJO --> Serialization --> JSON Object --> Deserialization --> POJO
public class SerializationDeserialization {

	@Test(priority = 1)
	void covertPOJO2JSON() throws JsonProcessingException {
		
		pojoStudent data=new pojoStudent();
		data.setName("Scott");
		data.setLocation("France");
		data.setPhone("1234556");
		String courseArr[] = { "C", "C++" };
		data.setCourses( courseArr);
		
		//convert plain old java object  ---> json object (serialization)
		ObjectMapper mapper=new ObjectMapper();
		String jsondata=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		System.out.println(jsondata);
		
	}
	
	@Test(priority = 2)
	void covertJSON2POJO() throws JsonProcessingException {
		
		String jsonData="{\r\n"
				+ "  \"name\" : \"Scott\",\r\n"
				+ "  \"location\" : \"France\",\r\n"
				+ "  \"phone\" : \"1234556\",\r\n"
				+ "  \"courses\" : [ \"C\", \"C++\" ]\r\n"
				+ "}";
		ObjectMapper mapper=new ObjectMapper();
		pojoStudent pojo=mapper.readValue(jsonData, pojoStudent.class);
		System.out.println("Name::"+pojo.getName());
		System.out.println("Location::"+pojo.getLocation());
		System.out.println("Phone::"+pojo.getPhone());
		System.out.println("Course 1::"+pojo.getCourses()[0]);
		System.out.println("Course 2::"+pojo.getCourses()[1]);
	}
}
