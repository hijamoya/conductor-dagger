package com.christianbahl.conductor.dagger.sample;

import android.app.Activity;

import com.bluelinelabs.conductor.Controller;
import com.christianbahl.conductor.HasControllerInjector;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends android.app.Application implements HasControllerInjector, HasActivityInjector {
    @Inject protected DispatchingAndroidInjector<Controller> dispatchingControllerInjector;
    @Inject protected DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public DispatchingAndroidInjector<Controller> controllerInjector() {
        return dispatchingControllerInjector;
    }

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
