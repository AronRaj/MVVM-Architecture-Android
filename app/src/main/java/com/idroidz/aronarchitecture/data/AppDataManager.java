package com.idroidz.aronarchitecture.data;

import com.idroidz.aronarchitecture.data.model.api.SearchResponse;
import com.idroidz.aronarchitecture.data.remote.ApiManager;

import javax.inject.Inject;

import io.reactivex.Single;

public class AppDataManager implements DataManager {

    private final ApiManager apiManager;

    @Inject
    public AppDataManager(ApiManager apiManager) {
        this.apiManager = apiManager;
    }

    @Override
    public Single<SearchResponse> getMoviesList(String movieSearchText) {
        return apiManager.getMoviesList(movieSearchText);
    }
}
