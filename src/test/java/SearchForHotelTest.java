import Apis.SearchForHotel.SearchForHotel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ExtentReport.TestListener.class)
public class SearchForHotelTest {
    @Test(description = "Validate the Status Code")
    public void SearchHotelTestStatusCode(){
        SearchForHotel searchForHotel=new SearchForHotel();
        Response response= searchForHotel.searchHotelResponse("skdjfh73273$7268u2j89s","2023-08-02",  "2023-08-03",  "ChIJmZNIDYkDLz4R1Z_nmBxNl7o");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),200);

    }

    @Test(description = "Validate that the sessionID returned in the response")
    public void SearchHotelTestMandatoryField(){
        SearchForHotel searchForHotel=new SearchForHotel();
        Response response= searchForHotel.searchHotelResponse("skdjfh73273$7268u2j89s","2023-08-02",  "2023-08-03",  "ChIJmZNIDYkDLz4R1Z_nmBxNl7o");
        JsonPath jsonPath = new JsonPath(response.asString());
        boolean objectExists = jsonPath.get("sId") != null;
        Assert.assertTrue(objectExists,"The expected object is not present in the response.");
    }
}
