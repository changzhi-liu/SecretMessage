package com.SecureMessage.demo.mapper;

import com.SecureMessage.demo.model.FriendShipDao;
import com.SecureMessage.demo.model.FriendShipDaoExample;
import com.SecureMessage.demo.model.FriendShipDaoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FriendShipDaoMapper {
    int deleteByExample(FriendShipDaoExample example);

    int deleteByPrimaryKey(FriendShipDaoKey key);

    int insert(FriendShipDao record);

    int insertSelective(FriendShipDao record);

    List<FriendShipDao> selectByExampleWithRowbounds(FriendShipDaoExample example, RowBounds rowBounds);

    List<FriendShipDao> selectByExample(FriendShipDaoExample example);

    FriendShipDao selectByPrimaryKey(FriendShipDaoKey key);

    int updateByExampleSelective(@Param("record") FriendShipDao record, @Param("example") FriendShipDaoExample example);

    int updateByExample(@Param("record") FriendShipDao record, @Param("example") FriendShipDaoExample example);

    int updateByPrimaryKeySelective(FriendShipDao record);

    int updateByPrimaryKey(FriendShipDao record);
}