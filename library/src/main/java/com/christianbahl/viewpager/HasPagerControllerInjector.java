package com.christianbahl.viewpager;

import dagger.android.DispatchingAndroidInjector;

public interface HasPagerControllerInjector {
    DispatchingAndroidInjector<PagerController> pagerControllerInjector();
}