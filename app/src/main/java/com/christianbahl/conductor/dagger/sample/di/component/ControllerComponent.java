package com.christianbahl.conductor.dagger.sample.di.component;

import com.christianbahl.conductor.dagger.sample.controller.MyController;
import com.christianbahl.conductor.dagger.sample.di.module.ControllerModule;
import com.christianbahl.conductor.dagger.sample.di.scope.ControllerScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ControllerScope
@Subcomponent(modules = {ControllerModule.class})
public interface ControllerComponent extends AndroidInjector<MyController> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MyController> {}
}