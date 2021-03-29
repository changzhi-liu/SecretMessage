package com.SecureMessage.demo.mapper;

import com.SecureMessage.demo.model.userDetailDao;
import com.SecureMessage.demo.model.userDetailDaoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface userDetailDaoMapper {
    int deleteByExample(userDetailDaoExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(userDetailDao record);

    int insertSelective(userDetailDao record);

    List<userDetailDao> selectByExampleWithRowbounds(userDetailDaoExample example, RowBounds rowBounds);

    List<userDetailDao> selectByExample(userDetailDaoExample example);

    userDetailDao selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") userDetailDao record, @Param("example") userDetailDaoExample example);

    int updateByExample(@Param("record") userDetailDao record, @Param("example") userDetailDaoExample example);

    int updateByPrimaryKeySelective(userDetailDao record);

    int updateByPrimaryKey(userDetailDao record);
}