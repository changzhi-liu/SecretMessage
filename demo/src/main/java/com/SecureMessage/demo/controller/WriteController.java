package com.SecureMessage.demo.controller;

import com.SecureMessage.demo.bo.MessageBo;
import com.SecureMessage.demo.bo.UserBo;
import com.SecureMessage.demo.requestmodel.WriteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
@RestController
public class WriteController {
    @Autowired
    private UserBo userBo;
    @Autowired
    private MessageBo messageBo;
    @RequestMapping(value = "/sendsinglemessage",method= RequestMethod.POST)
    public String userLogin(@RequestBody WriteRequest writeRequest, HttpSession httpSession){
        if (httpSession.getAttribute("uid") == null) {
            return "session not found";
        }
        boolean res = messageBo.updateSingleMessageByKey(writeRequest);
        return res == true ? "updated" : "fail";
    }
}
