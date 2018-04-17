package com.christianbahl.conductor.dagger.sample.di.binder;

import com.bluelinelabs.conductor.Controller;
import com.christianbahl.conductor.ControllerKey;
import com.christianbahl.conductor.dagger.sample.controller.MyController;
import com.christianbahl.conductor.dagger.sample.di.component.MyControllerComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        MyControllerComponent.class
})
public abstract class ControllersUnderPagerBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(MyController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindHomeControllerInjectorFactory(MyControllerComponent.Builder builder);
}
