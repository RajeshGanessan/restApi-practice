package restAssuredPlay;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import pojo.Address;
import pojo.Booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class restfulPojoTest1 {


    @Test
    public void pojoTest(){

        Booking booking = new Booking();
        booking.setFirstname("Rajesh");
        booking.setLastname("Gaa");
        booking.setTotalprice(120);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("add test");

        RestAssured.given()
                .body(booking)
                .log().all().when().post().then().log().all();



    }

    @Test
    public void pojoTestForJsonArray(){

        Address address = new Address();
        address.setStreetName("Kambar");
        address.setCity("madurai");
        address.setCountry("India");
        address.setState("TN");

        Address address2 = new Address();
        address.setStreetName("T23");
        address.setCity("Chennai");
        address.setCountry("India");
        address.setState("TN");

        List<Address> addresses = Arrays.asList(address,address2);
        Booking booking = new Booking();
        booking.setFirstname("Rajesh");
        booking.setLastname("Gaa");
        booking.setTotalprice(120);
        booking.setDepositpaid(true);
        booking.setAddress(addresses);
        booking.setAdditionalneeds("add test");

        Booking booking2 = new Booking();
        booking.setFirstname("Aravind");
        booking.setLastname("K");
        booking.setTotalprice(130);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("add test2");




        List<Booking> jsonArray = new ArrayList<>();
        jsonArray.add(booking);
        jsonArray.add(booking2);
        RestAssured.given()
                .body(jsonArray)
                .log().all().when().post().then().log().all();

    }

}
