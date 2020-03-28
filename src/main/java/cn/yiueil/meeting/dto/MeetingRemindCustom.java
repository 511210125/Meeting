package cn.yiueil.meeting.dto;

import cn.yiueil.meeting.entity.Meeting;
import cn.yiueil.meeting.entity.MeetingRemind;
import cn.yiueil.meeting.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeetingRemindCustom extends MeetingRemind {
    private Meeting meeting;
    private User user;
}