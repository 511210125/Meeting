package cn.yiueil.meeting.entity;

public class Permission {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_permission.id
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_permission.name
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_permission.msg
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    private String msg;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_permission.id
     *
     * @return the value of t_permission.id
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_permission.id
     *
     * @param id the value for t_permission.id
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_permission.name
     *
     * @return the value of t_permission.name
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_permission.name
     *
     * @param name the value for t_permission.name
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_permission.msg
     *
     * @return the value of t_permission.msg
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public String getMsg() {
        return msg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_permission.msg
     *
     * @param msg the value for t_permission.msg
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}