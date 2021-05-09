package com.SecureMessage.demo.controller;

import com.SecureMessage.demo.bo.UserBo;
import com.SecureMessage.demo.model.userDetailDao;
import com.SecureMessage.demo.requestmodel.UserLogin;
import com.SecureMessage.demo.requestmodel.WriteRequest;
import com.SecureMessage.demo.utils.GenerateQueryListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private HttpServletRequest request;
    @Value("${server.port}")
    Integer port;
    @Autowired
    private GenerateQueryListUtil gq;

    @Value("${app.fakeread}")
    String fakeReadConfig;

    @Autowired
    private UserBo userBo;
    @RequestMapping("/")
    public String home(){
        return "hello world";
    }
    @GetMapping("/get")
    public String get(HttpSession session) {
        return session.getAttribute("uid") + ":" + port;
    }
    @RequestMapping("/login")
    public String userLogin(@RequestBody UserLogin userLogin, HttpSession httpSession){
        if (httpSession.getAttribute("uid") != null){

            userDetailDao user = userBo.getUserById((Long)httpSession.getAttribute("uid") );
            httpSession.setAttribute("uid", user.getUserId());
            return "success";

        }
        if (userLogin.username == null){
            return "fail";
        }
        userDetailDao user = userBo.getUserByName(userLogin.username);
        if (null == user){
            return "fail";
        }
        if (user.getPassword().equals(userLogin.password)){
            httpSession.setAttribute("uid", user.getUserId());
//            request.getCookies()[0].setHttpOnly(false);
            if (fakeReadConfig.equals("true")){
                //开启假读线程
            }

            return "success";
        }
        return "fail";
    }
    @RequestMapping("/testGet")
    public String testGet(HttpSession httpSession){


        HttpHeaders header = new HttpHeaders();
        List<String> cookies = new ArrayList<>();
        Cookie[] cc = request.getCookies();
        for (int i = 0; i < cc.length; i++)
        {
            cookies.add(cc[i].getName() + "=" + cc[i].getValue());
        }
        header.put(HttpHeaders.COOKIE, cookies);
        HttpEntity httpEntity = new HttpEntity( header);
        RestTemplate restTemplate = new RestTemplate();;
        ResponseEntity<String> res = restTemplate.exchange(
                "http://localhost:9093/querysingle",  HttpMethod.GET,httpEntity, String.class);
        return "res";



    }
    @RequestMapping("/testPost")
    public String userLogin(HttpSession httpSession){


        HttpHeaders header = new HttpHeaders();
        List<String> cookies = new ArrayList<>();
        Cookie[] cc = request.getCookies();
        for (int i = 0; i < cc.length; i++)
        {
            cookies.add(cc[i].getName() + "=" + cc[i].getValue());
        }
        header.put(HttpHeaders.COOKIE, cookies);
        header.setContentType(MediaType.APPLICATION_JSON);
        String requestBody = "{\"index\": 9, \"message\" : \"ada\"}";
        HttpEntity httpEntity = new HttpEntity(requestBody, header);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> res = restTemplate.exchange(
                "http://localhost:9093/sendmessage",  HttpMethod.POST,httpEntity, String.class);
        return "res";



    }


}
