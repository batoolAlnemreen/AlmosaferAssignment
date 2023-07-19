package Constants;

public class EndPoints {
    public static String BASE_URL;
    public static String SearchForHotelsPath;
    public static String getCurrenciesListPath;



    static {
        BASE_URL="https://www.almosafer.com/api";
        SearchForHotelsPath=BASE_URL+"/enigma/search/async";
        getCurrenciesListPath=BASE_URL+"/system/currency/list";

    }
}
