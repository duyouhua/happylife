package com.licrafter.happylife;

import android.app.Application;

import com.licrafter.happylife.injector.component.AppComponent;
import com.licrafter.happylife.injector.component.DaggerAppComponent;
import com.licrafter.happylife.injector.module.AppModule;

/**
 * Created by Administrator on 2016/2/11.
 */
public class AppAplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        appComponent.appAplication();
        return appComponent;
    }
}
