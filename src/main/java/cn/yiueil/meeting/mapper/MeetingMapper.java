package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.entity.Meeting;
import cn.yiueil.meeting.entity.MeetingExample;
import cn.yiueil.meeting.entity.MeetingWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeetingMapper {
    long countByExample(MeetingExample example);

    int deleteByExample(MeetingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MeetingWithBLOBs record);

    int insertSelective(MeetingWithBLOBs record);

    List<MeetingWithBLOBs> selectByExampleWithBLOBs(MeetingExample example);

    List<Meeting> selectByExample(MeetingExample example);

    MeetingWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MeetingWithBLOBs record, @Param("example") MeetingExample example);

    int updateByExampleWithBLOBs(@Param("record") MeetingWithBLOBs record, @Param("example") MeetingExample example);

    int updateByExample(@Param("record") Meeting record, @Param("example") MeetingExample example);

    int updateByPrimaryKeySelective(MeetingWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MeetingWithBLOBs record);

    int updateByPrimaryKey(Meeting record);
}