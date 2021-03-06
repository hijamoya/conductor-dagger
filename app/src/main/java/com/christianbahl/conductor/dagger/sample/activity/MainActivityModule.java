package com.christianbahl.conductor.dagger.sample.activity;

import com.christianbahl.conductor.dagger.sample.dependencies.ActivityDependency;
import com.christianbahl.conductor.dagger.sample.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    @Provides
    @ActivityScope
    static ActivityDependency activityDependency(MainActivity activity) {
        return new ActivityDependency(activity);
    }
}
