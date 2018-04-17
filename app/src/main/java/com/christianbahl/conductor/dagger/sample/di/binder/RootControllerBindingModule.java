package com.christianbahl.conductor.dagger.sample.di.binder;

import com.bluelinelabs.conductor.Controller;
import com.christianbahl.conductor.ControllerKey;
import com.christianbahl.conductor.dagger.sample.controller.DetailViewController;
import com.christianbahl.conductor.dagger.sample.di.component.DetailViewControllerComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {DetailViewControllerComponent.class})
public abstract class RootControllerBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(DetailViewController.class)
    abstract AndroidInjector.Factory<? extends Controller> bind(DetailViewControllerComponent.Builder builder);
}