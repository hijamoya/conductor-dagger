package com.christianbahl.conductor.dagger.sample.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope @Retention(RetentionPolicy.RUNTIME) public @interface ActivityScope {
}
