package com.christianbahl.viewpager;

import android.support.v4.view.ViewPager;

import com.bluelinelabs.conductor.Controller;

public interface PagerController<T extends Controller> {
    ViewPager viewPager();
    T controller();
}