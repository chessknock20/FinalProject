package org.example.apitests;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.example.selenium.enums.Capability;
import org.example.selenium.utils.PropertyReader;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class ApiTests {

    @Test
    public void clickSignIn(){
        given().log().uri()
                .when().get("https://expert-sport.by/login/")
                .then().log().all().statusCode(200);
    }

    @Test
    public void SignInAuth(){
        given()
                .auth().basic(PropertyReader.getUserProperty(Capability.LOGIN), PropertyReader.getUserProperty(Capability.PASSWORD))
                .when().get("https://expert-sport.by/login/")
                .then().log().all().statusCode(200);
    }
    @Test
    public void SignInPostJson(){
        given().log().all().contentType(ContentType.JSON).body("{\n" +
                       "    \"name\": \"chessknock20@gmail.com\",\n" +
                        "    \"password\": \"110v354m\"\n" +
                        "}")
                .when().post("https://expert-sport.by/login/")
                .then().log().all().statusCode(200);
    }

//    @Test
//    public void TestJsonShema(){
//        given().log().uri()
//                .when().get("https://expert-sport.by/login/")
//                .then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschema.json"));
//
//    }


}
