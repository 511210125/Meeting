package cn.yiueil.meeting.controller;

import cn.yiueil.meeting.dto.MeetingCustom;
import cn.yiueil.meeting.mapper.MeetingMapperCustom;
import cn.yiueil.meeting.vo.RJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Map;

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
 * Create time 2019/8/31
 * message  会议相关
 */
@RestController
public class MeetingController {
    @Autowired
    private MeetingMapperCustom meetingMapperCustom;


    /**
     * 发布会议
     * @param meetingCustom 会议信息
     * @return
     */
    @PostMapping("releaseMeetingSubmit")
    public RJ releaseMeetingSubmit(MeetingCustom meetingCustom){
        return null;
    }

    /**
     * 取消会议
     * @param uid 用户id
     * @param mid 会议id
     * @return
     */
    @PostMapping("cancelledMeeting")
    public RJ cancelledMeetingSubmit(@RequestParam Long uid,@RequestParam Long mid){
        return null;
    }

    /**
     * 会议延期
     * @param uid 用户id
     * @param mid 会议id
     * @param newDate  延期后的时间
     * @return
     */
    @PostMapping("meetingPostponed")
    public RJ meetingPostponed(@RequestParam Long uid,@RequestParam Long mid,@RequestParam Date newDate){
        return null;
    }

    //会议开始
    @PostMapping("meetingStart")
    public RJ meetingStart(){
        return null;
    }

    /**
     *  会议记录录音上传
     * @param audio 音频文件
     * @param format 是否转为文本保存
     * @return
     */
    @PostMapping("audioFileUpload")
    public RJ audioFileUpload(MultipartFile audio,Boolean format){
        return null;
    }
}
