package com.christianbahl.conductor.dagger.sample.di.binder;

import com.bluelinelabs.conductor.Controller;
import com.christianbahl.conductor.ControllerKey;
import com.christianbahl.conductor.dagger.sample.di.component.ControllerComponent;
import com.christianbahl.conductor.dagger.sample.controller.MyController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ControllerComponent.class})
public abstract class ControllerBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(MyController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindHomeControllerInjectorFactory(ControllerComponent.Builder builder);

}