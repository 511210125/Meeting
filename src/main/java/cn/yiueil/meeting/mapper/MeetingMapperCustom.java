package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.dto.MeetingCustom;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.vo.MeetingVo;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface MeetingMapperCustom extends MeetingMapper{

    List<MeetingVo> findMeetingByUid();

    List<Long> selectRandomUid();

    /**
     * 查询用户管辖组包含的用户
     * @param uid 用户id
     * @return
     */
    List<User> selectManageUserListByUid(Long uid);

    /**
     * 会议详情信息
     * @param meetingCustom 会议详情
     * @return
     */
    List<MeetingVo> selectMeetingCustomByUidList(MeetingCustom meetingCustom);

    /**
     * 查询参会人的权限
     * @param uid 用户id
     * @param mid 会议id
     * @return
     */
    @Select("select mrole from t_meeting_user where uid = #{uid} and mid =#{mid}")
    String selectMeetingUserRole(Long uid,Long mid);

}