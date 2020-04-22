package com.ally.util;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ArchivesLog {

	/**
     * 操作说明
     */
	public String operteContent() default "";
}
