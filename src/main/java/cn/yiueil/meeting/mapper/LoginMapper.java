package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.entity.Login;
import cn.yiueil.meeting.entity.LoginExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    long countByExample(LoginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int deleteByExample(LoginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int insert(Login record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int insertSelective(Login record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    List<Login> selectByExample(LoginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    Login selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int updateByExampleSelective(@Param("record") Login record, @Param("example") LoginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int updateByExample(@Param("record") Login record, @Param("example") LoginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int updateByPrimaryKeySelective(Login record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login
     *
     * @mbg.generated Sat Mar 14 22:42:03 CST 2020
     */
    int updateByPrimaryKey(Login record);
}