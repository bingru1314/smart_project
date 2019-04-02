package com.smart.module1.controller;

import com.smart.frame.annotation.Action;
import com.smart.frame.annotation.Controller;
import com.smart.frame.annotation.Inject;
import com.smart.frame.bean.Data;
import com.smart.frame.bean.Param;
import com.smart.frame.bean.View;
import com.smart.module1.module.TsUser;
import com.smart.module1.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    @Inject
    private UserService userService;
    @Action("get:/testCon")
    public Data testCon(Param param){
        List<TsUser> users = userService.getUsers();
        Data data = new Data(users);
        return data;
    }
    @Action("get:/testConv")
    public View testConv(Param param){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("ct","cttt");
        View view = new View("hellow.jsp",map);
        return view;
    }
}
