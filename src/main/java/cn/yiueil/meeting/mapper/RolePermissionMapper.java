package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.entity.RolePermissionExample;
import cn.yiueil.meeting.entity.RolePermissionKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_permission
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    long countByExample(RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_permission
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int deleteByExample(RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_permission
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int deleteByPrimaryKey(RolePermissionKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_permission
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int insert(RolePermissionKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_permission
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int insertSelective(RolePermissionKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_permission
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    List<RolePermissionKey> selectByExample(RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_permission
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int updateByExampleSelective(@Param("record") RolePermissionKey record, @Param("example") RolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_permission
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int updateByExample(@Param("record") RolePermissionKey record, @Param("example") RolePermissionExample example);
}