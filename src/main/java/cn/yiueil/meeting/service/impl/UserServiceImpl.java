package cn.yiueil.meeting.service.impl;

import cn.yiueil.meeting.dto.MeetingCustom;
import cn.yiueil.meeting.dto.UserCustom;
import cn.yiueil.meeting.entity.Group;
import cn.yiueil.meeting.entity.Meeting;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.mapper.GroupMapperCustom;
import cn.yiueil.meeting.mapper.MeetingMapperCustom;
import cn.yiueil.meeting.mapper.UserMapperCustom;
import cn.yiueil.meeting.service.UserService;
import cn.yiueil.meeting.vo.GroupVo;
import cn.yiueil.meeting.vo.MeetingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * message
 * __/\\\________/\\\____________/\\\\\\\\\\\_____________________________________________________________________________/\\\\\\________
 * _\///\\\____/\\\/____________\/////\\\///_____________________________________________________________________________\////\\\________
 * ___\///\\\/\\\/__________________\/\\\_________________________________________________________________/\\\______________\/\\\________
 * _____\///\\\/____________________\/\\\________________/\\\____/\\\_______________/\\\\\\\\\\____________\///______________\/\\\________
 * _______\/\\\_____________________\/\\\_______________\/\\\___\/\\\_____________/\\\/////////____________/\\\______________\/\\\________
 * _______\/\\\_____________________\/\\\_______________\/\\\___\/\\\____________/\\\\\\\\\\_______________\/\\\_____________\/\\\________
 * _______\/\\\_____________________\/\\\_______________\/\\\___\/\\\___________\//\\///////_______________\/\\\_____________\/\\\________
 * _______\/\\\__________________/\\\\\\\\\\\___________\//\\\\\\\\\_____________\//\\\\\\\\\\\\\___________\/\\\____________/\\\\\\\\\\\\\_
 * _______\///__________________\///////////_____________\/////////_______________\/////////////____________\///____________\/////////////__
 * Create by YIueil
 * Create time 2019/9/30
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapperCustom userMapperCustom;
    @Autowired
    private MeetingMapperCustom meetingMapperCustom;
    @Autowired
    private GroupMapperCustom groupMapperCustom;

    @Override
    public List<User> findManageUserByUidList(Long uid) throws SQLException {
        return groupMapperCustom.selectManageUserByUid(uid);
    }

    @Override
    public List<MeetingVo> findMeetingByUidList(MeetingCustom meetingCustom) throws SQLException {
        List<MeetingVo> meetingVoList = meetingMapperCustom.selectMeetingCustomByUidList(meetingCustom);
        for (MeetingVo meetingVo : meetingVoList) {
            for (UserCustom user : meetingVo.getUsers()) {
                if (user.getMrole().equals("issuer"))
                    meetingVo.setAvatar(user.getAvatarUrl());
            }
        }
        return meetingVoList;
    }

    @Override
    public List<GroupVo> findGroupByUidList(Long uid) throws SQLException {
        List<GroupVo> groupList = groupMapperCustom.selectGroupVoByUid(uid);

        return groupList;
    }

    @Override
    public User findUserInformationByUid(Long uid) throws SQLException {
        /*select t_meeting.*,t_user.`avatar_url` from t_user,t_meeting,t_meeting_user
        where t_user.`id` = t_meeting_user.`uid` and t_meeting.`id` = t_meeting_user.`mid`
        and t_user.`id` = 1*/
        return null;
    }

    @Override
    public boolean modifyUserAvatarUrl() throws SQLException {
        return false;
    }

    @Override
    public void modifyUserInformation(User user) throws SQLException {
        userMapperCustom.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<Meeting> XXX() throws SQLException {
        return null;
    }
}
