package cn.yiueil.meeting.service.impl;

import cn.yiueil.meeting.dto.MeetingFile;
import cn.yiueil.meeting.entity.*;
import cn.yiueil.meeting.mapper.*;
import cn.yiueil.meeting.service.MeetingService;
import cn.yiueil.meeting.vo.GroupVo;
import cn.yiueil.meeting.vo.MeetingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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
    private MeetingMapperCustom meetingMapperCustom;
    @Autowired
    private MeetingUserMapper meetingUserMapper;
    @Autowired
    private MeetingAnnexMapper meetingAnnexMapper;
    @Autowired
    private MeetingRemindMapper meetingRemindMapper;
    @Autowired
    private RemindMapper remindMapper;

    @Override
    public String UserMeetingRoleTest(Long mid, Long uid) throws SQLException {
        return meetingMapperCustom.selectMeetingUserRole(uid,mid);
    }

    @Override
    public List<User> findManageUserList(Long uid) throws SQLException {
        return null;
    }

    @Override
    public Long saveReleaseMeeting(Meeting meeting,List<Long> uids,Long issuer,Long chair,Long recorder) throws SQLException {
        meetingMapperCustom.insertSelective(meeting);
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
            meetingUserMapper.insertSelective(key);
        }

        {
            key = new MeetingUser();
            key.setUid(chair);
            key.setMid(mid);
            key.setMrole("chair");
            meetingUserMapper.insertSelective(key);
        }

        {
            key = new MeetingUser();
            key.setUid(recorder);
            key.setMid(mid);
            key.setMrole("recorder");
            meetingUserMapper.insertSelective(key);
        }

        return mid;

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
    public void saveMeetingAnnexFile(List<MeetingFile> fileList, Long mid, boolean type) throws SQLException {
        MeetingAnnex meetingAnnex;
        for (MeetingFile meetingFile : fileList){
            meetingAnnex = new MeetingAnnex();
            meetingAnnex.setName(meetingFile.getName());
            meetingAnnex.setFileUrl(meetingFile.getUrl());
            meetingAnnex.setType(type);
            meetingAnnex.setMid(mid);
            meetingAnnexMapper.insertSelective(meetingAnnex);
        }

    }

    @Override
    public MeetingVo findMeetingInformationByMid(Long mid) throws SQLException {
        return null;
    }

    @Override
    public void removeMeetingAnnexFileByFid(Long fid) throws SQLException {

    }

    @Override
    public void remindQueue(List<Long> userList, Long mid, Date meetingStartTime) throws SQLException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        //开线程加载用户提醒
        for (Long uid : userList){
            //用户id查已经开启的个性提醒
            RemindExample example = new RemindExample();
            example.createCriteria().andUidEqualTo(uid).andRenableEqualTo(true);
            List<Remind> remindList = remindMapper.selectByExample(example);
            //将会议和用户提醒加入提醒队列
            for (Remind remind : remindList){
                //计算会议提醒时间
                MeetingRemind meetingRemind = new MeetingRemind();
                meetingRemind.setMid(mid);
                meetingRemind.setRemindtype(remind.getRof());
                meetingRemind.setUid(remind.getUid());

                byte of = remind.getRtype();
                Integer param = remind.getRparam();
                calendar.setTime(meetingStartTime);
                if (of == 0){//分钟
                    calendar.add(Calendar.MINUTE,param*-1);
                }else if (of == 1){
                    calendar.add(Calendar.HOUR,param*-1);
                }else if (of == 2){
                    calendar.add(Calendar.DAY_OF_MONTH,param*-1);
                }
                meetingRemind.setRemindtime(calendar.getTime());
                //插入
                meetingRemindMapper.insertSelective(meetingRemind);
            }
        }
    }
}
