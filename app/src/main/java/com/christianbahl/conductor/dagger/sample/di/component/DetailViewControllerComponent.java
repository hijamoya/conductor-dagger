package com.christianbahl.conductor.dagger.sample.di.component;

import com.christianbahl.conductor.dagger.sample.controller.DetailViewController;
import com.christianbahl.conductor.dagger.sample.di.module.DetailViewControllerModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {DetailViewControllerModule.class})
public interface DetailViewControllerComponent extends AndroidInjector<DetailViewController> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DetailViewController> { }
}