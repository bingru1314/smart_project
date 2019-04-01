package com.smart.frame.helper;

import com.smart.frame.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bean助手类
 */
public final class BeanHelper {
    private static final Map<Class<?>,Object> CLASS_OBJECT_MAP = new HashMap<Class<?>,Object>();
    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClass();
        for(Class<?> cls:beanClassSet){
            CLASS_OBJECT_MAP.put(cls,ReflectionUtil.newInstance(cls));
        }
    }

    /**
     * 获取bean映射
     * @return
     */
    public static Map<Class<?>,Object> getBeanMap(){
        return CLASS_OBJECT_MAP;
    }

    /**
     * 获取bean 实列
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<?> cls){
        if(!CLASS_OBJECT_MAP.containsKey(cls)){
            throw new RuntimeException("can not get bean by class:"+cls);
        }
        return (T) CLASS_OBJECT_MAP.get(cls);
    }
}
