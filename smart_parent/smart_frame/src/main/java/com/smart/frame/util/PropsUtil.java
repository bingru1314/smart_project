package com.smart.frame.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 属性文件工具类
 * @version 1.0
 */
public class PropsUtil {
    private static final Logger log = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     * @param fileName
     * @return
     */
    public static Properties loadProps(String fileName){
        Properties properties = null;
        InputStream is = null;
        try {
            is=Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(is == null){
                throw new FileNotFoundException(fileName+"file is not found");
            }
            properties = new Properties();
            properties.load(is);
        }catch (IOException e){
            log.error("load properties file failure",e);
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    log.error("close input stream failure",e);
                }

            }
        }

        return properties;
    }

    /**
     * 获取字符型属性
     * @param props
     * @param key
     * @return
     */
    public static String getString(Properties props,String key){
        return getString(props,key,"");
    }

    /**
     * 获取字符型属性（可以指定默认值）
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties props,String key,String defaultValue){
        String value = defaultValue;
        if(props.containsKey(key)){
            value = props.getProperty(key);
        }
        return value;
    }

    /**
     * 获取数值型属性
     * @param props
     * @param key
     * @return
     */
    public static int getInt(Properties props,String key){
        return getInt(props,key,0);
    }

    /**
     * 获取数值型属性（可指定默认值）
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getInt(Properties props,String key,int defaultValue){
        int value = defaultValue;
        if(props.containsKey(key)){
            value = CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }

    /**
     * 获取布尔型属性（默认为false）
     * @param props
     * @param key
     * @return
     */
    public static boolean getBoolean(Properties props,String key){
        return getBoolean(props,key,false);
    }
    /**
     * 获取布尔型属性（可以指定默认值）
     * @param props
     * @param key
     * @return
     */
    public static boolean getBoolean(Properties props,String key,boolean defaultValue){
        boolean value = defaultValue;
        if(props.containsKey(key)){
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }
}
