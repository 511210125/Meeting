package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.dto.MeetingRemindCustom;
import cn.yiueil.meeting.entity.MeetingRemind;
import cn.yiueil.meeting.entity.MeetingRemindExample;

import java.util.List;

public interface MeetingRemindMapperCustom extends MeetingRemindMapper{
    List<MeetingRemindCustom> selectMeetingRemindDetailListByDay(MeetingRemindExample example);
}