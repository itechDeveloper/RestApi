package wtd.set.restapi.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import wtd.set.restapi.models.DeleteModel;
import wtd.set.restapi.models.PostModel;
import wtd.set.restapi.models.UpdateModel;

public interface ApiInterface {

    @POST("/php_apirest/api/post/create.php")
    Call<PostModel> postData(@Body PostModel postModel);

    @PUT("/php_apirest/api/post/update.php")
    Call<UpdateModel> updateData(@Body UpdateModel updateModel);

    @HTTP(method =  "DELETE", path = "/php_apirest/api/post/delete.php", hasBody = true)
    Call<DeleteModel> deleteData(@Body DeleteModel deleteModel);
}
