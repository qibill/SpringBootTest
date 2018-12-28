package com.qibill.format;


import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
public @interface MyDateTimeFormat {

    String message() default "{com.qibill.format.MyDateTimeFormat.message}";

    String style() default "SS";

    ISO iso() default ISO.NONE;

    String pattern() default "";


    enum ISO {

        /**
         * The most common ISO Date Format {@code yyyy-MM-dd},
         * e.g. "2000-10-31".
         */
        DATE,

        /**
         * The most common ISO Time Format {@code HH:mm:ss.SSSZ},
         * e.g. "01:30:00.000-05:00".
         */
        TIME,

        /**
         * The most common ISO DateTime Format {@code yyyy-MM-dd'T'HH:mm:ss.SSSZ},
         * e.g. "2000-10-31T01:30:00.000-05:00".
         * <p>This is the default if no annotation value is specified.
         */
        DATE_TIME,

        /**
         * Indicates that no ISO-based format pattern should be applied.
         */
        NONE
    }

}
