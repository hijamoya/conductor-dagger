package com.christianbahl.conductor;

import com.bluelinelabs.conductor.Controller;

import java.util.Map;

import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.Multibinds;

@Module
public abstract class ConductorInjectionModule {

  private ConductorInjectionModule() {
  }

  @Multibinds
  abstract Map<Class<? extends Controller>, AndroidInjector.Factory<? extends Controller>> controllerInjectorFactories();
}
