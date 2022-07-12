package wtd.set.restapi.models.retrofitModels;

import com.google.gson.annotations.SerializedName;

public class PostModel {

    @SerializedName("id")
    private int id;
    @SerializedName("info")
    private String info;
    @SerializedName("category")
    private String category;

    public PostModel(int id, String info, String category) {
        this.id = id;
        this.info = info;
        this.category = category;
    }
}
