package controller;

import cn.hutool.core.util.StrUtil;
import service.LoginService;

import java.io.IOException;

public class LoginController {

    private LoginService loginService = new LoginService();
    //authorize the users
    public String doLogin(String stuId, String pwd) {
        if (StrUtil.isBlank(stuId)) {
            return "Stu ID can not be empty or null";
        }
        if (StrUtil.isBlank(pwd)) {
            return "Password can not be empty or null";
        }
        String ret = "";
        //call the method in Service layer which contains business logic
        try {
            ret = loginService.doLogin(stuId, pwd);
            if (StrUtil.isBlank(ret)) {
                // store login info
                util.LoginUtil.setLoginUser(stuId);
            }
        } catch (IOException e) {
            e.printStackTrace();
            ret = "Server has some fault";
        }
        return ret;
    }


}
