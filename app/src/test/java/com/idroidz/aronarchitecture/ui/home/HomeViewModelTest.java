package com.idroidz.aronarchitecture.ui.home;

import android.app.Application;

import com.idroidz.aronarchitecture.RxImmediateSchedulerRule;
import com.idroidz.aronarchitecture.data.DataManager;
import com.idroidz.aronarchitecture.data.model.api.SearchResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import io.reactivex.Single;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HomeViewModelTest {
    @ClassRule
    public static final RxImmediateSchedulerRule schedulers = new RxImmediateSchedulerRule();
    @Mock
    HomeActions mHomeActions;
    @Mock
    DataManager mMockDataManager;
    @Mock
    Application application;

    private HomeViewModel mHomeViewModel;


    @Before
    public void setUp() throws Exception {
        mHomeViewModel = new HomeViewModel(application, mMockDataManager);
        mHomeViewModel.setNavigator(mHomeActions);
    }

    @After
    public void tearDown() throws Exception {
        mHomeViewModel = null;
        mHomeActions = null;
    }

    @Test
    public void getMoviesList_success_response() {

        String searchText = "Iron";
        SearchResponse searchResponse = new SearchResponse(new ArrayList<>(),10,true);

        doReturn(Single.just(searchResponse)).when(mMockDataManager).getMoviesList(searchText);

        mHomeViewModel.getMoviesList(searchText);

        verify(mHomeActions).setData(searchResponse.getMoviesList());
    }

    @Test
    public void getMoviesList_success_data_failure_response() {

        String searchText = "Iron";
        SearchResponse searchResponse = new SearchResponse(new ArrayList<>(),10,false);

        doReturn(Single.just(searchResponse)).when(mMockDataManager).getMoviesList(searchText);

        mHomeViewModel.getMoviesList(searchText);

        verify(mHomeActions).handleError();
    }

    @Test
    public void getMoviesList_failure_response() {

        String searchText = "Iron";

        doReturn(Single.error(new Exception())).when(mMockDataManager).getMoviesList(searchText);

        mHomeViewModel.getMoviesList(searchText);

        verify(mHomeActions).handleError();
    }
}