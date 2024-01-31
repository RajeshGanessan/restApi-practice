package restAssuredPlay;

import Utils.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class Base {

    public static Map<String,Object> dataFromJsonFile;

    static {
        try {
             dataFromJsonFile = JsonUtils.getJsonDataAsMap("PayloadData/QAenvEndpoint.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
