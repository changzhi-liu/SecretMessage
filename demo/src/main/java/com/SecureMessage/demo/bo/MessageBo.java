package com.SecureMessage.demo.bo;


import com.SecureMessage.demo.mapper.MessageDetailDaoMapper;
import com.SecureMessage.demo.model.MessageDetailDao;
import com.SecureMessage.demo.model.MessageDetailDaoExample;
import com.SecureMessage.demo.requestmodel.WriteRequest;
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
        List<MessageDetailDao> MessageDetailDaos = mapper.selectByExample(daoExample);
        if (MessageDetailDaos == null || MessageDetailDaos.size() == 0){
            return null;
        }

        return MessageDetailDaos.get(0);
    }

    public boolean updateSingleMessageByKey(String msg, Long index){
        MessageDetailDao input = new MessageDetailDao();
        input.setContent(msg);
        input.setMsgIndex(index);
        int res = mapper.updateByPrimaryKeySelective(input);
        return res == 0 ? false : true;
    }

}
