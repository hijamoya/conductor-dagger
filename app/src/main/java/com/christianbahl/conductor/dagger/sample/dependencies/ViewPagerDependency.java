package com.christianbahl.conductor.dagger.sample.dependencies;

import java.util.Random;

public class ViewPagerDependency {

    private static int randomInt;

    public static int getRandomInt() {
        return randomInt;
    }

    static {
        randomInt = new Random().nextInt();
    }
}
