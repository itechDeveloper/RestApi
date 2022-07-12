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

public class ReadCategoryRequest implements Runnable {

    @Override
    public void run() {
        try {
            StringRequest jsonForPostRequest = new StringRequest(
                    Request.Method.GET,
                    Constants.READ_CATEGORY_URL,
                    response -> {
                        if (response != null) {
                            logHelper.logInfo("data returned: " + response);

                            Gson gson = new Gson();
                            AppHelper.getInstance().mData = gson.fromJson(response, ResponseModel.class);
                        }
                    }, error -> logHelper.logError("Error: " + error));
            jsonForPostRequest.setRetryPolicy(new DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            AppHelper.getInstance().addToRequestQueue(jsonForPostRequest, Home.getInstance());
        } catch (Exception ignored) {
            logHelper.logError(ignored.getMessage());
        }
    }
}
