package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.dto.MeetingCustom;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.entity.UserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserMapperCustom extends UserMapper {

    @Select("SELECT LAST_INSERT_ID()")
    Long getLastId();

    @Select("SELECT * FROM t_user WHERE id IN( SELECT uid FROM t_user_group WHERE gid = #{gid} ) ")
    List<User> findUserByGidList(Long gid);

}