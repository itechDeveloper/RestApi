package wtd.set.restapi.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import wtd.set.restapi.models.retrofitModels.DeleteModel;
import wtd.set.restapi.models.retrofitModels.GetModel;
import wtd.set.restapi.models.retrofitModels.PostModel;
import wtd.set.restapi.models.retrofitModels.UpdateModel;

public interface ApiInterface {

    @GET("/RestApi/php_apirest/api/post/read_category.php")
    Call<GetModel> getCategory();

    @POST("/RestApi/php_apirest/api/post/create.php")
    Call<PostModel> postData(@Body PostModel postModel);

    @PUT("/RestApi/php_apirest/api/post/update.php")
    Call<UpdateModel> updateData(@Body UpdateModel updateModel);

    @HTTP(method =  "DELETE", path = "/RestApi/php_apirest/api/post/delete.php", hasBody = true)
    Call<DeleteModel> deleteData(@Body DeleteModel deleteModel);
}
