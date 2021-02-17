package com.idroidz.aronarchitecture.data.model.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {
    @SerializedName("Search")
    private List<Movie> moviesList;
    @SerializedName("totalResults")
    private Integer totalResults;
    @SerializedName("Response")
    private boolean isSuccess;

    public SearchResponse() {

    }

    public SearchResponse(List<Movie> moviesList, Integer totalResults, boolean isSuccess) {
        this.moviesList = moviesList;
        this.totalResults = totalResults;
        this.isSuccess = isSuccess;
    }

    public List<Movie> getMoviesList() {
        return moviesList;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
