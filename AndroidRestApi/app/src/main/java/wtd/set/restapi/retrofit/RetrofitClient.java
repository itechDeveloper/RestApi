package wtd.set.restapi.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import wtd.set.restapi.Constants;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    private static final String BaseUrl = "http://192.168.0.102/php_apirest/";

    public static Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
