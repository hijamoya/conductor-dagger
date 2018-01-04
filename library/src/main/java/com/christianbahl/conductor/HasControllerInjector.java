package com.christianbahl.conductor;

import com.bluelinelabs.conductor.Controller;
import dagger.android.DispatchingAndroidInjector;

public interface HasControllerInjector {
  DispatchingAndroidInjector<Controller> controllerInjector();
}
