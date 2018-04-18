package com.christianbahl.viewpager;

import android.app.Activity;

import com.bluelinelabs.conductor.Controller;

import dagger.android.DispatchingAndroidInjector;
import dagger.internal.Preconditions;

public class PagerControllerInjection {

    public static void inject(PagerController controller) {
        Preconditions.checkNotNull(controller, "controller was null");
        HasPagerControllerInjector hasPagerControllerInjector = findHasPagerControllerInjector(controller);
        final DispatchingAndroidInjector<PagerController> pagerControllerDispatchingAndroidInjector = hasPagerControllerInjector.pagerControllerInjector();
        pagerControllerDispatchingAndroidInjector.inject(controller);
    }

    private static HasPagerControllerInjector findHasPagerControllerInjector(final PagerController controller) {
        Controller parentController = controller.controller();
        do {
            if ((parentController = parentController.getParentController()) == null) {
                final Activity activity = controller.controller().getActivity();

                if (activity instanceof HasPagerControllerInjector) {
                    return (HasPagerControllerInjector) activity;
                }
            }
        } while (!(parentController instanceof HasPagerControllerInjector));

        return (HasPagerControllerInjector) parentController;
    }
}