package cn.yiueil.meeting.entity;

public class MeetingAnnex {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_meeting_annex.id
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_meeting_annex.mid
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    private Long mid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_meeting_annex.file_url
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    private String fileUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_meeting_annex.type
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    private Boolean type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_meeting_annex.id
     *
     * @return the value of t_meeting_annex.id
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_meeting_annex.id
     *
     * @param id the value for t_meeting_annex.id
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_meeting_annex.mid
     *
     * @return the value of t_meeting_annex.mid
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public Long getMid() {
        return mid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_meeting_annex.mid
     *
     * @param mid the value for t_meeting_annex.mid
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public void setMid(Long mid) {
        this.mid = mid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_meeting_annex.file_url
     *
     * @return the value of t_meeting_annex.file_url
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_meeting_annex.file_url
     *
     * @param fileUrl the value for t_meeting_annex.file_url
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_meeting_annex.type
     *
     * @return the value of t_meeting_annex.type
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public Boolean getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_meeting_annex.type
     *
     * @param type the value for t_meeting_annex.type
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public void setType(Boolean type) {
        this.type = type;
    }
}