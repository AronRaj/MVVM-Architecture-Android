package com.idroidz.aronarchitecture.dagger;



import com.idroidz.aronarchitecture.ui.NavigationActivity;
import com.idroidz.aronarchitecture.ui.home.HomeActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract HomeActivity bindHomeActivity();

    @ContributesAndroidInjector
    abstract NavigationActivity bindNavigationActivity();
}
