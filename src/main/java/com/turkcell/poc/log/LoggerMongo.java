package com.turkcell.poc.log;

import com.turkcell.poc.enums.RequestTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggerMongo {
    RequestTypeEnum requestType();
}
