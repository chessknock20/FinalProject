package org.example.apitests;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.example.selenium.enums.Capability;
import org.example.selenium.utils.PropertyReader;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;


public class ApiTests extends BaseApiTest {

    @Test
    public void clickSignIn(){
        given().log().uri()
                .when().get("/login/")
                .then().log().all().statusCode(200);
    }

    @Test
    public void SignInAuth(){
        given()
                .auth().basic(PropertyReader.getUserProperty(Capability.LOGIN), PropertyReader.getUserProperty(Capability.PASSWORD))
                .when().get("/login/")
                .then().log().all().statusCode(200);
    }

    @Test
    public void SignInPostJsonFile() {
        File file = new File("src/test/resources/json/user.json");
        given().log().all().contentType(ContentType.JSON).body(file)
                .when().post("/login/")
                .then().log().all().statusCode(200);
    }

    @Test
    public void AddToCart(){
        given().log().all().contentType(ContentType.JSON).body("{\n" +
                        "    \"quantity\": \"1\",\n" +
                        "    \"product_id\": \"1488\"\n" +
                        "}")
                .when().post("/index.php?route=checkout/cart/add")
                .then().log().all().statusCode(200);
    }

    @Test
    public void TestJsonSchema(){
        given().log().uri()
                .when().post("/index.php?route=checkout/cart/add")
                .then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json/jsonschema.json"));

    }


}
