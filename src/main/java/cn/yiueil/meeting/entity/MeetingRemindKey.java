package cn.yiueil.meeting.entity;

import java.util.Date;

public class MeetingRemindKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_meeting_remind.id
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_meeting_remind.remindtime
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    private Date remindtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_meeting_remind.id
     *
     * @return the value of t_meeting_remind.id
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_meeting_remind.id
     *
     * @param id the value for t_meeting_remind.id
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_meeting_remind.remindtime
     *
     * @return the value of t_meeting_remind.remindtime
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public Date getRemindtime() {
        return remindtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_meeting_remind.remindtime
     *
     * @param remindtime the value for t_meeting_remind.remindtime
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public void setRemindtime(Date remindtime) {
        this.remindtime = remindtime;
    }
}