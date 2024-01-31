package restAssuredPlay;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.assertj.core.error.AssertionErrorCreator;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class restfulBookerTest1 {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    JsonPath jsonPath;
    String jsonFileName = "PayloadData/restFulBookerData.json";

    @BeforeClass
    public void SetupRequestSpecs() {

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
    }

    @Test
    public void createBooking() throws IOException {

        Response response = RestAssured.given().spec(requestSpecification)
                .body(getBookingDetailsAsMap())
                .when().post("/booking")
                .then().spec(responseSpecification).extract().response();
        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.jsonPath().get("booking.firstname").toString()).isNotEmpty();


    }

    private Map<String,Object> getBookingDetailsAsFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonFilePath = System.getProperty("user.dir") + "/src/test/resources/" + jsonFileName;
        Map<String, Object> bookingDetails = objectMapper.readValue(new File(jsonFilePath), new TypeReference<>() {
        });
        return bookingDetails;
    }

    private Map<String,Object> getBookingDetailsAsMap(){

        Map<String,Object> booking = new HashMap<>();
        Map<String,Object> bookingDates = new HashMap<>();
        booking.put("firstname","Jim");
        booking.put("lastname","casey");
        booking.put("totalprice",111);
        booking.put("depositpaid",true);
        booking.put("bookingdates",bookingDates);
        booking.put("additionalneeds","breakfast");

        bookingDates.put("checkin","2018-10-10");
        bookingDates.put("checkout","2020-14-18");

        List<Map<String,Object>> allBooking = new ArrayList<>();
        allBooking.add(booking);
        allBooking.add(bookingDates);
        return booking;


    }

    private List<Map<String,Object>> getDummyJson(){

        List<Map<String,Object>> mainPayload = new ArrayList<>();

        Map<String,Object> firstEntry = new HashMap<>();
        Map<String,Object> address = new HashMap<>();
        Map<String,Object> details = new HashMap<>();


        Map<String,Object> secondEntry = new HashMap<>();
        details.put("test","dummy");
        address.put("street","kambar");
        address.put("city","madurai");
        address.put("details",details);

        firstEntry.put("fullName","jeff");
        firstEntry.put("address",address);
        firstEntry.put("house","main");

        secondEntry.put("fullName","jeff");
        secondEntry.put("address",address);
        secondEntry.put("house","main");

        mainPayload.add(firstEntry);
        mainPayload.add(secondEntry);
        return mainPayload;

    }
}
