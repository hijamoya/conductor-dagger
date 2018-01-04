package com.christianbahl.conductor.dagger.sample.controller;

import com.christianbahl.conductor.dagger.sample.di.scope.ControllerScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ControllerScope
@Subcomponent(modules = {ControllerModule.class})
public interface ControllerComponent extends AndroidInjector<MyController> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MyController> {}
}