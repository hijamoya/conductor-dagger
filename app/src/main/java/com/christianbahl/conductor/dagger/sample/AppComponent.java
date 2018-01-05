package com.christianbahl.conductor.dagger.sample;

import com.christianbahl.conductor.dagger.sample.di.binder.ActivityBindingModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AppModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class
})
interface AppComponent extends AndroidInjector<App> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {}
}