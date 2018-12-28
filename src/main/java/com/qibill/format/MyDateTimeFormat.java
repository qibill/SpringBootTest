package com.qibill.format;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import com.qibill.format.MyDateTimeFormat.List;


import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Repeatable(List.class)
@Constraint(validatedBy = MyDateTimeFormatValidator.class)
@Documented
@Retention(RUNTIME)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
public @interface MyDateTimeFormat {

    String message() default "{com.qibill.format.MyDateTimeFormat.message}";

    String style() default "SS";

    ISO iso() default ISO.NONE;

    String pattern() default "";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Documented
    @interface List {

        MyDateTimeFormat[] value();
    }
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
