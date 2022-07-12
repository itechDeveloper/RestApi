package wtd.set.restapi;

import java.util.Map;

public class Constants {

    // URLS
    public static final String READ_ALL_DATA_URL = "http://192.168.0.102/php_apirest/api/post/read.php";
    public static final String READ_SINGLE_DATA_URL = "http://192.168.0.102/php_apirest/api/post/read_single.php?id=";
    public static final String POST_DATA_URL = "http://192.168.0.102/php_apirest/api/post/create.php";

    // VARIABLES
    public static int ID;

    // PARAMETERS
    public static Map<String, String> params;
}
