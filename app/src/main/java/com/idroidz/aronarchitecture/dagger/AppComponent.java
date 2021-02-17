package com.idroidz.aronarchitecture.dagger;

import android.app.Application;

import com.idroidz.aronarchitecture.AronApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {ApiModule.class, AndroidInjectionModule.class, ActivityModule.class})
public interface AppComponent {

    void inject(AronApplication app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
