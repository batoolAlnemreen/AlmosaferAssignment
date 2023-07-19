package Apis.SearchForHotel;

import Common.PostHelper;
import Constants.*;
import io.restassured.response.Response;


public class SearchForHotel {
     Response searchHotelResponse;
    public  Response searchHotelResponse(String token, String checkInDate, String checkOutDate, String placeId) {
        searchHotelResponse= PostHelper.post(EndPoints.SearchForHotelsPath,token,SearchForHotel_Body.searchHotelsRequestBody(checkInDate,checkOutDate,placeId));
        return searchHotelResponse;
    }
}
