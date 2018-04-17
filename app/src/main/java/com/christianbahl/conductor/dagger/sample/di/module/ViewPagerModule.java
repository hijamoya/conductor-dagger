package com.christianbahl.conductor.dagger.sample.di.module;

import android.support.annotation.NonNull;

import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.support.RouterPagerAdapter;
import com.christianbahl.conductor.dagger.sample.controller.viewpager.MyController;
import com.christianbahl.conductor.dagger.sample.controller.viewpager.ViewPagerController;
import com.christianbahl.conductor.dagger.sample.dependencies.ViewPagerDependency;
import com.christianbahl.conductor.dagger.sample.di.scope.ViewPagerScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewPagerModule {

    @Provides
    @ViewPagerScope
    ViewPagerDependency viewPagerDependency() {
        return new ViewPagerDependency();
    }

    @Provides
    @ViewPagerScope
    RouterPagerAdapter routerPagerAdapter(ViewPagerController viewPagerController) {
        return new RouterPagerAdapter(viewPagerController) {
            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public void configureRouter(@NonNull final Router router, final int position) {
                if (!router.hasRootController()) {
                    router.setRoot(RouterTransaction.with(new MyController()));
                }
            }
        };
    }
}
