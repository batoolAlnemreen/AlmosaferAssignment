package Apis.SearchForHotel;


import org.json.JSONArray;
import org.json.JSONObject;

public class SearchForHotel_Body {

    public static JSONObject searchHotelsRequestBody(String checkInDate, String checkOutDate, String placeId) {

        JSONObject roomInfoObj = new JSONObject();
        roomInfoObj.put("adultsCount", 1);

        JSONArray roomsInfoArray = new JSONArray();
        roomsInfoArray.put(roomInfoObj);

        JSONObject searchForHotelBody = new JSONObject();
        searchForHotelBody.put("checkIn", checkInDate);
        searchForHotelBody.put("checkOut", checkOutDate);
        searchForHotelBody.put("roomsInfo", roomsInfoArray);
        searchForHotelBody.put("placeId", placeId);

        return searchForHotelBody;
    }
    }

