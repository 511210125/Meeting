package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.entity.Remind;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * message
 * __   __ ____            _  __
 * \ \ / /|_ _| __ __ ___ (_)| |
 * \ V /  | | | || |/ -_)| || |
 * |_|  |___| \_,_|\___||_||_|
 * create by YIueil on time 2020/3/20
 */
public interface RemindMapperCustom extends RemindMapper {
        @Select("select * from t_remind where uid = #{uid}")
        List<Remind> selectRemindListByUid(Long uid);

        @Select("delete from t_remind where uid = #{uid} and id = #{rid}")
        void deleteRemindById(@Param("rid") Long rid,@Param("uid") Long uid);
}
