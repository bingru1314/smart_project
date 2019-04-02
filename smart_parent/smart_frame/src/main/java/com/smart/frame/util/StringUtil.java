package com.smart.frame.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 * @version 1.0
 */
public final class StringUtil {
    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str != null){
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    /**
     * 根据字符分割字符串
     * @param str
     * @param separt
     * @return
     */
    public static String[] splitString(String str,String separt){
        return StringUtils.split(str,separt);
    }
}
