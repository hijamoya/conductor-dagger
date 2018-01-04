package com.christianbahl.conductor.dagger.sample.di.binder;

import com.christianbahl.conductor.dagger.sample.activity.MainActivity;
import com.christianbahl.conductor.dagger.sample.activity.MainActivityModule;
import com.christianbahl.conductor.dagger.sample.di.scope.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module //(subcomponents = {ControllerComponent.class})
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    @ActivityScope
    abstract MainActivity mainActivity();
}
