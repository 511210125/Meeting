package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.entity.Group;
import cn.yiueil.meeting.entity.GroupExample;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.vo.GroupVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupMapperCustom extends GroupMapper{
    List<GroupVo> selectGroupVoByUid(Long uid);

    List<User> selectManageUserByUid(Long uid);

}