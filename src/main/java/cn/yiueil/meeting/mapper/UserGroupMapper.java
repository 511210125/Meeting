package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.entity.UserGroup;
import cn.yiueil.meeting.entity.UserGroupExample;
import cn.yiueil.meeting.entity.UserGroupKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserGroupMapper {
    long countByExample(UserGroupExample example);

    int deleteByExample(UserGroupExample example);

    int deleteByPrimaryKey(UserGroupKey key);

    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    List<UserGroup> selectByExample(UserGroupExample example);

    UserGroup selectByPrimaryKey(UserGroupKey key);

    int updateByExampleSelective(@Param("record") UserGroup record, @Param("example") UserGroupExample example);

    int updateByExample(@Param("record") UserGroup record, @Param("example") UserGroupExample example);

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKey(UserGroup record);
}