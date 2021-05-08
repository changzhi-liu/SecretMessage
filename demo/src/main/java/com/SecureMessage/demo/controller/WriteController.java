package com.SecureMessage.demo.controller;

import com.SecureMessage.demo.bo.MessageBo;
import com.SecureMessage.demo.bo.UserBo;
import com.SecureMessage.demo.requestmodel.WriteRequest;
import com.SecureMessage.demo.utils.CryptoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
@RestController
public class WriteController {
    @Autowired
    private UserBo userBo;
    @Autowired
    private CryptoUtil cryptoUtil;
    @Autowired
    private MessageBo messageBo;
    @RequestMapping(value = "/sendmessage",method= RequestMethod.POST)
    public String userLogin(@RequestBody WriteRequest writeRequest, HttpSession httpSession){
        //some how get the key

        //encry the message
//        String encoded = cryptoUtil.encryptText(writeRequest.getMessage(), );
//        writeRequest.setMessage(encoded);
        //insert the message
        boolean res = messageBo.updateSingleMessageByKey(writeRequest);
        return res == true ? "updated" : "fail";
    }
}
