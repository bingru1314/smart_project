package com.smart.frame.test;

import com.smart.frame.bean.Handler;
import com.smart.frame.helper.ClassHelper;
import com.smart.frame.helper.ControllerHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class TestFrame {
    @Before
    public void init(){

    }
    @Test
    public void testClassHelper(){
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        Set<Class<?>> serviceClassSet = ClassHelper.getServiceClassSet();
        Set<Class<?>> allClassSet = ClassHelper.getBeanClass();
        Assert.assertNotNull(allClassSet);
    }
    @Test
    public void testControllerhelper(){
        Handler handler = ControllerHelper.getHandler("post","/test1");
        Assert.assertNotNull(handler);
    }
}
