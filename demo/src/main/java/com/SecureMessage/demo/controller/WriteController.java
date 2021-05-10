package com.SecureMessage.demo.controller;

import com.SecureMessage.demo.bo.MessageBo;
import com.SecureMessage.demo.bo.UserBo;
import com.SecureMessage.demo.requestmodel.WriteRequest;
import com.SecureMessage.demo.utils.CryptoUtil;
import com.SecureMessage.demo.utils.LocalkeyPairsUtil;
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

//        locationUtil.getRcevierId(writeRequest.getIndex());
        String sharedKey = LocalkeyPairsUtil.getInstance().getSharedKey(3L); // add id
        //some how get the key

        //encry the message
        String encoded = "";
        try {
            encoded = cryptoUtil.encryptText(writeRequest.getMessage(), sharedKey);
        } catch (Exception e) {
            return "encoding error, check if friendship is established";
        }
        writeRequest.setMessage(encoded);
        //insert the message
        String msg = writeRequest.getMessage();
        writeRequest.setMessage(msg);
        boolean res = messageBo.updateSingleMessageByKey(writeRequest);
        return res == true ? "updated" : "fail";
    }
}
