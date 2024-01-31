package practiceTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class test1 {

    RequestSpecification requestSpecification;

    @BeforeClass
    public void setupReqspec() {
        requestSpecification = RestAssured.given();
        requestSpecification.log().all()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON);
    }
    @Test
    public void createUser() {

        RestAssured.given()
                .spec(requestSpecification)
                .get("api/users")
                .then().log().all();


    }
}
