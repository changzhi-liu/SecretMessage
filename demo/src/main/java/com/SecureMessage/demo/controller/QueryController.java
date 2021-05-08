package com.SecureMessage.demo.controller;

import com.SecureMessage.demo.bo.MessageBo;
import com.SecureMessage.demo.bo.UserBo;
import com.SecureMessage.demo.model.MessageDetailDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class QueryController {

    @Autowired
    private UserBo userBo;
    @Autowired
    private MessageBo messageBo;


    @RequestMapping("/querysingle")
    public String userLogin(@RequestParam("index") int index,
                            HttpSession httpSession
    ){
//        Result res = new Result();
        if (httpSession.getAttribute("uid") == null) {
//            res = new Result();
//            res.setAttributes("msg", );

            return "session not found";

        }
        String res1 = "";
        Logger logger = LogManager.getLogger(this.getClass());
        MessageDetailDao msg =  messageBo.getMsgByIndex(index);
//        res.setAttributes("msg","login session requires");
//        res.setAttributes("items", msg);
        return msg == null ? "" : msg.getContent();

    }

}
