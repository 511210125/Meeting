package cn.yiueil.meeting.job;

import cn.yiueil.meeting.service.MailService;
import cn.yiueil.meeting.service.impl.MailServiceImpl;
import lombok.Setter;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.SpringHandlerInstantiator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * message
 * __   __ ____            _  __
 * \ \ / /|_ _| __ __ ___ (_)| |
 * \ V /  | | | || |/ -_)| || |
 * |_|  |___| \_,_|\___||_||_|
 * create by YIueil on time 2020/3/27
 */

public class UserRemindJob implements Job {

    @Autowired
    private MailServiceImpl mailService;

    //用户相关
    String mail;
    String phone;
    //会议相关
    String title;
    String place;
    String remarks;
    String releaseTime;
    String startTime;
    String endTime;
    //提醒相关
    byte remindType;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobKey key = jobExecutionContext.getJobDetail().getKey();

        JobDataMap dataMap = jobExecutionContext.getMergedJobDataMap();  // Note the difference from the previous example
        {
            //用户相关
            mail = dataMap.getString("mail");
            phone = dataMap.getString("phone");
            //会议相关
            title = dataMap.getString("title");
            place = dataMap.getString("place");
            remarks = dataMap.getString("remarks");
            releaseTime = dataMap.getString("releaseTime");
            startTime = dataMap.getString("startTime");
            endTime = dataMap.getString("endTime");
            //提醒相关
            remindType = (byte) dataMap.getInt("remindType");
        }


        System.err.println("来了");

        String mailContent ="<h2>"+title+"</h2>"+
                "会议地点:"+place+"<br>"+
                "发布时间:"+releaseTime+"<br>"+
                "会议时间:"+startTime + "-" + endTime +"<br>"+
                "会议备注:" + remarks;

        if (remindType == 0)
            mailService.sendHtmlMail(mail,"会议提醒: "+title, mailContent);
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setRemindType(byte remindType) {
        this.remindType = remindType;
    }
}
