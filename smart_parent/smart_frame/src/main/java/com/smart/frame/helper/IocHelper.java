package com.smart.frame.helper;

import com.smart.frame.annotation.Inject;
import com.smart.frame.util.ArrayUtil;
import com.smart.frame.util.CollectionUtil;
import com.smart.frame.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手类
 */
public final  class IocHelper {
    static {
        // 获取所有的bean类与bean实列之间的映射关系
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if(CollectionUtil.isNotEmpty(beanMap)){
            for(Map.Entry<Class<?>,Object> beanEntry:beanMap.entrySet()){
                // 从beanMap获取bean类和bean实列
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance=beanEntry.getValue();
                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtil.isNotEmpty(beanFields)){
                    for(Field beanField:beanFields){
                        // 判断当前字段是否带有Inject注解
                        if(beanField.isAnnotationPresent(Inject.class)){
                            // 获取字段类型和实列
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if(beanFieldInstance != null){
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
