package com.christianbahl.conductor.dagger.sample.dependencies;

import android.app.Application;

public class ApplicationDependency {

    private final Application application;

    public ApplicationDependency(Application application) {
        this.application = application;
    }
}
