package API.testNG;

import API.init.Specifications;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiRequestLocation {
    private String url = "http://api.ipstack.com";
    private String requestUrl = "93.74.77.41?access_key=afe45e4bef837d98008a62ef556ca9ee&format=1";
    private String latitudeExpected = "50.3";
    private String longitudeExpected = "30.6";
    //second
    //@Test
    public void taskLocationCheck() {
        Specifications.installSpecification(Specifications.requestSpecification(url), Specifications.responseSpecification(200));
        Response response = given()
                .when()
                .get(requestUrl)
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(latitudeExpected,jsonPath.get("latitude").toString().substring(0,4));
        Assert.assertEquals(longitudeExpected,jsonPath.get("longitude").toString().substring(0,4));
    }
}
