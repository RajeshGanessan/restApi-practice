package restAssuredPlay;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import practiceTests.DataStoreAsMap;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public class restfulbooker2 {
    


    @Test
    public void convertJsonResponseToMap(){

        Map<String,Object> responseMap  =  RestAssured.get("https://restful-booker.herokuapp.com/booking/1")
                .as(new TypeRef<>() {});
        System.out.println(responseMap);
    }

    @Test
    public void convertJsonResponseToList(){
        List<Object> responseMap  =  RestAssured.get("https://restful-booker.herokuapp.com/booking")
                .as(List.class);
        System.out.println(responseMap);
        DataStoreAsMap.setdata("Name","Testing");
        DataStoreAsMap.getValue("Name");
    }

    @Test
    public void handlingJsonResponseDynamically(){
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");

        Object responseObject = response.as(Object.class);

        if(responseObject instanceof List){
            List<Object> responseList = response.as(List.class);
            System.out.println(responseList.size());
        } else if(responseObject instanceof Map){
            Map<String,Object> responseMap = (Map<String, Object>) responseObject;
            System.out.println(responseMap);
        }

    }
}
