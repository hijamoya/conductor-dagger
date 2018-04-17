package com.christianbahl.conductor.dagger.sample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.christianbahl.conductor.HasControllerInjector;
import com.christianbahl.conductor.dagger.sample.R;
import com.christianbahl.conductor.dagger.sample.controller.viewpager.ViewPagerController;
import com.christianbahl.conductor.dagger.sample.dependencies.ActivityDependency;
import com.christianbahl.conductor.dagger.sample.dependencies.ApplicationDependency;
import com.christianbahl.conductor.dagger.sample.dependencies.DependencyThatCanBeReplacedUnderTest;
import com.christianbahl.viewpager.HasPagerControllerInjector;
import com.christianbahl.viewpager.PagerController;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;

public class MainActivity extends AppCompatActivity implements HasPagerControllerInjector, HasControllerInjector {

  private Router router;

  @Inject ApplicationDependency applicationDependency;
  @Inject ActivityDependency activityDependency;
  @Inject DispatchingAndroidInjector<PagerController> dispatchingViewPagerControllerInjector;
  @Inject DispatchingAndroidInjector<Controller> dispatchingControllerInjector;
  @Inject DependencyThatCanBeReplacedUnderTest dependencyThatCanBeReplacedUnderTest;

  @Override protected void onCreate(Bundle savedInstanceState) {
    AndroidInjection.inject(this);
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    ViewGroup container = findViewById(R.id.controller_container);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    getSupportActionBar().setTitle(dependencyThatCanBeReplacedUnderTest.getAppTitle());

    router = Conductor.attachRouter(this, container, savedInstanceState);
    if (!router.hasRootController()) {
      router.setRoot(RouterTransaction.with(new ViewPagerController()));
    }
  }

  @Override public void onBackPressed() {
    if (!router.handleBack()) {
      super.onBackPressed();
    }
  }

  @Override
  public DispatchingAndroidInjector<PagerController> pagerControllerInjector() {
    return dispatchingViewPagerControllerInjector;
  }

  @Override
  public DispatchingAndroidInjector<Controller> controllerInjector() {
    return dispatchingControllerInjector;
  }
}