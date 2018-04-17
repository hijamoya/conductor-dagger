package com.christianbahl.conductor.dagger.sample.controller.viewpager;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.christianbahl.conductor.ConductorInjection;
import com.christianbahl.conductor.dagger.sample.R;
import com.christianbahl.conductor.dagger.sample.controller.DetailViewController;
import com.christianbahl.conductor.dagger.sample.dependencies.ActivityDependency;
import com.christianbahl.conductor.dagger.sample.dependencies.ApplicationDependency;
import com.christianbahl.conductor.dagger.sample.dependencies.ControllerDependency;
import com.christianbahl.conductor.dagger.sample.dependencies.ViewPagerDependency;

import javax.inject.Inject;

public class MyController extends Controller {

    @Inject ApplicationDependency applicationDependency;
    @Inject ActivityDependency activityDependency;

    // This controller is under the viewpager so
    @Inject ViewPagerDependency viewPagerDependency;
    @Inject ControllerDependency controllerDependency;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        ConductorInjection.inject(this);
        View rootView = layoutInflater.inflate(R.layout.controller_layout, viewGroup, false);
        rootView.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                getRouter().pushController(RouterTransaction.with(new DetailViewController()));
            }
        });
        return rootView;
    }
}