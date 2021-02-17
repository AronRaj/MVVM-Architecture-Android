package com.idroidz.aronarchitecture.data.remote;

import com.idroidz.aronarchitecture.data.model.api.SearchResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("?")
    Single<SearchResponse> getMovies(@Query("s") String searchText, @Query("apikey") String apikey);
}
