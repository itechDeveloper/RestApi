package wtd.set.restapi.helpers;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import wtd.set.restapi.models.ResponseModel;

public class AppHelper {

    private static AppHelper mInstance;
    private static final Object lock = new Object();
    private RequestQueue requestQueue;
    public ResponseModel mData;
    public static AppHelper getInstance(){
        synchronized (lock){
            if (mInstance == null){
                mInstance = new AppHelper();
            }
            return mInstance;
        }
    }

    public <T> void addToRequestQueue(Request<T> req, Context context){
        getRequestQueue(context).add(req);
    }

    public RequestQueue getRequestQueue(Context context) {
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }
}
