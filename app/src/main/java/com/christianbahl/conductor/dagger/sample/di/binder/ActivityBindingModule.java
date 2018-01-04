package com.christianbahl.conductor.dagger.sample.di.binder;

import com.christianbahl.conductor.dagger.sample.activity.MainActivity;
import com.christianbahl.conductor.dagger.sample.activity.MainActivityModule;
import com.christianbahl.conductor.dagger.sample.di.scope.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class, ControllerBindingModule.class})
    abstract MainActivity mainActivity();
}
