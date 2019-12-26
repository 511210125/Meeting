package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.entity.MeetRemindExample;
import cn.yiueil.meeting.entity.MeetRemindKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeetRemindMapper {
    long countByExample(MeetRemindExample example);

    int deleteByExample(MeetRemindExample example);

    int deleteByPrimaryKey(MeetRemindKey key);

    int insert(MeetRemindKey record);

    int insertSelective(MeetRemindKey record);

    List<MeetRemindKey> selectByExample(MeetRemindExample example);

    int updateByExampleSelective(@Param("record") MeetRemindKey record, @Param("example") MeetRemindExample example);

    int updateByExample(@Param("record") MeetRemindKey record, @Param("example") MeetRemindExample example);
}