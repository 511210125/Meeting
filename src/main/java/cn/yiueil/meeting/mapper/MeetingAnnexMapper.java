package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.entity.MeetingAnnex;
import cn.yiueil.meeting.entity.MeetingAnnexExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeetingAnnexMapper {
    long countByExample(MeetingAnnexExample example);

    int deleteByExample(MeetingAnnexExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MeetingAnnex record);

    int insertSelective(MeetingAnnex record);

    List<MeetingAnnex> selectByExample(MeetingAnnexExample example);

    MeetingAnnex selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MeetingAnnex record, @Param("example") MeetingAnnexExample example);

    int updateByExample(@Param("record") MeetingAnnex record, @Param("example") MeetingAnnexExample example);

    int updateByPrimaryKeySelective(MeetingAnnex record);

    int updateByPrimaryKey(MeetingAnnex record);
}