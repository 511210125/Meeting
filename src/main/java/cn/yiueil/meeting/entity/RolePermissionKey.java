package cn.yiueil.meeting.entity;

public class RolePermissionKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role_permission.rid
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    private Long rid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role_permission.pid
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    private Long pid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role_permission.rid
     *
     * @return the value of t_role_permission.rid
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public Long getRid() {
        return rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role_permission.rid
     *
     * @param rid the value for t_role_permission.rid
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public void setRid(Long rid) {
        this.rid = rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role_permission.pid
     *
     * @return the value of t_role_permission.pid
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public Long getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role_permission.pid
     *
     * @param pid the value for t_role_permission.pid
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }
}