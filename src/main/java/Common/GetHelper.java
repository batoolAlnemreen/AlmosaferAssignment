package Common;

import CustomExceptions.InvalidRequestResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetHelper extends Headers{
    public static Response get(String url) {
        if (RequestValidator.isNotNullOrEmpty(url)) {
            return   RestAssured.given().that().headers(requestHeader()).when().get(url).thenReturn();
        } else
            try {
                throw new InvalidRequestResponse("Invalid Request/Response");
            } catch (InvalidRequestResponse e) {
                e.printStackTrace();
            }
        return null;
    }
}

