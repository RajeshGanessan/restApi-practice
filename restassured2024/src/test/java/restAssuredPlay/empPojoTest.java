package restAssuredPlay;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import pojo.Employee;

import java.util.ArrayList;

public class empPojoTest {

    static ObjectMapper objectMapper;

    @Test
    public void test() throws JsonProcessingException {

//          String json = " {\n" +
//               "    \"name\": \"sony\",\n" +
//               "    \"age\": 27,\n" +
//               "    \"isMarried\": true,\n" +
//               "    \"address\": \"london\",\n" +
//               "    \"mobileNo\": \"983424\",\n" +
//               "    \"department\": \"testing\"\n" +
//               "  }";
//        objectMapper = new ObjectMapper();
//       Employee emp = objectMapper.readValue(json,Employee.class);
//        System.out.println(emp.getAddress());

        Employee empp = Employee.builder()
                .name("Ajay")
                .age(28)
                .address("SS COlony")
                .isMarried(false)
                .mobileNo("34234234").build();

        RestAssured.baseURI ="https://google.com";
        RestAssured.given().body(empp)
                .log().all().when().post().then().log().all();

        objectMapper = new ObjectMapper();

        String empJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(empp);
        System.out.println(empJson);

       Employee emp1 =  empp.toBuilder()
                .name("karthick")
                .age(30).build();
        String empJson1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);

        System.out.println(empJson1);

    }

    @Test
    public void verifyingTypeOfJson(){

        RestAssured.get("https://run.mocky.io/v3/acb210b1-6b86-41d8-b291-c86f26e43197")
                .then().body("", Matchers.instanceOf(ArrayList.class));
    }
}
