package com.christianbahl.conductor.dagger.sample.di.binder;

import com.christianbahl.conductor.dagger.sample.controller.viewpager.ViewPagerController;
import com.christianbahl.conductor.dagger.sample.di.component.ViewPagerControllerComponent;
import com.christianbahl.viewpager.PagerController;
import com.christianbahl.viewpager.PagerControllerKey;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        ViewPagerControllerComponent.class
})
public abstract class PagerControllerBindingModule {

    @Binds
    @IntoMap
    @PagerControllerKey(ViewPagerController.class)
    abstract AndroidInjector.Factory<? extends PagerController> bind(ViewPagerControllerComponent.Builder builder);

}