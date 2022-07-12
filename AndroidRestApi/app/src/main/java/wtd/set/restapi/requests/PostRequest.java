package wtd.set.restapi.requests;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import wtd.set.restapi.Constants;
import wtd.set.restapi.Home;
import wtd.set.restapi.helpers.HeaderHelper;
import wtd.set.restapi.helpers.AppHelper;
import wtd.set.restapi.helpers.logHelper;

public class PostRequest implements Runnable {

    @Override
    public void run() {
        StringRequest jsonForPostRequest = new StringRequest(
                Request.Method.POST,
                Constants.POST_DATA_URL,
                response -> {
                    if (response != null) {
                        logHelper.logInfo("response: " + response);
                    } else {
                        logHelper.logInfo("response is null");
                    }
                }, error -> logHelper.logError("error: " + error)) {

            @Override
            protected Map<String, String> getParams() {
                return null;
            }

            @Override
            public Map<String, String> getHeaders() {
                return HeaderHelper.getHeader();
            }
        };

        jsonForPostRequest.setRetryPolicy(new DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppHelper.getInstance().addToRequestQueue(jsonForPostRequest, Home.getInstance());
    }
}