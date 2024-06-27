package org.example.apitests;

import io.restassured.http.ContentType;
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
                .auth().basic("login", "password")
                .when().get("https://expert-sport.by/login/")
                .then().log().all().statusCode(200);
    }
    @Test
    public void SignInPostJson(){
        given().log().all().contentType(ContentType.JSON).body("{\n" +
                       "    \"name\": \"mylogin\",\n" +
                        "    \"password\": \"mypassword\"\n" +
                        "}")
                .when().post("https://expert-sport.by/login/")
                .then().log().all().statusCode(200);
    }


}
