package com.SecureMessage.demo.controller;

import com.SecureMessage.demo.bo.MessageBo;
import com.SecureMessage.demo.bo.UserBo;
import com.SecureMessage.demo.requestmodel.WriteRequest;
import com.SecureMessage.demo.utils.CryptoUtil;
import com.SecureMessage.demo.utils.LocalRowToSenderReceiverUtil;
import com.SecureMessage.demo.utils.LocalkeyPairsUtil;
import com.SecureMessage.demo.utils.localCounterUtil;
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

        Long myid = (Long)httpSession.getAttribute("uid");

//        int[] senderRec = LocalRowToSenderReceiverUtil.getIndex(writeRequest.getReceiver_id());
        // this counter is where the counter shall write
        int intervalIndex = LocalRowToSenderReceiverUtil.getIntevalIndex(myid,writeRequest.getReceiver_id());
        int nextCounter = localCounterUtil.getByCounterByInterval(intervalIndex);
        //from here get actual position using module, so we also need a starting index
        int intervalStart = LocalRowToSenderReceiverUtil.getIntevalStartingIndex(intervalIndex);

        //if nextCounter == 50, it should be on 0 row
        int actPosi = nextCounter % 50 + intervalStart;

//        if (senderRec == null || senderRec[0] != myid){
//            return "range is not correct";
//        }
        String sharedKey = LocalkeyPairsUtil.getInstance().getSharedKey(writeRequest.getReceiver_id()); // add id
        //some how get the key
        if (sharedKey == null){
            return "no key found, check friendship";
        }
        String newMessage = writeRequest.getMessage();
        //todo
        newMessage = ")" + nextCounter + "(" + newMessage;
        writeRequest.setMessage(newMessage);

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
        boolean res = messageBo.updateSingleMessageByKey(writeRequest.getMessage(), new Long(actPosi));
        if (res == true){
            localCounterUtil.increaseCounterByIndex(intervalIndex);
        }
        return res == true ? "updated" : "fail";
    }
}
