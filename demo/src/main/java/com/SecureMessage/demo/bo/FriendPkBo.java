package com.SecureMessage.demo.bo;

import com.SecureMessage.demo.mapper.friendspkDaoMapper;
import com.SecureMessage.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FriendPkBo {
    @Autowired
    friendspkDaoMapper mapper;
    public int insertOneRow(friendspkDao record){
        return mapper.insertSelective(record);
    }
    public int updateRequestStatus(friendspkDao record){
        return mapper.updateByPrimaryKeySelective(record);
    }
    public friendspkDao getByPk(Long pk){
        return mapper.selectByPrimaryKey(pk);
    }
    public int deleteByKey(Long pk){
        return mapper.deleteByPrimaryKey(pk);
    }
    public List<friendspkDao> getUnhandleRequest(Long user_id){

        friendspkDaoExample daoExample = new friendspkDaoExample();
        friendspkDaoExample.Criteria criteria = daoExample.createCriteria();
        criteria.andReceiverDecidedEqualTo(false);
        criteria.andReceiverIdEqualTo(user_id);
        List<friendspkDao> friendspkDaos = mapper.selectByExample(daoExample);
        if (friendspkDaos == null || friendspkDaos.size() == 0){
            return null;
        }

        return friendspkDaos;
    }

    public friendspkDao getSingleRequestBySenderReceiver(Long sender_id, Long receiver_id){

        friendspkDaoExample daoExample = new friendspkDaoExample();
        friendspkDaoExample.Criteria criteria = daoExample.createCriteria();
        criteria.andSenderIdEqualTo(sender_id);
        criteria.andReceiverIdEqualTo(receiver_id);
        List<friendspkDao> friendspkDaos = mapper.selectByExample(daoExample);
        if (friendspkDaos == null || friendspkDaos.size() == 0){
            return null;
        }

        return friendspkDaos.size() > 0 ? friendspkDaos.get(0) : null;
    }
}
