package gorest.testcase;
/**
* Post new record with mention detail and check if added on backend 
* @author  Tripti Mehra
* @version 1.0
* @since   2019-08-22 
*/

//import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gogo.main.TestBase;
import gogo.post.NewUser;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



import io.restassured.authentication.*;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.*;

public class TC2APITest extends TestBase{
	//Declared NewUser class object
	NewUser newuser;
	//innitialized required classes
	public TC2APITest()
	{
		super();
		
	}
	@BeforeMethod
	public void innitiate()
	{
		RestAssured.useRelaxedHTTPSValidation();
        RestAssured.config().getSSLConfig().with().keyStore("classpath:keystore.p12", "password");
		
		
	}
	@Test(priority = 1)
	public void putTest()
	{   
		//Put request to add new user with given email
		//Innitialize newuser class
		newuser = new NewUser();
	
       newuser.setEmail(prop.getProperty("email"));
		newuser.setFirst(prop.getProperty("first_name"));
		newuser.setLast(prop.getProperty("last_name"));
		newuser.setGender(prop.getProperty("gender"));
		//RestAssured Request
		given()
		.urlEncodingEnabled(false)
		.auth().preemptive().oauth2(prop.getProperty("bearer"))
		.contentType("application/json")
		
		.body(newuser)
		
		.when()
		.post(prop.getProperty("baseURI"))
		.then()
		.log().all();
		
	}
	@Test(priority = 2)
	public void getTest()
	{  
		//Get request to check if details with mentioned email added or not
		given()
		.urlEncodingEnabled(false)
		.auth().preemptive().oauth2(prop.getProperty("bearer"))
		.when()
		.get(prop.getProperty("baseURI") + "?email=" +prop.getProperty("email") )
		.then()
		.statusCode(200)
		.body("email", equalTo(prop.getProperty("email")))
		.log().all();
		
		
	}
	
	}


