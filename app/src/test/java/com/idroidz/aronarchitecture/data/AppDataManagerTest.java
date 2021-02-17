package com.idroidz.aronarchitecture.data;

import com.idroidz.aronarchitecture.RxImmediateSchedulerRule;
import com.idroidz.aronarchitecture.data.model.api.SearchResponse;
import com.idroidz.aronarchitecture.data.remote.ApiManager;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import io.reactivex.Single;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AppDataManagerTest {

    private DataManager dataManager;

    @Mock
    private ApiManager apiManager;

    @Before
    public void setUp() throws Exception {
        dataManager = new AppDataManager(apiManager);
    }

    @After
    public void tearDown() throws Exception {
        dataManager = null;
    }

    @Test
    public void test_getMoviesList() {
        String searchText = "Iron";
        SearchResponse searchResponse = new SearchResponse(new ArrayList<>(), 10, true);

        Single<SearchResponse> searchResponseSingle = Single.just(searchResponse);

        doReturn(searchResponseSingle).when(apiManager).getMoviesList(searchText);

        assertEquals(dataManager.getMoviesList(searchText), searchResponseSingle);
    }
}