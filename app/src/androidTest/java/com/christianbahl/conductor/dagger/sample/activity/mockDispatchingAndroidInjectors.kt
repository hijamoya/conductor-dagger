package com.christianbahl.conductor.dagger.sample.activity

import android.app.Activity
import com.bluelinelabs.conductor.Controller
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.DispatchingAndroidInjector_Factory
import javax.inject.Provider

inline fun <reified T : Activity> createFakeActivityInjector(crossinline block: T.() -> Unit): DispatchingAndroidInjector<Activity> {
    val injector = AndroidInjector<T> { instance ->
        if (instance is T) {
            instance.block()
        }
    }
    val factory = AndroidInjector.Factory<T> { injector }
    val map = mapOf(Pair<Class<out Activity>, Provider<AndroidInjector.Factory<out Activity>>>(T::class.java, Provider { factory }))
    return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(map)
}

inline fun <reified T : Controller> createControllerInjector(crossinline block: T.() -> Unit): DispatchingAndroidInjector<Controller> {
    val injector = AndroidInjector<T> { instance ->
        if (instance is T) {
            instance.block()
        }
    }
    val factory = AndroidInjector.Factory<T> { injector }
    val map = mapOf(Pair<Class<out Controller>, Provider<AndroidInjector.Factory<out Controller>>>(T::class.java, Provider { factory }))
    return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(map)
}