package com.christianbahl.conductor.dagger.sample.controller;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.christianbahl.conductor.ConductorInjection;
import com.christianbahl.conductor.dagger.sample.R;
import com.christianbahl.conductor.dagger.sample.dependencies.ApplicationDependency;
import com.christianbahl.conductor.dagger.sample.dependencies.ControllerDependency;

import javax.inject.Inject;

public class MyController extends com.bluelinelabs.conductor.Controller {
  @Inject
  ApplicationDependency applicationDependency;
  //@Inject
  //ActivityDependency activityDependency; // can not be provided
  @Inject
  ControllerDependency controllerDependency;

  @NonNull @Override protected View onCreateView(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
    ConductorInjection.inject(this);
    return layoutInflater.inflate(R.layout.controller_main, viewGroup, false);
  }
}
