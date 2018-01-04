package com.christianbahl.conductor.dagger.sample;

import com.christianbahl.conductor.dagger.sample.dependencies.ApplicationDependency;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
abstract class ApplicationModule {

    @Provides
    @Singleton
    static ApplicationDependency applicationDependency(App app) {
        return new ApplicationDependency(app);
    }
}
