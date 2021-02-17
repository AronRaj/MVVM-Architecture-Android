package com.idroidz.aronarchitecture;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.idroidz.aronarchitecture.data.DataManager;
import com.idroidz.aronarchitecture.ui.home.HomeViewModel;

import javax.inject.Inject;


public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private final Application application;
    private final DataManager dataManager;

    @Inject
    public ViewModelProviderFactory(Application application, DataManager dataManager) {
        this.application = application;
        this.dataManager = dataManager;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(application,dataManager);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}