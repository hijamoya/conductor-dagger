package com.christianbahl.conductor.dagger.sample.activity

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.Toolbar
import com.christianbahl.conductor.dagger.sample.App
import com.christianbahl.conductor.dagger.sample.R
import com.christianbahl.conductor.dagger.sample.dependencies.DependencyThatCanBeReplacedUnderTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityTestRule = object : ActivityTestRule<MainActivity>(MainActivity::class.java, true, true) {
        override fun beforeActivityLaunched() {
            super.beforeActivityLaunched()
            val myApp = InstrumentationRegistry.getTargetContext().applicationContext as App
            myApp.dispatchingActivityInjector = createFakeActivityInjector<MainActivity> {
                dependencyThatCanBeReplacedUnderTest = DependencyThatCanBeReplacedUnderTest { "Mock" }

            }
        }
    }

    @Test
    @Throws(Exception::class)
    fun checkIfTitleIsMock() {
        onView(withId(R.id.toolbar)).check({ view, _ ->
            assert((view as Toolbar).title == "Mock")
        })
    }
}