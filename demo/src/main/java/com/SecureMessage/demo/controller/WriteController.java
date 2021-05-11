package com.SecureMessage.demo.controller;

import com.SecureMessage.demo.bo.MessageBo;
import com.SecureMessage.demo.bo.UserBo;
import com.SecureMessage.demo.model.MessageDetailDao;
import com.SecureMessage.demo.requestmodel.WriteRequest;
import com.SecureMessage.demo.util.StringXorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
@RestController
public class WriteController {
    @Autowired
    StringXorUtil stringXorUtil;
    @Autowired
    private UserBo userBo;
    @Autowired
    private MessageBo messageBo;
    @RequestMapping(value = "/sendsinglemessage",method= RequestMethod.POST)
    public String sendsinglemessage(@RequestBody WriteRequest writeRequest, HttpSession httpSession){
        if (httpSession.getAttribute("uid") == null) {
            return "session not found";
        }
        boolean res = messageBo.updateSingleMessageByKey(writeRequest);
        return res == true ? "updated" : "fail";
    }

    @RequestMapping(value = "/sendsinglemessagexor",method= RequestMethod.POST)
    public String sendsinglemessagexor(@RequestBody WriteRequest writeRequest, HttpSession httpSession){
        if (httpSession.getAttribute("uid") == null) {
            return "session not found";
        }
        MessageDetailDao oldMessage = messageBo.getMsgByIndex(writeRequest.getIndex());
        String newString = stringXorUtil.twoStringXor(writeRequest.getMessage(), oldMessage.getContent());
        writeRequest.setMessage(newString);
        boolean res = messageBo.updateSingleMessageByKey(writeRequest);
        return res == true ? "updated" : "fail";
    }

}
