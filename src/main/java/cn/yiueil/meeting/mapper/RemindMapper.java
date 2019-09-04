package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.entity.Remind;
import cn.yiueil.meeting.entity.RemindExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RemindMapper {
    long countByExample(RemindExample example);

    int deleteByExample(RemindExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Remind record);

    int insertSelective(Remind record);

    List<Remind> selectByExample(RemindExample example);

    Remind selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Remind record, @Param("example") RemindExample example);

    int updateByExample(@Param("record") Remind record, @Param("example") RemindExample example);

    int updateByPrimaryKeySelective(Remind record);

    int updateByPrimaryKey(Remind record);
}