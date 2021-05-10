package com.SecureMessage.demo.controller;

import com.SecureMessage.demo.bo.MessageBo;
import com.SecureMessage.demo.bo.UserBo;
import com.SecureMessage.demo.config.ServerPortConfig;
import com.SecureMessage.demo.model.MessageDetailDao;
import com.SecureMessage.demo.model.userDetailDao;
import com.SecureMessage.demo.utils.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class QueryController {
    @Autowired
    private CryptoUtil cryptoUtil;
    @Autowired
    private GenerateQueryListUtil gq;
    @Autowired
    private StringXorUtil stringXor;
    @Autowired
    private UserBo userBo;
    @Autowired
    private MessageBo messageBo;
    @Autowired
    ServerPortConfig serverPortConfig;
    @Autowired
    SendToServerUtil sendToServerUtil;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/query")
    public String userLogin(@RequestParam("index") int index,
                            HttpSession httpSession
    ){
        Logger logger = LogManager.getLogger(this.getClass());



        List<List<Integer>> lists = gq.getList(index);
        //queryService
        List<List<Integer>> queryList = gq.convertToRow(lists); //{{3,7,9}. {4,1,7}}
        List<String> allQueryResults = new ArrayList<>();
        List<String> server_ports = serverPortConfig.getServerPorts();
//        List<String> server_ports = new ArrayList<>();
        for ( int i = 1; i < queryList.size(); i++) {
            List<Integer> t = queryList.get(i);
            String server_port = server_ports.get(i-1);
            for (Integer row : t) {
                String url = "http://localhost:"+server_port+"/querysingle" + "?index=" + String.valueOf(row);
                String message = sendToServerUtil.sendGetMessageToServer(url, request);
                if (message.equals("session not found")){
                    return "login required";
                }
                allQueryResults.add(message);

                //log as server attacker
                logger.info("attacker on server {} observing client {} getting message {} from user {}!", i, httpSession.getId(),message);
            }
        }
//        for ( int i = 1; i < queryList.size(); i++){
//            List<Integer> t = queryList.get(i);
//            for (Integer row : t){
//               MessageDetailDao msg =  messageBo.getMsgByIndex(row);
//               allQueryResults.add(msg.getContent());
//
//                //log as server attacker
//               logger.info("attacker on server {} observing client {} getting message {} from user {}!" ,i, user.getUserId(), msg.getContent(), msg.getSenderId());
//            }
//        }
        String res = stringXor.xorList(allQueryResults);
        //log client get this
        logger.info("The real message calculated by client is {}!" , res);
        for (int x = 0; x < res.length(); x++){
            if (res.charAt(x) == 0){
                res = res.substring(0,x);
                break;
            }
        }
        //for demo purpose
        for (Integer row : queryList.get(0)){
            MessageDetailDao msg =  messageBo.getMsgByIndex(row);
            allQueryResults.add(msg.getContent());
            //log as server attacker
            logger.info("(Direct get from db)The real message client want is {} from user {}!" , msg.getContent(), msg.getSenderId());
        }
        //decode string
        //todo using index to get key
        String decoded = "";
        String sharedKey = LocalkeyPairsUtil.getInstance().getSharedKey(1L);
        try {
            decoded = cryptoUtil.decryptText(res, sharedKey);
        } catch (Exception e) {
            return "encoding error, check if friendship is established";
        }


        return decoded;

    }


}
