package com.idroidz.aronarchitecture.data.model.api;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("Title")
    private final String title;
    @SerializedName("Year")
    private final String year;
    @SerializedName("imdbID")
    private final String id;

    public Movie(String title, String year, String id) {
        this.title = title;
        this.year = year;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getId() {
        return id;
    }
}
