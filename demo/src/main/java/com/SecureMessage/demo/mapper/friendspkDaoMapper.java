package com.SecureMessage.demo.mapper;

import com.SecureMessage.demo.model.friendspkDao;
import com.SecureMessage.demo.model.friendspkDaoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface friendspkDaoMapper {
    int deleteByExample(friendspkDaoExample example);

    int deleteByPrimaryKey(Long friendspkId);

    int insert(friendspkDao record);

    int insertSelective(friendspkDao record);

    List<friendspkDao> selectByExampleWithRowbounds(friendspkDaoExample example, RowBounds rowBounds);

    List<friendspkDao> selectByExample(friendspkDaoExample example);

    friendspkDao selectByPrimaryKey(Long friendspkId);

    int updateByExampleSelective(@Param("record") friendspkDao record, @Param("example") friendspkDaoExample example);

    int updateByExample(@Param("record") friendspkDao record, @Param("example") friendspkDaoExample example);

    int updateByPrimaryKeySelective(friendspkDao record);

    int updateByPrimaryKey(friendspkDao record);
}