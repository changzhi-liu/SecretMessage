package com.SecureMessage.demo.controller;

import com.SecureMessage.demo.bo.FriendPkBo;
import com.SecureMessage.demo.bo.UserBo;
import com.SecureMessage.demo.model.friendspkDao;
import com.SecureMessage.demo.model.userDetailDao;
import com.SecureMessage.demo.requestmodel.*;
import com.SecureMessage.demo.utils.CryptoUtil;
import com.SecureMessage.demo.utils.LocalkeyPairsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
public class FriendsController {


    @Autowired
    private CryptoUtil cryptoUtil;
    @Autowired
    private FriendPkBo friendPkBo;
    @Autowired
    private UserBo userBo;
    @RequestMapping("/searchfriends")
    public UserBriefResponse searchfriends(@RequestParam("user_id") Long userId, HttpSession httpSession){
        //check http
        userDetailDao user = userBo.getUserById(userId);
        UserBriefResponse res = null;
        if (user != null) {
            res = new UserBriefResponse(user.getUserId(), user.getUsername());
        }

        return res;
    }
    // need a map stored locally: Map<>: key -> opponent_id, String[]{my private key, share key}
    // input: firendsId, privatekey
    // send a friend request with public key, return a secret key to frontend



//    @RequestMapping("/newf")
//    public String newf(@RequestBody Map<String,Object> param, HttpSession httpSession){
//
//        return "fail";
//    }
    @RequestMapping("/newf" )  //这里传一个"friendId":int的格式
    public String newf(@RequestBody Map<String,Long> param, HttpSession httpSession) {
        String[] keys = new String[2];
        try{
            keys = cryptoUtil.GetKey();
        } catch (Exception e){
            return "internal cryption error, unable to generate key";
        }
        friendspkDao newFrendReq = new friendspkDao();
        newFrendReq.setKeySender(keys[0]);
        newFrendReq.setReceiverId((Long)(param.get("friendId")));
        newFrendReq.setSenderId((Long)httpSession.getAttribute("uid"));
        newFrendReq.setReceiverDecided(false);
        newFrendReq.setSenderRetrieved(false);
        int res = friendPkBo.insertOneRow(newFrendReq);
        // store private key
        LocalkeyPairsUtil.getInstance().putMyPrivateKey( (Long)(param.get("friendId")), keys[1]);
        return res == 0 ? "false" : "true";
        // pk = test.generatePK();
        // insert pk in db
        // if insert success, return true;

    }
    // accept a friends request and
    @RequestMapping("/acceptFriendsRequest")   // (pk, friends_rel_id, boolean acc)
    public String acceptFriends(@RequestBody AcceptFriendsRequest acceptFriendsRequest, HttpSession httpSession) {

        friendspkDao request = friendPkBo.getByPk(acceptFriendsRequest.getFriendPkId());

        if (request.getReceiverDecided() == true){
            return "already accepted";
        }
        if (!request.getReceiverId().equals((Long)httpSession.getAttribute("uid"))){
            return "unable to authorize others requests";
        }
        if (acceptFriendsRequest.isAccpted() == false) {
            friendPkBo.deleteByKey(acceptFriendsRequest.getFriendPkId());
            return "rejected";
        } else {
//            request.setKeyReceiver(acceptFriendsRequest.getMyPk());
            String[] keys = new String[2];
            try{
                keys = cryptoUtil.GetKey();
            } catch (Exception e){
                return "internal cryption error, unable to generate key";
            }

            request.setReceiverDecided(true);
            String sharedKey;
            try {
                sharedKey = cryptoUtil.GetSharedKey(keys[1],request.getKeySender());
            } catch (Exception e) {
                return "internal cryption error, unable to calculate shared key";
            }
            //todo store to local file;
            request.setKeyReceiver(keys[0]);
            friendPkBo.updateRequestStatus(request);
            LocalkeyPairsUtil.getInstance().putMyPrivateKey( request.getSenderId(), keys[1]);
            LocalkeyPairsUtil.getInstance().putSharedKey(request.getSenderId(), sharedKey);
            return "accepted";
        }

    }
    // check who is trying to add me;
    @RequestMapping("/checkFriendsRequestToMe")
    public List<friendspkDao> checkFriendsRequestToMe(HttpSession httpSession) {
        // find all request where bit = false; return (pk, friends_rel_id)
        return friendPkBo.getUnhandleRequest((Long)httpSession.getAttribute("uid"));
    }



    // check if a friend request is accepted.
    @RequestMapping("/checkNewFriends")
    public String checkNewFriends(@RequestParam("") Long receiver_Id, HttpSession httpSession) {
        friendspkDao req = friendPkBo.getSingleRequestBySenderReceiver((Long)httpSession.getAttribute("uid"), receiver_Id);
        if (req == null || req.getReceiverDecided() == false){
            return "request not found or not accepted yet";
        }
        String sharedKey;
        String myPrivateKey = LocalkeyPairsUtil.getInstance().getMyPrivateKey(req.getReceiverId());
        // use my key;
        try {
            sharedKey = cryptoUtil.GetSharedKey(myPrivateKey, req.getKeyReceiver());
        } catch (Exception e) {
            return "internal cryption error, unable to calculate shared key";
        }


        req.setSenderRetrieved(true);
        friendPkBo.updateRequestStatus(req);
        //store sharedkey
        LocalkeyPairsUtil.getInstance().putSharedKey(req.getReceiverId(),sharedKey);
        return "friendship settled";
    }
//    @RequestMapping("/resetAllFriendsKey")
//    public List<UserBrief> userLogin(@RequestParam("username") Long userId, HttpSession httpSession) {
//        // scan table check sender = me && sender_bit == true && reveiver_bit == true
//        // get list of user_id -> pk
//        // get List of user_id -> final_pk
//    }


}
