package cn.yiueil.meeting.entity;

import java.util.Date;

public class MeetingRemind {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_meeting_remind.id
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_meeting_remind.remindtime
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    private Date remindtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_meeting_remind.uid
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    private Long uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_meeting_remind.mid
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    private Long mid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_meeting_remind.remindtype
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    private Byte remindtype;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_meeting_remind.id
     *
     * @return the value of t_meeting_remind.id
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
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
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
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
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
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
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    public void setRemindtime(Date remindtime) {
        this.remindtime = remindtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_meeting_remind.uid
     *
     * @return the value of t_meeting_remind.uid
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_meeting_remind.uid
     *
     * @param uid the value for t_meeting_remind.uid
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_meeting_remind.mid
     *
     * @return the value of t_meeting_remind.mid
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    public Long getMid() {
        return mid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_meeting_remind.mid
     *
     * @param mid the value for t_meeting_remind.mid
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    public void setMid(Long mid) {
        this.mid = mid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_meeting_remind.remindtype
     *
     * @return the value of t_meeting_remind.remindtype
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    public Byte getRemindtype() {
        return remindtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_meeting_remind.remindtype
     *
     * @param remindtype the value for t_meeting_remind.remindtype
     *
     * @mbg.generated Wed Mar 25 13:40:37 CST 2020
     */
    public void setRemindtype(Byte remindtype) {
        this.remindtype = remindtype;
    }
}