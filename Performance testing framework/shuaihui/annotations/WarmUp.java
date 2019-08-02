package com.shuaihui.annotations;

/**
 * 预热
 */
public @interface WarmUp {
    int iterations() default 0;
}
