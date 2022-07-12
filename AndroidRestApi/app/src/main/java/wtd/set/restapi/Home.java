package wtd.set.restapi;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wtd.set.restapi.api.ApiInterface;
import wtd.set.restapi.helpers.logHelper;
import wtd.set.restapi.models.retrofitModels.DeleteModel;
import wtd.set.restapi.models.retrofitModels.GetModel;
import wtd.set.restapi.models.retrofitModels.PostModel;
import wtd.set.restapi.models.retrofitModels.UpdateModel;
import wtd.set.restapi.requests.ReadCategoryRequest;
import wtd.set.restapi.requests.ReadRequest;
import wtd.set.restapi.requests.ReadSingleRequest;
import wtd.set.restapi.retrofit.RetrofitClient;

public class Home extends AppCompatActivity {

    private static Home mInstance;
    public static Home getInstance() {
        return mInstance;
    }

    EditText editText_id, editText_info, editText_category;

    void init(){
        editText_id = findViewById(R.id.edittext_id);
        editText_info = findViewById(R.id.edittext_info);
        editText_category = findViewById(R.id.edittext_category);
    }

    void clearLogs(){
        editText_id.setText("");
        editText_info.setText("");
        editText_category.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        logHelper.logInfo("Application is running.");
        mInstance = this;

        init();
    }

    public void runReadRequest(View view) {
        logHelper.logInfo("Read request function is called.");
        new ReadRequest().run();
    }

    public void runReadSingleRequest(View view) {
        logHelper.logInfo("Read single request function is called.");
        if (editText_id.getText() != null){
            Constants.ID = Integer.parseInt(editText_id.getText().toString());
            new ReadSingleRequest().run();
        }else{
            logHelper.toast(this, "Please enter an id");
        }

        // TODO: Check if id is valid & exist in DB
    }

    public void runReadCategoryRequest(View view){
        logHelper.logInfo("Read category request function is called.");
        new ReadCategoryRequest().run();
    }

    public void runCreateRequest(View view) {
        ApiInterface apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);
        final PostModel postModel = new PostModel(Integer.parseInt(String.valueOf(editText_id.getText())), String.valueOf(editText_info.getText()), String.valueOf(editText_category.getText()));
        Call<PostModel> call = apiInterface.postData(postModel);

        clearLogs();

        call.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(@NonNull Call<PostModel> call, @NonNull Response<PostModel> response) {
                logHelper.logInfo("response: " + response);
            }

            @Override
            public void onFailure(@NonNull Call<PostModel> call, @NonNull Throwable t) {
                logHelper.logError("error: " +  t);
            }
        });
    }

    public void runUpdateRequest(View view) {
        ApiInterface apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);
        final UpdateModel updateModel = new UpdateModel(Integer.parseInt(String.valueOf(editText_id.getText())), String.valueOf(editText_info.getText()));
        Call<UpdateModel> call = apiInterface.updateData(updateModel);

        clearLogs();

        call.enqueue(new Callback<UpdateModel>() {
            @Override
            public void onResponse(@NonNull Call<UpdateModel> call, @NonNull Response<UpdateModel> response) {
                logHelper.logInfo("response: " + response);
            }

            @Override
            public void onFailure(@NonNull Call<UpdateModel> call, @NonNull Throwable t) {
                logHelper.logError("error: " +  t);
            }
        });
    }

    public void runDeleteRequest(View view){
        ApiInterface apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);
        final DeleteModel deleteModel = new DeleteModel(Integer.parseInt(String.valueOf(editText_id.getText())));
        Call<DeleteModel> call = apiInterface.deleteData(deleteModel);

        clearLogs();

        call.enqueue(new Callback<DeleteModel>() {
            @Override
            public void onResponse(@NonNull Call<DeleteModel> call, @NonNull Response<DeleteModel> response) {
                logHelper.logInfo("response: " + response);
            }

            @Override
            public void onFailure(@NonNull Call<DeleteModel> call, @NonNull Throwable t) {
                logHelper.logError("error: " +  t);
            }
        });
    }
}