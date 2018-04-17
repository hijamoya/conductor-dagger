package com.christianbahl.conductor.dagger.sample.controller

import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.christianbahl.conductor.ConductorInjection
import com.christianbahl.conductor.dagger.sample.R
import com.christianbahl.conductor.dagger.sample.dependencies.ActivityDependency
import com.christianbahl.conductor.dagger.sample.dependencies.ApplicationDependency
import javax.inject.Inject

class DetailViewController: Controller() {

    @Inject lateinit var activityDependency: ActivityDependency
    @Inject lateinit var applicationDependency: ApplicationDependency

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        ConductorInjection.inject(this)
        return inflater.inflate(R.layout.controller_layout, container, false).apply {
            setBackgroundColor(ContextCompat.getColor(this@DetailViewController.activity!!, R.color.colorAccent))
        }
    }
}