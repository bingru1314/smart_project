package com.smart.frame;

import com.smart.frame.helper.BeanHelper;
import com.smart.frame.helper.ClassHelper;
import com.smart.frame.helper.ControllerHelper;
import com.smart.frame.helper.IocHelper;
import com.smart.frame.util.ClassUtil;

/**
 * 加载相应的helper类
 * @version 1.0
 */
public final class HelperLoader {
    public static void init(){
        Class<?>[] classList = {ClassHelper.class, BeanHelper.class, IocHelper.class, ControllerHelper.class};
        for(Class<?> cls:classList){
            ClassUtil.loadClass(cls.getName(),true);
        }
    }
}
