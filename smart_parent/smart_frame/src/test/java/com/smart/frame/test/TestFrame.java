package com.smart.frame.test;

import com.smart.frame.helper.ClassHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class TestFrame {
    @Before
    public void init(){

    }
    @Test
    public void test(){
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        Set<Class<?>> serviceClassSet = ClassHelper.getServiceClassSet();
        Set<Class<?>> allClassSet = ClassHelper.getBeanClass();
    }
}
