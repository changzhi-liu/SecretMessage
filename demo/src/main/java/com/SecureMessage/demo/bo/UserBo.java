package com.SecureMessage.demo.bo;

import com.SecureMessage.demo.mapper.userDetailDaoMapper;
import com.SecureMessage.demo.model.userDetailDao;
import com.SecureMessage.demo.model.userDetailDaoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserBo {
    @Autowired
    private userDetailDaoMapper mapper;
    public userDetailDao getUserByName(String UserName){
        userDetailDaoExample daoExample = new userDetailDaoExample();
        userDetailDaoExample.Criteria criteria = daoExample.createCriteria();
        criteria.andUsernameEqualTo(UserName);
        List<userDetailDao> userDetailDaos = mapper.selectByExample(daoExample);
        if (userDetailDaos == null || userDetailDaos.size() == 0){
            return null;
        }

        return userDetailDaos.get(0);
    }

    public userDetailDao getUserById(Long user_id){
        userDetailDao user = mapper.selectByPrimaryKey(user_id);
        return user;
    }

}
