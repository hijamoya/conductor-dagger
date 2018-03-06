package com.christianbahl.conductor.dagger.sample;

import android.app.Activity;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends android.app.Application implements HasActivityInjector {
    @Inject public DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent
                .builder()
                .create(this)
                .inject(this);
    }
}
