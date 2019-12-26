package cn.yiueil.meeting.entity;

import java.util.Date;

public class MeetRemindKey {
    private Long id;

    private Date remindtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRemindtime() {
        return remindtime;
    }

    public void setRemindtime(Date remindtime) {
        this.remindtime = remindtime;
    }
}