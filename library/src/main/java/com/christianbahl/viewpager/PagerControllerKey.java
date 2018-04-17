package com.christianbahl.viewpager;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import dagger.MapKey;

@MapKey
@Target({ ElementType.METHOD })
public @interface PagerControllerKey {
    Class<? extends PagerController> value();
}