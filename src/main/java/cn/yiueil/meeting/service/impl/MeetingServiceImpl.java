package cn.yiueil.meeting.service.impl;

import cn.yiueil.meeting.entity.Meeting;
import cn.yiueil.meeting.entity.MeetingUser;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.mapper.MeetingMapper;
import cn.yiueil.meeting.mapper.MeetingUserMapper;
import cn.yiueil.meeting.mapper.MyMapper;
import cn.yiueil.meeting.service.MeetingService;
import cn.yiueil.meeting.vo.GroupVo;
import cn.yiueil.meeting.vo.MeetingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    private MyMapper myMapper;
    @Autowired
    private MeetingMapper meetingMapper;
    @Autowired
    private MeetingUserMapper meetingUserMapper;

    @Override
    public String UserMeetingRoleTest(Long mid, Long uid) throws SQLException {
        return null;
    }

    @Override
    public List<GroupVo> findManageGroupList(Long uid) throws SQLException {
        return null;
    }

    @Override
    public List<User> findManageUserList(Long uid) throws SQLException {
        return null;
    }

    @Override
    public void saveReleaseMeeting(Meeting meeting,List<Long> uids,Long issuer,Long chair,Long recorder) throws SQLException {
        meetingMapper.insertSelective(meeting);
        Long mid = myMapper.selectMaxId();
        MeetingUser key ;
        for (Long uid : uids){
            key = new MeetingUser();
            key.setUid(uid);
            key.setMid(mid);
            meetingUserMapper.insertSelective(key);
        }

        {
            key = new MeetingUser();
            key.setUid(issuer);
            key.setMid(mid);
            key.setMrole("issuer");
            meetingUserMapper.updateByPrimaryKeySelective(key);
        }

        {
            key = new MeetingUser();
            key.setUid(chair);
            key.setMid(mid);
            key.setMrole("chair");
            meetingUserMapper.updateByPrimaryKeySelective(key);
        }

        {
            key = new MeetingUser();
            key.setUid(recorder);
            key.setMid(mid);
            key.setMrole("recorder");
            meetingUserMapper.updateByPrimaryKeySelective(key);
        }

    }

    @Override
    public void modifyMeetingStart(Long mid) throws SQLException {

    }

    @Override
    public void modifyMeetingStop(Long mid) throws SQLException {

    }

    @Override
    public void saveMeetingAudioFile(MultipartFile audio, Long mid, boolean isTransform) throws SQLException {

    }

    @Override
    public void saveMeetingAnnexFile(MultipartFile file, Long mid, boolean type) throws SQLException {

    }

    @Override
    public MeetingVo findMeetingInformationByMid(Long mid) throws SQLException {
        return null;
    }

    @Override
    public void removeMeetingAnnexFileByFid(Long fid) throws SQLException {

    }
}
