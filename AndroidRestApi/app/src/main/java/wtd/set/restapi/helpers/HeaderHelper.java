package wtd.set.restapi.helpers;

import java.util.HashMap;
import java.util.Map;

public class HeaderHelper {

    public static Map<String, String> getHeader(){
        HashMap<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json");
        return header;
    }

}
