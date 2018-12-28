package com.qibill.format;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.util.Calendar;
import java.util.Date;

/**
 * @description:
 * @author: qibill
 * @date: 2018/12/28 11:46
 **/
public class MyDateFormatterRegistrar implements FormatterRegistrar {

    @Nullable
    private MyDateFormatter dateFormatter;

    public MyDateFormatterRegistrar() {
        System.out.println("自定义DateFormatterRegistrar");
    }

    @Override
    public void registerFormatters(FormatterRegistry registry) {
        addDateConverters(registry);
        registry.addFormatterForFieldAnnotation(new DateTimeFormatAnnotationFormatterFactory());

        // In order to retain back compatibility we only register Date/Calendar
        // types when a user defined formatter is specified (see SPR-10105)
        if (this.dateFormatter != null) {
            registry.addFormatter(this.dateFormatter);
            registry.addFormatterForFieldType(Calendar.class, this.dateFormatter);
        }
    }

    public void setFormatter(MyDateFormatter dateFormatter) {
        Assert.notNull(dateFormatter, "DateFormatter must not be null");
        this.dateFormatter = dateFormatter;
    }

    public static void addDateConverters(ConverterRegistry converterRegistry) {
        converterRegistry.addConverter(new DateToLongConverter());
        converterRegistry.addConverter(new DateToCalendarConverter());
        converterRegistry.addConverter(new CalendarToDateConverter());
        converterRegistry.addConverter(new CalendarToLongConverter());
        converterRegistry.addConverter(new LongToDateConverter());
        converterRegistry.addConverter(new LongToCalendarConverter());
    }

    private static class DateToLongConverter implements Converter<Date, Long> {

        @Override
        public Long convert(Date source) {
            return source.getTime();
        }
    }


    private static class DateToCalendarConverter implements Converter<Date, Calendar> {

        @Override
        public Calendar convert(Date source) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(source);
            return calendar;
        }
    }


    private static class CalendarToDateConverter implements Converter<Calendar, Date> {

        @Override
        public Date convert(Calendar source) {
            return source.getTime();
        }
    }


    private static class CalendarToLongConverter implements Converter<Calendar, Long> {

        @Override
        public Long convert(Calendar source) {
            return source.getTimeInMillis();
        }
    }


    private static class LongToDateConverter implements Converter<Long, Date> {

        @Override
        public Date convert(Long source) {
            return new Date(source);
        }
    }


    private static class LongToCalendarConverter implements Converter<Long, Calendar> {

        @Override
        public Calendar convert(Long source) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(source);
            return calendar;
        }
    }
}
