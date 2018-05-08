package com.lcc.concurrent.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 用来标记线程不安全的类或者写法
 *
 * @author: lcc
 * @Date: 2018-05-08
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotThreadSafe {

	String value() default "";
}
