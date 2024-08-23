package stringCodes;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.google.common.base.CaseFormat;
import com.google.gson.JsonObject;

import day6.JsonSchemaValidation;
import groovy.lang.Singleton;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class statiCdeo2 {

	@Test
	public void testAPI() {	
		 
		Response res= given()
		
		.when().get("http://localhost:3000/store");
		
//		res.then().log().all();
		JsonPath path=new JsonPath(res.getBody().asString());
		
		List<Double> prices=path.getList("book.price",Double.class);
		double totalSalary=0;
		for(double price:prices) {
			System.out.println(price);
			totalSalary+=price;
		}
		
		System.out.println("Total Salary::"+ totalSalary);
		
	}
}
