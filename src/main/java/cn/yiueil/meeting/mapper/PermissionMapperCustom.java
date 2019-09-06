package cn.yiueil.meeting.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapperCustom extends PermissionMapper{

    @Select("    SELECT\n" +
            "            NAME\n" +
            "    FROM\n" +
            "  `t_permission`\n" +
            "    WHERE id IN\n" +
            "            (SELECT\n" +
            "                     pid\n" +
            "  FROM\n" +
            "                     `t_role_permission`\n" +
            "                     WHERE rid =\n" +
            "                     (SELECT\n" +
            "                     rid\n" +
            "                     FROM\n" +
            "                     `t_user_role`\n" +
            "                     WHERE `t_user_role`.uid = #{id}))")
    List<String> selectByPrimaryUserId(Long id);

}