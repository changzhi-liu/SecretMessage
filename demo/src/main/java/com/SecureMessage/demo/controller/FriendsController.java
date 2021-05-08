package com.SecureMessage.demo.controller;

import com.SecureMessage.demo.bo.FriendPkBo;
import com.SecureMessage.demo.bo.UserBo;
import com.SecureMessage.demo.model.friendspkDao;
import com.SecureMessage.demo.model.userDetailDao;
import com.SecureMessage.demo.requestmodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

public class FriendsController {


    @Autowired
    private CryptoUtil cryptoUtil;
    @Autowired
    private FriendPkBo friendPkBo;
    @Autowired
    private UserBo userBo;
    @RequestMapping("/searchfriends")
    public UserBriefResponse searchfriends(@RequestParam("username") Long userId, HttpSession httpSession){
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
    @RequestMapping(value = "/addFriends", method = RequestMethod.POST)
    public String addFriends(@RequestBody AddFriendsRequest addFriendsRequest, HttpSession httpSession) {
        String[] keys = new String[2];
        try{
            keys = cryptoUtil.GetKey();
        } catch (Exception e){
            return "internal cryption error, unable to generate key";
        }
        friendspkDao newFrendReq = new friendspkDao();
        newFrendReq.setKeySender(keys[0]);
        newFrendReq.setSenderId(Long.parseLong(httpSession.getId()));
        newFrendReq.setReceiverDecided(false);
        newFrendReq.setSenderRetrieved(false);
        int res = friendPkBo.insertOneRow(newFrendReq);
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
        if (request.getReceiverId() != Long.parseLong(httpSession.getId())){
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
                sharedKey = cryptoUtil.GetSharedKey(keys[0], request.getKeyReceiver());
            } catch (Exception e) {
                return "internal cryption error, unable to calculate shared key";
            }
            //todo store to local file;

            friendPkBo.updateRequestStatus(request);
            return "accepted";
        }

    }
    // check who is trying to add me;
    @RequestMapping("/checkFriendsRequestToMe")
    public List<friendspkDao> checkFriendsRequestToMe(HttpSession httpSession) {
        // find all request where bit = false; return (pk, friends_rel_id)
        return friendPkBo.getUnhandleRequest(Long.parseLong(httpSession.getId()));
    }



    // check if a friend request is accepted.
    @RequestMapping("/checkNewFriends")
    public String checkNewFriends(@RequestParam("username") Long sender_Id, HttpSession httpSession) {
        friendspkDao req = friendPkBo.getSingleRequestBySenderReceiver(Long.parseLong(httpSession.getId()), sender_Id);
        if (req == null || req.getReceiverDecided() == false){
            return "request not found or not accepted yet";
        }
        String sharedKey;
        try {
            sharedKey = cryptoUtil.GetSharedKey(req.getKeySender(), req.getKeyReceiver());
        } catch (Exception e) {
            return "internal cryption error, unable to calculate shared key";
        }
        //todo store sharedkey

        req.setSenderRetrieved(true);
        friendPkBo.updateRequestStatus(req);
        return "friendship settled";
    }
//    @RequestMapping("/resetAllFriendsKey")
//    public List<UserBrief> userLogin(@RequestParam("username") Long userId, HttpSession httpSession) {
//        // scan table check sender = me && sender_bit == true && reveiver_bit == true
//        // get list of user_id -> pk
//        // get List of user_id -> final_pk
//    }


}
