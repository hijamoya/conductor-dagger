package com.christianbahl.conductor.dagger.sample.activity;

import com.christianbahl.conductor.dagger.sample.dependencies.ActivityDependency;
import com.christianbahl.conductor.dagger.sample.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainActivityModule {
    @Provides
    @ActivityScope
    static ActivityDependency activityDependency(MainActivity activity) {
        return new ActivityDependency(activity);
    }
}
