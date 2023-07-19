package Common;

import java.util.HashMap;
import java.util.Map;

import static Constants.Constants.*;

public class Headers {

    public static Map<String, String> requestHeader() {
        Map<String, String> header = new HashMap<String, String>();
        header.put("authority", AUTHERITY);
        header.put("accept", ACCEPT);
        return header;

    }
    public static Map<String, String> requestHeaderWithToken(String token) {
        Map<String, String> header = new HashMap<String, String>();
        header.put("content-type", CONTENT_TYPE_VALUE);
        header.put("token",token);
        return header;

    }
}
