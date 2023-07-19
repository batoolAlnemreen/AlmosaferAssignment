package Common;

public class RequestValidator {

    public static boolean isNotNullOrEmpty(Object param){
    return !(param.toString()==null || param.toString().isEmpty());

    }
}

