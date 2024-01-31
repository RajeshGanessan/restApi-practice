package restAssuredPlay;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;


public class fakeApitest extends  fakeApi{


    @Test
    public void createUserTest() throws IOException {
        Map<String, Object> payload = Payloads.getCreateUserPayload("rrajeshKk","SDET");
        Response response = createUser(payload);
        Assert.assertEquals(response.statusCode(),201);
    }
}
