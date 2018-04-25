package com.example.myrxjava.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by wenyingzhi on 2018/4/23.
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface LoginSingleton {}
