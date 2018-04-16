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
import com.christianbahl.conductor.dagger.sample.R
import com.christianbahl.conductor.dagger.sample.controller.MyController

class ViewPagerController : Controller() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        //ConductorInjection.inject(this)
        val view =  inflater.inflate(R.layout.pager_w_tabs, container, false)

        val tabs = view.findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = view.findViewById<ViewPager>(R.id.view_pager)

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
}