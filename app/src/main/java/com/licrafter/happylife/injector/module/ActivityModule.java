package com.licrafter.happylife.injector.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/2/11.
 */
//@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    //@Provides @com.licrafter.happylife.injector.Activity
    Activity provideActivity() {
        return activity;
    }
}
