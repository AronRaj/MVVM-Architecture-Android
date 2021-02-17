package com.idroidz.aronarchitecture.dagger;

import com.idroidz.aronarchitecture.data.AppDataManager;
import com.idroidz.aronarchitecture.data.DataManager;
import com.idroidz.aronarchitecture.data.remote.ApiManager;
import com.idroidz.aronarchitecture.data.remote.RetrofitApiManager;
import com.idroidz.aronarchitecture.data.remote.RetrofitService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.idroidz.aronarchitecture.data.remote.ApiEndPoint.BASE_URL;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public RetrofitService provideRetrofitService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(RetrofitService.class);
    }

    @Provides
    @Singleton
    public DataManager provideDataManager(AppDataManager appDataManager){
        return appDataManager;
    }

    @Provides
    @Singleton
    public ApiManager provideApiManager(RetrofitApiManager retrofitApiManager){
        return retrofitApiManager;
    }
}
