package com.christianbahl.conductor.dagger.sample.di.component;

import com.christianbahl.conductor.dagger.sample.controller.viewpager.ViewPagerController;
import com.christianbahl.conductor.dagger.sample.di.binder.ControllersUnderPagerBindingModule;
import com.christianbahl.conductor.dagger.sample.di.module.ViewPagerModule;
import com.christianbahl.conductor.dagger.sample.di.scope.ViewPagerScope;
import com.christianbahl.viewpager.ViewPagerControllerInjectionModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ViewPagerScope
@Subcomponent(modules = {
        ViewPagerModule.class,

        ControllersUnderPagerBindingModule.class,

        ViewPagerControllerInjectionModule.class
})
public interface ViewPagerControllerComponent extends AndroidInjector<ViewPagerController> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ViewPagerController> {
    }
}