package com.smart.frame.test;

import com.smart.frame.bean.Handler;
import com.smart.frame.helper.ClassHelper;
import com.smart.frame.helper.ControllerHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    @Test
    public void testm() throws InvocationTargetException {
        Class<?> aClass = null;
        try {
            aClass = Class.forName("com.smart.frame.test.Test");
            Method[] methods = aClass.getDeclaredMethods();
            Object invoke = methods[0].invoke(aClass.newInstance(),"hellow");
            System.out.println(invoke);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
