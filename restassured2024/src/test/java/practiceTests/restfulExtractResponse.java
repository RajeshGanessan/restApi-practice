package practiceTests;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import org.testng.annotations.Test;
import pojo.Address;
import pojo.Booking;

import java.util.List;

public class restfulExtractResponse {

    @Test
    public void extractTest(){
        Address address = RestAssured.get("https://run.mocky.io/v3/071c3ba0-09a0-458f-8581-e84fa561e0ba")
                .as(Address.class);
        System.out.println(address.getCountry());
    }

    @Test(description = "Extracting particular part of nested json")
    public void extractParticularJson(){
        Address address = RestAssured.get("https://run.mocky.io/v3/071c3ba0-09a0-458f-8581-e84fa561e0ba")
                .jsonPath().getObject("address",Address.class);
    }

    @Test(description = "convert json array response to pojo")
    public void extractJsonArrayResponse(){
        Address[] addressList = RestAssured.given().get("https://run.mocky.io/v3/acb210b1-6b86-41d8-b291-c86f26e43197")
                .as(Address[].class);
        System.out.println(addressList.length);
        System.out.println(addressList[1].getCountry());
    }

    @Test(description = "convert json array response to pojo as List")
    public void extractJsonArrayResponseList(){
        List<Address> addressList = RestAssured.given().get("https://run.mocky.io/v3/acb210b1-6b86-41d8-b291-c86f26e43197")
                .as(new TypeRef<>() {
                });
        System.out.println(addressList.size());
        System.out.println(addressList.get(0).getCountry());
    }
}
