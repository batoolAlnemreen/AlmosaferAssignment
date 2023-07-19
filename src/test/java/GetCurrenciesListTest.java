import Apis.GetCurreciesList.GetCurrenciesList;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static Constants.Constants.EXPECTED_STATUS_CODE;


@Listeners(ExtentReport.TestListener.class)
public class GetCurrenciesListTest {
    @Test(description = "Validate the Status Code")
    public void testCurrenciesAPI(){
        GetCurrenciesList currenciesList=new GetCurrenciesList();
        Response response= currenciesList.getCurrencies();
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),EXPECTED_STATUS_CODE);
    }
    @Test(description = "Validate that the base && the equivalent objects are returned and contain data ")
    public void SearchHotelTestMandatoryField(){
        GetCurrenciesList currenciesList=new GetCurrenciesList();
        Response response= currenciesList.getCurrencies();
        JsonPath jsonPath = new JsonPath(response.asString());
        boolean baseObjectExists = jsonPath.get("base") != null;
        Assert.assertTrue(baseObjectExists,"The Base object is not present in the response.");
        boolean equivalentObjectExists = jsonPath.get("equivalent") != null;
        Assert.assertTrue(baseObjectExists,"The Equivalent object is not present in the response.");


    }
}
