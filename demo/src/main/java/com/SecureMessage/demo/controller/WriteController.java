package com.SecureMessage.demo.controller;

import com.SecureMessage.demo.bo.MessageBo;
import com.SecureMessage.demo.bo.UserBo;
import com.SecureMessage.demo.requestmodel.WriteRequestClient;
import com.SecureMessage.demo.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class WriteController {
    @Autowired
    private UserBo userBo;
    @Autowired
    private CryptoUtil cryptoUtil;
    @Autowired
    private MessageBo messageBo;
    @Autowired
    SendToServerUtil sendToServerUtil;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    StringXorUtil stringXorUtil;
    @Autowired
    GenerateXorWriteMessagesUtil generateXorWriteMessagesUtil;


    @RequestMapping(value = "/sendmessage",method= RequestMethod.POST)
    public String sendmessage(@RequestBody WriteRequestClient writeRequestClient, HttpSession httpSession){

//        locationUtil.getRcevierId(writeRequest.getIndex());

        Long myid = (Long)httpSession.getAttribute("uid");

//        int[] senderRec = LocalRowToSenderReceiverUtil.getIndex(writeRequest.getReceiver_id());
        // this counter is where the counter shall write
        int intervalIndex = LocalRowToSenderReceiverUtil.getIntevalIndex(myid, writeRequestClient.getReceiver_id());
        int nextCounter = localCounterUtil.getByCounterByInterval(intervalIndex);
        //from here get actual position using module, so we also need a starting index
        int intervalStart = LocalRowToSenderReceiverUtil.getIntevalStartingIndex(intervalIndex);

        //if nextCounter == 50, it should be on 0 row
        int actPosi = nextCounter % 50 + intervalStart;

        Random rd = new Random();
        int randomPort = rd.nextInt(3)+9091;

        String url = "http://localhost:"+String.valueOf(randomPort)+"/querysingle" + "?index=" + String.valueOf(actPosi);
        String message = sendToServerUtil.sendGetMessageToServer(url, request);
        if (message.equals("session not found")){
            return "login required";
        }




//        if (senderRec == null || senderRec[0] != myid){
//            return "range is not correct";
//        }
        String sharedKey = LocalkeyPairsUtil.getInstance().getSharedKey(writeRequestClient.getReceiver_id()); // add id
        //some how get the key
        if (sharedKey == null){
            return "no key found, check friendship";
        }
        String newMessage = writeRequestClient.getMessage();
        //todo
        newMessage = ")" + nextCounter + "(" + newMessage;





        writeRequestClient.setMessage(newMessage);

        //encry the message
        String encoded = "";
        try {
            encoded = cryptoUtil.encryptText(writeRequestClient.getMessage(), sharedKey);
        } catch (Exception e) {
            return "encoding error, check if friendship is established";
        }


        //use newMessage and old message to get three message to send for xor.
        String baseMessage = stringXorUtil.twoStringXor(message, encoded);

        List<String> allMessage = generateXorWriteMessagesUtil.generateThreeMessage(baseMessage);

        //generate a permuation of servers           213,321,132
        int[] servers = new int[]{9091, 9092, 9093};
        List<Integer> ports = new ArrayList<>();
        int randomIndex = rd.nextInt(3);
        int randomIndex2 = rd.nextInt(3);
        while (randomIndex2 == randomIndex ){
            randomIndex2 = rd.nextInt(3);
        }
        ports.add(servers[randomIndex]);
        ports.add(servers[randomIndex2]);ports.add(servers[3-randomIndex - randomIndex2]);

        //for each message, go get a random server and xor
        for (int i = 0; i < allMessage.size(); i++){
            String t = allMessage.get(i);
            int port = ports.get(i);
            String writeUrl = "http://localhost:"+String.valueOf(port)+"/sendsinglemessagexor";
            String res = sendToServerUtil.sendXorMessageToServer(writeUrl,actPosi,t, request);
            if(res.equals("fail")){
                return "failed to xor write, please check logic";
            }
        }




//        boolean res = messageBo.updateSingleMessageByKey(writeRequestClient.getMessage(), new Long(actPosi));


        localCounterUtil.increaseCounterByIndex(intervalIndex);

        return  "updated" ;
    }
}
