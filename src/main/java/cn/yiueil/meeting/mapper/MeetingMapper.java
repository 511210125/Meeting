package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.entity.Meeting;
import cn.yiueil.meeting.entity.MeetingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeetingMapper {
    long countByExample(MeetingExample example);

    int deleteByExample(MeetingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Meeting record);

    int insertSelective(Meeting record);

    List<Meeting> selectByExampleWithBLOBs(MeetingExample example);

    List<Meeting> selectByExample(MeetingExample example);

    Meeting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Meeting record, @Param("example") MeetingExample example);

    int updateByExampleWithBLOBs(@Param("record") Meeting record, @Param("example") MeetingExample example);

    int updateByExample(@Param("record") Meeting record, @Param("example") MeetingExample example);

    int updateByPrimaryKeySelective(Meeting record);

    int updateByPrimaryKeyWithBLOBs(Meeting record);

    int updateByPrimaryKey(Meeting record);
}