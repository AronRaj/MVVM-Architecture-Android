package com.idroidz.aronarchitecture.data.remote;

import com.idroidz.aronarchitecture.BuildConfig;
import com.idroidz.aronarchitecture.data.model.api.SearchResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import io.reactivex.Single;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class RetrofitApiManagerTest {

    private RetrofitApiManager retrofitApiManager;

    @Mock
    private RetrofitService retrofitService;

    @Before
    public void setUp() throws Exception {
        retrofitApiManager =new RetrofitApiManager(retrofitService);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test_getMoviesList() {
        String searchText = "Iron";
        SearchResponse searchResponse = new SearchResponse(new ArrayList<>(), 10, true);

        Single<SearchResponse> searchResponseSingle = Single.just(searchResponse);

        doReturn(searchResponseSingle).when(retrofitService).getMovies(searchText, BuildConfig.API_KEY);

        assertEquals(retrofitApiManager.getMoviesList(searchText),searchResponseSingle);
    }
}