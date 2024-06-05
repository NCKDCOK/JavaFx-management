package org.example.service.impl;

import org.example.dao.impl.LoginDaoImpl;
import org.example.entity.User;
import org.example.service.LoginService;

public class LoginServiceImpl implements LoginService {
    @Override
    public void login(String name, String password) {
        LoginDaoImpl loginDao = new LoginDaoImpl();
        User user=loginDao.login(name);

        if (user!=null){
            if (user.getPassword().equals(password)){
                System.out.println("登录成功");
            }else {
                System.out.println("密码错误");
            }
    }
}
}
