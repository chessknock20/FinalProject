package org.example.apitests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {

    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI = "https://expert-sport.by";
    }
}
