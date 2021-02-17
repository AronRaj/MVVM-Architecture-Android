package com.idroidz.aronarchitecture.data.remote;

import com.idroidz.aronarchitecture.data.model.api.SearchResponse;

import io.reactivex.Single;

public interface ApiManager {

    Single<SearchResponse> getMoviesList(String movieSearchText);
}
