package com.christianbahl.viewpager;

import java.util.Map;

import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.Multibinds;

@Module
public abstract class ViewPagerControllerInjectionModule {

  private ViewPagerControllerInjectionModule() {
  }

  @Multibinds
  abstract Map<Class<? extends PagerController>, AndroidInjector.Factory<? extends PagerController>> viewPagerControllerInjectorFactories();
}
