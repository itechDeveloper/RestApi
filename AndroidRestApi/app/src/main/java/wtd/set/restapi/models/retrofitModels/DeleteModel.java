package wtd.set.restapi.models.retrofitModels;

import com.google.gson.annotations.SerializedName;

public class DeleteModel {

    @SerializedName("id")
    private int id;

    public DeleteModel(int id) {
        this.id = id;
    }

}
