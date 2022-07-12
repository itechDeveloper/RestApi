package wtd.set.restapi.requests;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import wtd.set.restapi.Constants;
import wtd.set.restapi.Home;
import wtd.set.restapi.helpers.AppHelper;
import wtd.set.restapi.helpers.logHelper;
import wtd.set.restapi.models.ResponseModel;

public class ReadSingleRequest implements Runnable {

    @Override
    public void run() {
        try {
            StringRequest jsonForPostRequest = new StringRequest(
                    Request.Method.GET,
                    Constants.READ_SINGLE_DATA_URL + Constants.ID,
                    response -> {
                        if (response != null) {
                            logHelper.logInfo("data returned: " + response);
                        }
                    }, error -> logHelper.logError("Error: " + error));
            jsonForPostRequest.setRetryPolicy(new DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            AppHelper.getInstance().addToRequestQueue(jsonForPostRequest, Home.getInstance());
        } catch (Exception ignored) {
            logHelper.logError(ignored.getMessage());
        }
    }
}