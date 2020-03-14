package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.entity.UserGroup;
import cn.yiueil.meeting.entity.UserGroupExample;
import cn.yiueil.meeting.entity.UserGroupKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserGroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_group
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    long countByExample(UserGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_group
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int deleteByExample(UserGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_group
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int deleteByPrimaryKey(UserGroupKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_group
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int insert(UserGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_group
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int insertSelective(UserGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_group
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    List<UserGroup> selectByExample(UserGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_group
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    UserGroup selectByPrimaryKey(UserGroupKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_group
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int updateByExampleSelective(@Param("record") UserGroup record, @Param("example") UserGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_group
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int updateByExample(@Param("record") UserGroup record, @Param("example") UserGroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_group
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int updateByPrimaryKeySelective(UserGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_group
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int updateByPrimaryKey(UserGroup record);
}