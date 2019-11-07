package cn.yiueil.meeting.service;

import cn.yiueil.meeting.dto.MeetingCustom;
import cn.yiueil.meeting.entity.Group;
import cn.yiueil.meeting.entity.Meeting;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.vo.GroupVo;
import cn.yiueil.meeting.vo.MeetingVo;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;

/**
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
 * Create time 2019/9/5
 * message 用户服务
 */
public interface UserService {

    public List<User> findManageUserByUidList(Long uid)throws SQLException;

    /**
     * 查询用户相关会议
     * @param meetingCustom
     * @return
     * @throws SQLException
     */
    public List<MeetingVo> findMeetingByUidList(MeetingCustom meetingCustom)throws SQLException;


    /**
     * 查询用户所在小组
     * @param uid
     * @return
     * @throws SQLException
     */
    public List<GroupVo> findGroupByUidList(Long uid)throws SQLException;


    /**
     * 查询用户硌淫信息
     * @param uid
     * @return
     */
    public User findUserInformationByUid(Long uid)throws SQLException;

    /**
     * 用户头像上传(修改)，调用七牛云接口
     * @return
     * @throws Exception
     */
    public boolean modifyUserAvatarUrl()throws SQLException;

    /**
     * 用户信息更改
     * @param user
     * @throws SQLException
     */
    public void modifyUserInformation(User user)throws SQLException;

    //调整个人会前提醒时间
    public List<Meeting> XXX()throws SQLException;

    //设置闹钟式提醒

}
