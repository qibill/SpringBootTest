package com.qibill.common.utils;

import com.qibill.annotation.FieldName;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 反射工具类
 * @author: qibill
 * @date: 2018/12/4 11:22
 **/
public class ReflectUtil {

    private static final Logger LOGGER = Logger.getLogger(ReflectUtil.class);

    /**
     * 公用事业类不应该有公共构造函数
     */
    private ReflectUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> Object getFiledValue(T t, String filedName) {
        Class<?> clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!field.getName().equals(filedName)) {
                continue;
            }
            field.setAccessible(true);
            Object filedValue = null;
            try {
                filedValue = field.get(t);
            } catch (IllegalAccessException e) {
                LOGGER.error("非法访问", e);
            }
            return filedValue;
        }
        throw new IllegalArgumentException("该类没有" + filedName + "属性");
    }

    /**
     * @param t1
     * @param t2
     * @param filedList
     * @param <T>
     * @return
     */
    public static <T> String contrast(T t1, T t2, List<String> filedList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String filedName : filedList) {

            Object oldValue = ReflectUtil.getFiledValue(t2, filedName);
            Object newValue = ReflectUtil.getFiledValue(t1, filedName);
            if (oldValue != null && !oldValue.equals(newValue)) {
                try {
                    stringBuilder.append('(');
                    stringBuilder.append(getFieldName(t1, filedName));
                    stringBuilder.append(':');
                    stringBuilder.append(oldValue);
                    stringBuilder.append("->");
                    stringBuilder.append(newValue);
                    stringBuilder.append(')');
                } catch (IllegalArgumentException e) {
                    LOGGER.error("该类没有" + filedName + "属性", e);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static <T> String getFieldName(T t, String fieldName) {
        Class<?> clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!field.getName().equals(fieldName)) {
                continue;
            }
            if (field.isAnnotationPresent(FieldName.class)) {
                FieldName fieldNameAnnotation = field.getAnnotation(FieldName.class);
                return fieldNameAnnotation.value();
            } else {
                return field.getName();
            }
        }
        throw new IllegalArgumentException("该类没有" + fieldName + "属性");
    }

    public static List<Field> getField(Object o) {
        List<Field> fieldList = new ArrayList<>();
        Class<?> clazz = o.getClass();
        //当父类为null的时候说明到达了最上层的父类(Object类).
        while (clazz != null) {
            fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
            //得到父类,然后赋给自己
            clazz = clazz.getSuperclass();
        }
        return fieldList;
    }

    public static Field getField(Object o, String fieldName){
        List<Field> fieldList = getField(o);
        for (Field field : fieldList) {
            if (field.getName().equals(fieldName)){
                return field;
            }
        }
        throw new IllegalArgumentException("该类没有" + fieldName + "属性");
    }
}
