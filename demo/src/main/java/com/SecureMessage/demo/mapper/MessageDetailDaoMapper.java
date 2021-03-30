package com.SecureMessage.demo.mapper;

import com.SecureMessage.demo.model.MessageDetailDao;
import com.SecureMessage.demo.model.MessageDetailDaoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface MessageDetailDaoMapper {
    int deleteByExample(MessageDetailDaoExample example);

    int deleteByPrimaryKey(Long msgIndex);

    int insert(MessageDetailDao record);

    int insertSelective(MessageDetailDao record);

    List<MessageDetailDao> selectByExampleWithRowbounds(MessageDetailDaoExample example, RowBounds rowBounds);

    List<MessageDetailDao> selectByExample(MessageDetailDaoExample example);

    MessageDetailDao selectByPrimaryKey(Long msgIndex);

    int updateByExampleSelective(@Param("record") MessageDetailDao record, @Param("example") MessageDetailDaoExample example);

    int updateByExample(@Param("record") MessageDetailDao record, @Param("example") MessageDetailDaoExample example);

    int updateByPrimaryKeySelective(MessageDetailDao record);

    int updateByPrimaryKey(MessageDetailDao record);
}