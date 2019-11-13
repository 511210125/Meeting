package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.entity.Group;
import cn.yiueil.meeting.entity.GroupExample;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.vo.GroupVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupMapperCustom extends GroupMapper{

//       select * from t_user_group,t_group,t_user where t_user_group.`gid`=t_group.`id` and t_user_group.`uid`= t_user.`id` and gid in(
//           select gid from t_user_group where uid =1
//        )
    List<GroupVo> selectGroupVoByUid(Long uid);

    /**
     * 查找管辖范围内的用户
     * @param uid
     * @return
     */
    List<User> selectManageUserByUid(Long uid);

    /**
     * 按创建人id查会议详情,懒加载User信息
     * @param uid
     * @return
     */
    List<GroupVo> selectGroupVoByCreateUid(Long uid);

    /**
     * 通用的小组查询,可按小组的各项属性查
     * @param group
     * @return
     */
    List<GroupVo> selectGroupByFilter(Group group);
}