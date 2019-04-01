package com.smart.module1.test;


import com.smart.module1.module.TsUser;
import com.smart.module1.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.util.List;

public class UserTest {
    private final UserService userService;
    public UserTest(){
        userService = new UserService();
    }
    @Before
    public void init(){

    }
    @Test
    public void getUserinf(){
        List<TsUser> users = userService.getUsers();
        Assert.assertNotNull(users);
    }
}
