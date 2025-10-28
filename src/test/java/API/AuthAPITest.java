package API;

import Utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.HashMap;

public class AuthAPITest {

    @BeforeClass
    public void setup() {
        ConfigReader.loadProperties();
        RestAssured.baseURI = ConfigReader.get("api.base.url");
    }

    @Test
    public void testRegisterSuccess() {
        HashMap<String, String> body = new HashMap<>();
        body.put("name", "Aliyah");
        body.put("email", "aliyahnafilah19@gmail.com");

        Response res = RestAssured.given()
                .contentType("application/json")
                .body(body)
                .post("/auth/register");

        Assert.assertEquals(res.statusCode(), 201);
        Assert.assertTrue(res.asString().contains("Registration successful"));
    }

    @Test
    public void testLoginInvalidCredentials() {
        HashMap<String, String> body = new HashMap<>();
        body.put("email", "aliyahnafilah19@gmail.com");
        body.put("password", "11223344");

        Response res = RestAssured.given()
                .contentType("application/json")
                .body(body)
                .post("/auth/login");

        Assert.assertEquals(res.statusCode(), 401);
        Assert.assertTrue(res.asString().contains("Invalid credentials"));
    }
}
