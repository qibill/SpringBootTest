package com.qibill.format;


import com.qibill.common.utils.SpringUtil;
import com.qibill.format.MyDateTimeFormat.ISO;
import org.springframework.beans.PropertyAccessException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.format.Formatter;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description:
 * @author: qibill
 * @date: 2018/12/28 11:47
 **/
public class MyDateFormatter implements Formatter<Date> {

    private static final TimeZone UTC = TimeZone.getTimeZone("UTC");

    private static final Map<ISO, String> ISO_PATTERNS;

    static {
        Map<ISO, String> formats = new EnumMap<>(ISO.class);
        formats.put(ISO.DATE, "yyyy-MM-dd");
        formats.put(ISO.TIME, "HH:mm:ss.SSSXXX");
        formats.put(ISO.DATE_TIME, "yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        ISO_PATTERNS = Collections.unmodifiableMap(formats);
    }


    @Nullable
    private String pattern;

    private int style = DateFormat.DEFAULT;

    @Nullable
    private String stylePattern;

    @Nullable
    private ISO iso;

    @Nullable
    private TimeZone timeZone;

    private boolean lenient = false;

    @Nullable
    private String message;


    /**
     * Create a new default MyDateFormatter.
     */
    public MyDateFormatter() {
    }

    /**
     * Create a new MyDateFormatter for the given date pattern.
     */
    public MyDateFormatter(String pattern) {
        this.pattern = pattern;
    }


    /**
     * Set the pattern to use to format date values.
     * <p>If not specified, DateFormat's default style will be used.
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * Set the ISO format used for this date.
     * @param iso the {@link ISO} format
     * @since 3.2
     */
    public void setIso(ISO iso) {
        this.iso = iso;
    }

    /**
     * Set the style to use to format date values.
     * <p>If not specified, DateFormat's default style will be used.
     * @see DateFormat#DEFAULT
     * @see DateFormat#SHORT
     * @see DateFormat#MEDIUM
     * @see DateFormat#LONG
     * @see DateFormat#FULL
     */
    public void setStyle(int style) {
        this.style = style;
    }

    /**
     * Set the two character to use to format date values. The first character used for
     * the date style, the second is for the time style. Supported characters are
     * <ul>
     * <li>'S' = Small</li>
     * <li>'M' = Medium</li>
     * <li>'L' = Long</li>
     * <li>'F' = Full</li>
     * <li>'-' = Omitted</li>
     * <ul>
     * This method mimics the styles supported by Joda-Time.
     * @param stylePattern two characters from the set {"S", "M", "L", "F", "-"}
     * @since 3.2
     */
    public void setStylePattern(String stylePattern) {
        this.stylePattern = stylePattern;
    }

    /**
     * Set the TimeZone to normalize the date values into, if any.
     */
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * Specify whether or not parsing is to be lenient. Default is false.
     * <p>With lenient parsing, the parser may allow inputs that do not precisely match the format.
     * With strict parsing, inputs must match the format exactly.
     */
    public void setLenient(boolean lenient) {
        this.lenient = lenient;
    }

    public void setMessage(@Nullable String message) {
        this.message = message;
    }

    @Override
    public String print(Date date, Locale locale) {
        return getDateFormat(locale).format(date);
    }

    @Override
    public Date parse(String text, Locale locale) {
        Date parse;
        try {
            parse = getDateFormat(locale).parse(text);
        }catch (IllegalArgumentException | ParseException e){
            return new Date(0);
        }
        return parse;
    }


    protected DateFormat getDateFormat(Locale locale) {
        DateFormat dateFormat = createDateFormat(locale);
        if (this.timeZone != null) {
            dateFormat.setTimeZone(this.timeZone);
        }
        dateFormat.setLenient(this.lenient);
        return dateFormat;
    }

    private DateFormat createDateFormat(Locale locale) {
        if (StringUtils.hasLength(this.pattern)) {
            return new SimpleDateFormat(this.pattern, locale);
        }
        if (this.iso != null && this.iso != ISO.NONE) {
            String pattern = ISO_PATTERNS.get(this.iso);
            if (pattern == null) {
                throw new IllegalStateException("Unsupported ISO format " + this.iso);
            }
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            format.setTimeZone(UTC);
            return format;
        }
        if (StringUtils.hasLength(this.stylePattern)) {
            int dateStyle = getStylePatternForChar(0);
            int timeStyle = getStylePatternForChar(1);
            if (dateStyle != -1 && timeStyle != -1) {
                return DateFormat.getDateTimeInstance(dateStyle, timeStyle, locale);
            }
            if (dateStyle != -1) {
                return DateFormat.getDateInstance(dateStyle, locale);
            }
            if (timeStyle != -1) {
                return DateFormat.getTimeInstance(timeStyle, locale);
            }
            throw new IllegalStateException("Unsupported style pattern '" + this.stylePattern + "'");

        }
        return DateFormat.getDateInstance(this.style, locale);
    }

    private int getStylePatternForChar(int index) {
        if (this.stylePattern != null && this.stylePattern.length() > index) {
            switch (this.stylePattern.charAt(index)) {
                case 'S': return DateFormat.SHORT;
                case 'M': return DateFormat.MEDIUM;
                case 'L': return DateFormat.LONG;
                case 'F': return DateFormat.FULL;
                case '-': return -1;
            }
        }
        throw new IllegalStateException("Unsupported style pattern '" + this.stylePattern + "'");
    }

}
