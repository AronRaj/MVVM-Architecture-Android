package com.idroidz.aronarchitecture.data.remote;

import com.idroidz.aronarchitecture.BuildConfig;
import com.idroidz.aronarchitecture.data.model.api.SearchResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class RetrofitApiManager implements ApiManager {

    private final RetrofitService retrofitService;

    @Inject
    public RetrofitApiManager(RetrofitService retrofitService) {
        this.retrofitService = retrofitService;
    }

    @Override
    public Single<SearchResponse> getMoviesList(String movieSearchText) {
        return retrofitService.getMovies(movieSearchText, BuildConfig.API_KEY);
    }
}
