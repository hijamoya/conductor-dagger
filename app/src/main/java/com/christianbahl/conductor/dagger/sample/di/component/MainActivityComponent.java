package com.christianbahl.conductor.dagger.sample.di.component;

import com.christianbahl.conductor.ConductorInjectionModule;
import com.christianbahl.conductor.dagger.sample.activity.MainActivity;
import com.christianbahl.conductor.dagger.sample.di.binder.PagerControllerBindingModule;
import com.christianbahl.conductor.dagger.sample.di.binder.RootControllerBindingModule;
import com.christianbahl.conductor.dagger.sample.di.module.MainActivityModule;
import com.christianbahl.conductor.dagger.sample.di.scope.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules = {
        MainActivityModule.class,

        PagerControllerBindingModule.class,
        RootControllerBindingModule.class,

        ConductorInjectionModule.class
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
}