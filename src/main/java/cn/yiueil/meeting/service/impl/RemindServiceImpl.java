package cn.yiueil.meeting.service.impl;

import cn.yiueil.meeting.dto.MeetingRemindCustom;
import cn.yiueil.meeting.entity.MeetingRemindExample;
import cn.yiueil.meeting.job.UserRemindJob;
import cn.yiueil.meeting.mapper.MeetingRemindMapperCustom;
import cn.yiueil.meeting.service.RemindService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * message
 * __   __ ____            _  __
 * \ \ / /|_ _| __ __ ___ (_)| |
 * \ V /  | | | || |/ -_)| || |
 * |_|  |___| \_,_|\___||_||_|
 * create by YIueil on time 2020/3/26
 */
@Service
@Transactional
public class RemindServiceImpl implements RemindService {
    @Autowired
    private Scheduler Scheduler;

    @Autowired
    private MeetingRemindMapperCustom meetingRemindMapperCustom;

    @Override
    @Scheduled(fixedRate = 86400000)
    public void SchedulingDay() {
        //仅仅查询当天需要通知的用户,间隔越大服务器压力应该更小
        MeetingRemindExample example = new MeetingRemindExample();
        long current = System.currentTimeMillis();    //当前时间毫秒数
        long zeroT = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();  //今天零点零分零秒的毫秒数
        long endT = zeroT + 24 * 60 * 60 * 1000 - 1;  //今天23点59分59秒的毫秒数 }
        example.createCriteria().andRemindtimeBetween(new Date(zeroT), new Date(endT));
        List<MeetingRemindCustom> meetingRemindList = meetingRemindMapperCustom.selectMeetingRemindDetailListByDay(example);
        //定时任务发邮箱
        for (MeetingRemindCustom mr : meetingRemindList) {
            //设置任务
            JobDetail job = newJob(UserRemindJob.class)
                    .withIdentity(mr.getId().toString(), "JobGroup")
                    .usingJobData("mail",mr.getUser().getMail())
                    .usingJobData("phone",mr.getUser().getPhone())
                    .usingJobData("title",mr.getMeeting().getTitle())
                    .usingJobData("place",mr.getMeeting().getPlace())
                    .usingJobData("remarks",mr.getMeeting().getRemarks())
                    .usingJobData("releaseTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(mr.getMeeting().getReleaseTime()))
                    .usingJobData("startTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(mr.getMeeting().getStartTime()))
                    .usingJobData("endTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(mr.getMeeting().getEndTime()))
                    .usingJobData("remindType",(int)mr.getRemindtype())
                    .build();
            //设置触发点
            SimpleTrigger trigger = (SimpleTrigger) newTrigger()
                    .withIdentity("trigger-"+mr.getId(), "RemindTriggerGroup")
                    .startAt(mr.getRemindtime())                     //设置提醒时间
                    .forJob(mr.getId().toString(), "JobGroup")    // identify job with name, group strings
                    .build();
            //任务设置触发点
            try {
                Scheduler.scheduleJob(job, trigger);
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
            //任务删除
          meetingRemindMapperCustom.deleteByPrimaryKey(mr.getId());
        }
    }
}
