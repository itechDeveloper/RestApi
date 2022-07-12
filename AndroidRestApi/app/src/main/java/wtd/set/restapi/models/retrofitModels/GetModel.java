package wtd.set.restapi.models.retrofitModels;

import com.google.gson.annotations.SerializedName;

public class GetModel {

    @SerializedName("id")
    private int id;
    @SerializedName("category")
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
