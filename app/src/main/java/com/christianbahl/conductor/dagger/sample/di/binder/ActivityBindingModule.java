package com.christianbahl.conductor.dagger.sample.di.binder;

import android.app.Activity;

import com.christianbahl.conductor.dagger.sample.activity.MainActivity;
import com.christianbahl.conductor.dagger.sample.di.component.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MainActivityComponent.class})
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindYourActivityInjectorFactory(MainActivityComponent.Builder builder);
}