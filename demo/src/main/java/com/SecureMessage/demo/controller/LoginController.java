package com.SecureMessage.demo.controller;

import com.SecureMessage.demo.bo.UserBo;
import com.SecureMessage.demo.model.userDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private GenerateQueryList gq;

    @Autowired
    private UserBo userBo;
    @RequestMapping("/")
    public String home(){
        return "hello world";
    }
    @RequestMapping("/login")
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String pwd, HttpSession httpSession){
        if (username == null){
            return "fail";
        }
        userDetailDao user = userBo.getUserByName(username);
        if (null == user){
            return "fail";
        }
        if (user.getPassword().equals(pwd)){
            return "chatroom";
        }
        return "fail";
    }





}
