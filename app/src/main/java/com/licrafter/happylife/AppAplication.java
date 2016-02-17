package com.licrafter.happylife;

import android.app.Application;


/**
 * Created by Administrator on 2016/2/11.
 */
public class AppAplication extends Application {

    public static boolean debug = true;

    @Override
    public void onCreate() {
        super.onCreate();
 //       initializeInjector();
    }

//    private void initializeInjector() {
//        appComponent = DaggerAppComponent.builder()
//                .appModule(new AppModule(this))
//                .build();
//    }

//    public AppComponent getAppComponent() {
//  //      appComponent.appAplication();
//        return appComponent;
//    }
}
