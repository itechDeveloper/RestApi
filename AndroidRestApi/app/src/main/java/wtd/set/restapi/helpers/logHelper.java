package wtd.set.restapi.helpers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class logHelper {

    public static void logInfo(String info){
        Log.i("TAG_INFO", info);
    }
    public static void logError(String error){
        Log.e("TAG_ERROR", error);
    }
    public static void toast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
