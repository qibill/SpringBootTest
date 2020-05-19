package com.qibill.common.utils;

import java.math.BigDecimal;

/**
 *
 * @author qibill
 * @date 2018/12/4 17:36
 **/
public class MathUtil {

    /**
     * 公用事业类不应该有公共构造函数
     */
    private MathUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static BigDecimal stringToBigDecimal(String str){
        if (str == null || "".equals(str.trim())){
            return null;
        }
        return new BigDecimal(str);
    }

    public static Short stringToShort(String str){
        if (str == null || "".equals(str)){
            return null;
        }
        return new Short(str);
    }

    public static Integer stringToInteger(String str){
        if (str == null || "".equals(str)){
            return null;
        }
        return new Integer(str);
    }

}
