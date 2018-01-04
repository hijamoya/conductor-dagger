package com.christianbahl.conductor.dagger.sample;

import com.christianbahl.conductor.ConductorInjectionModule;
import com.christianbahl.conductor.dagger.sample.di.binder.BindingModule;
import com.christianbahl.conductor.dagger.sample.di.binder.ControllerBindingModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        BindingModule.class,
        AndroidSupportInjectionModule.class,

        ConductorInjectionModule.class,
        ControllerBindingModule.class
})
interface AppComponent extends AndroidInjector<App> {
    @Component.Builder
    abstract class B extends AndroidInjector.Builder<App> {}
}