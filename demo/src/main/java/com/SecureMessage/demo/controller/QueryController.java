package com.SecureMessage.demo.controller;

import com.SecureMessage.demo.bo.MessageBo;
import com.SecureMessage.demo.bo.UserBo;
import com.SecureMessage.demo.model.MessageDetailDao;
import com.SecureMessage.demo.model.userDetailDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class QueryController {

    @Autowired
    private GenerateQueryList gq;
    @Autowired
    private StringXor stringXor;
    @Autowired
    private UserBo userBo;
    @Autowired
    private MessageBo messageBo;


    @RequestMapping("/query")
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String pwd,@RequestParam("index") int index,
                            HttpSession httpSession
    ){
        Logger logger = LogManager.getLogger(this.getClass());

        userDetailDao user = userBo.getUserByName(username);
        if (null == user){
            return "fail";
        }

        if (!user.getPassword().equals(pwd)){
            return "fail";
        }

        List<List<Integer>> lists = gq.getList(index);
        //queryService
        List<List<Integer>> queryList = gq.convertToRow(lists); //{{3,7,9}. {4,1,7}}
        List<String> allQueryResults = new ArrayList<>();
        for ( int i = 1; i < queryList.size(); i++){
            List<Integer> t = queryList.get(i);
            for (Integer row : t){
               MessageDetailDao msg =  messageBo.getMsgByIndex(row);
               allQueryResults.add(msg.getContent());

                //log as server attacker
               logger.info("attacker on server {} observing client {} getting message {} from user {}!" ,i, user.getUserId(), msg.getContent(), msg.getSenderId());


            }
        }
        String res = stringXor.xorList(allQueryResults);
        //log client get this
        logger.info("The real message calculated by client is {}!" , res);

        //for demo purpose
        for (Integer row : queryList.get(0)){
            MessageDetailDao msg =  messageBo.getMsgByIndex(row);
            allQueryResults.add(msg.getContent());
            //log as server attacker
            logger.info("(Direct get from db)The real message client want is {} from user {}!" , msg.getContent(), msg.getSenderId());
        }
        return res;

    }


}
