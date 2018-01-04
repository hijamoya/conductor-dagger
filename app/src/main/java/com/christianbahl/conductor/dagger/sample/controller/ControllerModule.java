package com.christianbahl.conductor.dagger.sample.controller;

import com.christianbahl.conductor.dagger.sample.dependencies.ControllerDependency;
import com.christianbahl.conductor.dagger.sample.di.scope.ControllerScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ControllerModule {
    @Provides
    @ControllerScope
    ControllerDependency controllerDependency(MyController myController) {
        return new ControllerDependency(myController);
    }
}