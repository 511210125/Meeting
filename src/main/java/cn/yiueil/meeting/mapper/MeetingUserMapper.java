package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.entity.MeetingUser;
import cn.yiueil.meeting.entity.MeetingUserExample;
import cn.yiueil.meeting.entity.MeetingUserKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeetingUserMapper {
    long countByExample(MeetingUserExample example);

    int deleteByExample(MeetingUserExample example);

    int deleteByPrimaryKey(MeetingUserKey key);

    int insert(MeetingUser record);

    int insertSelective(MeetingUser record);

    List<MeetingUser> selectByExample(MeetingUserExample example);

    MeetingUser selectByPrimaryKey(MeetingUserKey key);

    int updateByExampleSelective(@Param("record") MeetingUser record, @Param("example") MeetingUserExample example);

    int updateByExample(@Param("record") MeetingUser record, @Param("example") MeetingUserExample example);

    int updateByPrimaryKeySelective(MeetingUser record);

    int updateByPrimaryKey(MeetingUser record);
}