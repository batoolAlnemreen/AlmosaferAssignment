package Common;

import CustomExceptions.InvalidRequestResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class PostHelper extends Headers {

    public static Response post(String url,String token, JSONObject requestBody) {
        if (RequestValidator.isNotNullOrEmpty(url)) {
          return  RestAssured.given().that().headers(requestHeaderWithToken(token)).body(requestBody.toString()).when().post(url).thenReturn();
        } else
            try {
                throw new InvalidRequestResponse("Invalid Request/Response");
            } catch (InvalidRequestResponse e) {
                e.printStackTrace();
            }
            return null;
    }
}
