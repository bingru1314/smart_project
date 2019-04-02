package com.smart.module1.service;

import com.smart.frame.annotation.Service;
import com.smart.module1.dbhelper.DatabaseHelper;
import com.smart.module1.module.TsUser;

import java.util.List;
@Service
public class UserService {
    public List<TsUser> getUsers(){
        String sql = "select * from ts_user";
        List<TsUser> users = DatabaseHelper.queryEntityList(TsUser.class,sql);
        return users;
    }
}
