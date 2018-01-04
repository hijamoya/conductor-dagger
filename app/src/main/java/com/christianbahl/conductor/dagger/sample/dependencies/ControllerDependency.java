package com.christianbahl.conductor.dagger.sample.dependencies;

import com.bluelinelabs.conductor.Controller;

public class ControllerDependency {

    private final Controller controller;

    public ControllerDependency(Controller controller) {
        this.controller = controller;
    }
}
