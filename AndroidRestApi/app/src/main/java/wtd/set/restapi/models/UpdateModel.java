package wtd.set.restapi.models;

import com.google.gson.annotations.SerializedName;

public class UpdateModel {

    @SerializedName("id")
    private int id;
    @SerializedName("info")
    private String info;

    public UpdateModel(int id, String info) {
        this.id = id;
        this.info = info;
    }
}
