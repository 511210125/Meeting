package cn.yiueil.meeting.entity;

public class MeetingUserKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_meeting_user.mid
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    private Long mid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_meeting_user.uid
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    private Long uid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_meeting_user.mid
     *
     * @return the value of t_meeting_user.mid
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public Long getMid() {
        return mid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_meeting_user.mid
     *
     * @param mid the value for t_meeting_user.mid
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public void setMid(Long mid) {
        this.mid = mid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_meeting_user.uid
     *
     * @return the value of t_meeting_user.uid
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public Long getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_meeting_user.uid
     *
     * @param uid the value for t_meeting_user.uid
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }
}