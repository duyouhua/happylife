package com.licrafter.happylife.injector.module;

import com.licrafter.happylife.AppAplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/2/11.
 */
//@Module
public class AppModule {

    private final AppAplication appAplication;

    public AppModule(AppAplication aplication) {
        this.appAplication = aplication;
    }

    //@Provides @Singleton
    AppAplication providesAplication() {
        return this.appAplication;
    }


}
