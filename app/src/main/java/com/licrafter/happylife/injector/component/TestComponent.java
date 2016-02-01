package com.licrafter.happylife.injector.component;

import com.licrafter.happylife.MainActivity;

import dagger.Component;

/**
 * Created by Administrator on 2016/2/4.
 */
@Component(modules = {com.licrafter.happylife.injector.module.TestModule.class})
public interface TestComponent {

    void inject(MainActivity mainActivity);
}
