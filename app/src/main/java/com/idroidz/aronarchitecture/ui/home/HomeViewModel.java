package com.idroidz.aronarchitecture.ui.home;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.idroidz.aronarchitecture.data.DataManager;
import com.idroidz.aronarchitecture.data.model.api.SearchResponse;
import com.idroidz.aronarchitecture.ui.base.BaseViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends BaseViewModel<HomeActions> {
    private static final String TAG = "HomeViewModel";

    public HomeViewModel(@NonNull Application application, DataManager dataManager) {
        super(application, dataManager);
    }

    public void getMoviesList(String searchText) {
        getCompositeDisposable().add(getDataManager().getMoviesList(searchText).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<SearchResponse>() {
                    @Override
                    public void onSuccess(SearchResponse movieResponse) {
                        if (movieResponse.isSuccess()) {
                            getNavigator().setData(movieResponse.getMoviesList());
                        } else {
                            getNavigator().handleError();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: ", e);
                        getNavigator().handleError();
                    }
                }));
    }
}
