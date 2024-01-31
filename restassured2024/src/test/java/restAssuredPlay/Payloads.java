package restAssuredPlay;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    public static Map<String,Object> getCreateUserPayload(String userName, String job){
        Map<String,Object> payload = new HashMap<>();
        payload.put("name",userName);
        payload.put("job",job);
        return payload;
    }
}
