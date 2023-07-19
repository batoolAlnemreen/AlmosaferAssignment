package Apis.GetCurreciesList;

import Common.GetHelper;
import Constants.*;
import io.restassured.response.Response;


public class GetCurrenciesList {
    static Response getCurrenciesResponse;

    public static Response getCurrencies() {
        getCurrenciesResponse= GetHelper.get(EndPoints.getCurrenciesListPath);
        return getCurrenciesResponse;
    }
}
