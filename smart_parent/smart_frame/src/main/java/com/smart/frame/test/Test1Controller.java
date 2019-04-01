package com.smart.frame.test;

import com.smart.frame.annotation.Action;
import com.smart.frame.annotation.Controller;

@Controller
public class Test1Controller {
    @Action("post:/test1")
    public void test1(){

    }
}
