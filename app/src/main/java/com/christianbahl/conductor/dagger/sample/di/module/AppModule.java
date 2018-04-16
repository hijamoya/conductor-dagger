package com.christianbahl.conductor.dagger.sample.di.module;

import com.christianbahl.conductor.dagger.sample.App;
import com.christianbahl.conductor.dagger.sample.dependencies.ApplicationDependency;
import com.christianbahl.conductor.dagger.sample.dependencies.DependencyThatCanBeReplacedUnderTest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class AppModule {

    @Provides
    @Singleton
    static ApplicationDependency applicationDependency(App app) {
        return new ApplicationDependency(app);
    }

    @Provides
    static DependencyThatCanBeReplacedUnderTest dependencyThatCanBeReplacedUnderTest() {
        return new DependencyThatCanBeReplacedUnderTest() {
            @Override
            public String getAppTitle() {
                return "Production Title";
            }
        };
    }
}