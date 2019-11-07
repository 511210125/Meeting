package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.dto.MeetingCustom;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.vo.MeetingVo;


import java.util.List;

public interface MeetingMapperCustom extends MeetingMapper{
    List<MeetingVo> findMeetingByUid();
    List<Long> findRandomUid();
    List<User> findManageUserListByUid(Long uid);

    List<MeetingVo> findMeetingCustomByUidList(MeetingCustom meetingCustom);
}