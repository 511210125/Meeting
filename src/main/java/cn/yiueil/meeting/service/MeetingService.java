package cn.yiueil.meeting.service;

import cn.yiueil.meeting.entity.Group;
import cn.yiueil.meeting.entity.Meeting;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.vo.GroupVo;
import cn.yiueil.meeting.vo.MeetingVo;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.List;

/**
 *
 *
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
 * message 会议的服务鸭
 */
public interface MeetingService {

    /**
     * 查询用户在某会议中的权限
     * @param mid 会议id
     * @param uid 用户id
     * @return
     */
    String UserMeetingRoleTest(Long mid,Long uid)throws SQLException;



    List<User> findManageUserList(Long uid)throws SQLException;

    /**
     * 会议发起,参数为会议中各种信息
     * @param meeting
     * @param uids
     * @throws SQLException
     */
    public void saveReleaseMeeting(Meeting meeting,List<Long> uids,Long issuer,Long chair,Long recorder) throws SQLException;

    /**
     * 会议启动,通知相关人参会,修改会议状态
     * @param mid
     */
    public void modifyMeetingStart(Long mid)throws SQLException;

    /**
     * 会议终止
     * @param mid
     */
    public void modifyMeetingStop(Long mid)throws SQLException;

    /**
     * 会议录音保存
     * @param audio
     * @param mid
     * @param isTransform 是否转文本保存
     */
    public void saveMeetingAudioFile(MultipartFile audio,Long mid,boolean isTransform)throws SQLException;

    /**
     * 会议附件上传
     * @param file
     * @param mid
     * @param type 是会前文件还是会议记录文件
     */
    public void saveMeetingAnnexFile(MultipartFile file,Long mid,boolean type)throws SQLException;

    /**
     * 查看会议信息以及会议附件(权限检查)，懒加载参会人信息
     * @param mid
     * @return
     */
    public MeetingVo findMeetingInformationByMid(Long mid)throws SQLException;

    /**
     * 会议相关文件删除(权限必须)
     * @param fid
     */
    public void removeMeetingAnnexFileByFid(Long fid)throws SQLException;


}
