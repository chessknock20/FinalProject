package com.itacademy.apitests;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import com.itacademy.selenium.utils.PropertyReader;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;


public class ApiTests extends BaseApiTest {

    @Test
    public void testGetLogin(){
        given().log().uri()
                .when().get("/login/")
                .then().log().all().statusCode(200);
    }

    @Test
    public void testSignInAuth(){
        given()
                .auth().basic("chessknock20@gmail.com","110v354m")
                .when().get("/login/")
                .then().log().all().statusCode(200);
    }

    @Test
    public void testPostJsonFile() {
        File file = new File("src/test/resources/json/user.json");
        given().log().all().contentType(ContentType.JSON).body(file)
                .when().post("/login/")
                .then().log().all().statusCode(200);
    }

    @Test
    public void testAddToCart(){
        given().log().all().contentType(ContentType.JSON).body("{\n" +
                        "    \"quantity\": \"1\",\n" +
                        "    \"product_id\": \"1488\"\n" +
                        "}")
                .when().post("/index.php?route=checkout/cart/add")
                .then().log().all().statusCode(200);
    }

    @Test
    public void testJsonSchema(){
        given().header("accept","application/json, text/javascript, */*; q=0.01").header("content-type", "application/x-www-form-urlencoded; charset=UTF-8").log().uri().body("quantity=1&product_id=1488")
                .when().post("/index.php?route=checkout/cart/add")
                .then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json/jsonschema.json"));

    }


}
