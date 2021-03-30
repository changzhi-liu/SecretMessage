package com.SecureMessage.demo.bo;


import com.SecureMessage.demo.mapper.MessageDetailDaoMapper;
import com.SecureMessage.demo.model.MessageDetailDao;
import com.SecureMessage.demo.model.MessageDetailDaoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MessageBo {
    @Autowired
    private MessageDetailDaoMapper mapper;
    public MessageDetailDao getMsgByIndex(long index){
        MessageDetailDaoExample daoExample = new MessageDetailDaoExample();
        MessageDetailDaoExample.Criteria criteria = daoExample.createCriteria();
        criteria.andMsgIndexEqualTo(index);
        List<MessageDetailDao> userDetailDaos = mapper.selectByExample(daoExample);
        if (userDetailDaos == null || userDetailDaos.size() == 0){
            return null;
        }

        return userDetailDaos.get(0);
    }
}
