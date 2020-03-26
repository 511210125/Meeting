package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.entity.Remind;
import cn.yiueil.meeting.entity.RemindExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RemindMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_remind
     *
     * @mbg.generated Fri Mar 20 21:05:23 CST 2020
     */
    long countByExample(RemindExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_remind
     *
     * @mbg.generated Fri Mar 20 21:05:23 CST 2020
     */
    int deleteByExample(RemindExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_remind
     *
     * @mbg.generated Fri Mar 20 21:05:23 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_remind
     *
     * @mbg.generated Fri Mar 20 21:05:23 CST 2020
     */
    int insert(Remind record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_remind
     *
     * @mbg.generated Fri Mar 20 21:05:23 CST 2020
     */
    int insertSelective(Remind record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_remind
     *
     * @mbg.generated Fri Mar 20 21:05:23 CST 2020
     */
    List<Remind> selectByExample(RemindExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_remind
     *
     * @mbg.generated Fri Mar 20 21:05:23 CST 2020
     */
    Remind selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_remind
     *
     * @mbg.generated Fri Mar 20 21:05:23 CST 2020
     */
    int updateByExampleSelective(@Param("record") Remind record, @Param("example") RemindExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_remind
     *
     * @mbg.generated Fri Mar 20 21:05:23 CST 2020
     */
    int updateByExample(@Param("record") Remind record, @Param("example") RemindExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_remind
     *
     * @mbg.generated Fri Mar 20 21:05:23 CST 2020
     */
    int updateByPrimaryKeySelective(Remind record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_remind
     *
     * @mbg.generated Fri Mar 20 21:05:23 CST 2020
     */
    int updateByPrimaryKey(Remind record);
}