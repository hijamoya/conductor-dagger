package com.christianbahl.conductor.dagger.sample.dependencies;

import android.app.Activity;

public class ActivityDependency {

    private final Activity activity;

    public ActivityDependency(Activity activity) {
        this.activity = activity;
    }
}
