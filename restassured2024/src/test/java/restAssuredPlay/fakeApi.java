package restAssuredPlay;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import restUtils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class fakeApi {

    public Response createUser(Map<String,Object> createUserPayLoad){
        String endpoint = (String) Base.dataFromJsonFile.get("qaEndpoint");
        Response response = RestUtils.makePostRequest(endpoint,createUserPayLoad,new HashMap<>());
        return response;

    }

    public void testCreateUser() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("test").headers(new HashMap<String,String>()).log().all().body("test").contentType(ContentType.JSON);

        ResponseSpecification responseSpecification = RestAssured.expect();
        responseSpecification.statusCode(200).and().contentType(ContentType.JSON).time(Matchers.lessThan(3L));

        ResponseSpecification responseSpecification1 = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectHeader("test","value")
                .expectBody(Matchers.containsString("jsonResonse"))
                .expectStatusCode(200).build();

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
       requestSpecification =  requestSpecBuilder.setBaseUri("test").addHeader("test","value")
                .setContentType(ContentType.JSON).log(LogDetail.ALL).build();

        RestAssured.given().spec(requestSpecification).body("posted").when().post()
                .then().spec(responseSpecification);



    }
}
