package com.yang.learn.multisource1.anotions;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default DataSource.source1;
    public static String source1 = "source1";
    public static String source2 = "source2";
}
