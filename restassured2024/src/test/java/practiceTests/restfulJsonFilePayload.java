package practiceTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.Address;
import restAssuredPlay.Base;
import restUtils.RestUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class restfulJsonFilePayload {

    static ObjectMapper objectMapper;

    @Test
    public void readJsonValue() throws IOException {

         objectMapper = new ObjectMapper();
        Address address = objectMapper.readValue(new File(System.getProperty("user.dir") + "/src/test/resources/PayloadData/addressPayload.json"),
                Address.class);
        System.out.println(address.getCountry());
        address.setCity("Maldives");
        System.out.println(address.getCity());
        String updatedJson  =objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
        System.out.println(updatedJson);

    }

    @Test(description = "changing payload dynamically through Map")
    public void changingPayloadThroughMap() throws IOException {

        objectMapper = new ObjectMapper();
        Map<String,Object> addressMap = objectMapper.readValue(new File(System.getProperty("user.dir") + "/src/test/resources/PayloadData/addressPayload.json"),
                new TypeReference<Map<String, Object>>() {});
        addressMap.put("state","Karnataka");
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(addressMap));
    }

    @Test(description = "json include tests")
    public void jsonIncludeDefault() throws JsonProcessingException {

        Address address = new Address();
        address.setCity("madurai");
        address.setStreetName("kambar");
        address.setIsLegal(false);
        objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
        System.out.println(json);
    }

}
