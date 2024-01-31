package restUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {

        public static Response makePostRequest(String endpoint, String payload, Map<String, String> headers){

            return RestAssured.given()
                    .baseUri(endpoint)
                    .headers(headers)
                    .body(payload)
                    .log().all()
                    .post().then()
                    .log().all().extract().response();
        }

    public static Response makePostRequest(String endpoint, Map<String,Object> payload, Map<String, String> headers){

        return RestAssured.given()
                .baseUri(endpoint)
                .headers(headers)
                .body(payload)
                .log().all()
                .post().then()
                .log().all().extract().response();
    }

    public static Response makePutRequest(String endPoint,Map<String,Object> payload,Map<String,String> headers){

            return RestAssured.given()
                    .baseUri(endPoint)
                    .headers(headers)
                    .body(payload)
                    .log().all()
                    .put().then().log().all().extract().response();
    }



}
