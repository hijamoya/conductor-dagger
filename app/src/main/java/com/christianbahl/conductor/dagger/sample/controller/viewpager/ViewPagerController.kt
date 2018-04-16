package com.christianbahl.conductor.dagger.sample.controller.viewpager

import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.support.RouterPagerAdapter
import com.christianbahl.conductor.HasControllerInjector
import com.christianbahl.conductor.dagger.sample.R
import com.christianbahl.conductor.dagger.sample.controller.MyController
import com.christianbahl.conductor.dagger.sample.dependencies.ActivityDependency
import com.christianbahl.conductor.dagger.sample.dependencies.ApplicationDependency
import com.christianbahl.conductor.dagger.sample.dependencies.ViewPagerDependency
import com.christianbahl.viewpager.PagerController
import com.christianbahl.viewpager.PagerControllerInjection
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class ViewPagerController : PagerController(), HasControllerInjector {

    private lateinit var viewPager: ViewPager
    override fun viewPager(): ViewPager = viewPager

    @Inject lateinit var activityDependency: ActivityDependency
    @Inject lateinit var viewPagerDependency: ViewPagerDependency
    @Inject lateinit var applicationDependency: ApplicationDependency
    @Inject lateinit var dispatchingControllerInjector: DispatchingAndroidInjector<Controller>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        PagerControllerInjection.inject(this)
        val view =  inflater.inflate(R.layout.pager_w_tabs, container, false)

        val tabs = view.findViewById<TabLayout>(R.id.tab_layout)
        viewPager = view.findViewById(R.id.view_pager)

        viewPager.adapter = object: RouterPagerAdapter(this) {
            override fun configureRouter(router: Router, position: Int) {
                if (!router.hasRootController()) {
                    router.setRoot(RouterTransaction.with(MyController()))
                }
            }

            override fun getCount(): Int = 4
        }
        tabs.setupWithViewPager(viewPager)

        return view
    }

    override fun controllerInjector(): DispatchingAndroidInjector<Controller> {
        return dispatchingControllerInjector
    }
}