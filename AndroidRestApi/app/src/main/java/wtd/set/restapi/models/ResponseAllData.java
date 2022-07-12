package wtd.set.restapi.models;

import com.google.gson.annotations.SerializedName;

import java.lang.annotation.Annotation;

public class ResponseAllData implements SerializedName {

    public int id;
    public String info;
    public String category;

    @Override
    public String value() {
        return null;
    }

    @Override
    public String[] alternate() {
        return new String[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}