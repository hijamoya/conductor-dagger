package com.christianbahl.conductor.dagger.sample.di.module;

import com.christianbahl.conductor.dagger.sample.dependencies.ViewPagerDependency;
import com.christianbahl.conductor.dagger.sample.di.scope.ViewPagerScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewPagerModule {

    @Provides
    @ViewPagerScope
    ViewPagerDependency viewPagerDependency() {
        return new ViewPagerDependency();
    }
}
