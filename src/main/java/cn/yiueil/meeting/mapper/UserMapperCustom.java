package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.entity.UserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapperCustom extends UserMapper {

    @Select("SELECT LAST_INSERT_ID()")
    Long getLastId();

}