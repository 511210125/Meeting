package cn.yiueil.meeting.service;

import cn.yiueil.meeting.entity.Group;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.vo.GroupVo;

import java.util.List;

/**
 *
 * __/\\\________/\\\____________/\\\\\\\\\\\_____________________________________________________________________________/\\\\\\________
 * _\///\\\____/\\\/____________\/////\\\///_____________________________________________________________________________\////\\\________
 * ___\///\\\/\\\/__________________\/\\\_________________________________________________________________/\\\______________\/\\\________
 * _____\///\\\/____________________\/\\\________________/\\\____/\\\_______________/\\\\\\\\\\____________\///______________\/\\\________
 * _______\/\\\_____________________\/\\\_______________\/\\\___\/\\\_____________/\\\/////////____________/\\\______________\/\\\________
 * _______\/\\\_____________________\/\\\_______________\/\\\___\/\\\____________/\\\\\\\\\\_______________\/\\\_____________\/\\\________
 * _______\/\\\_____________________\/\\\_______________\/\\\___\/\\\___________\//\\///////_______________\/\\\_____________\/\\\________
 * _______\/\\\__________________/\\\\\\\\\\\___________\//\\\\\\\\\_____________\//\\\\\\\\\\\\\___________\/\\\____________/\\\\\\\\\\\\\_
 * _______\///__________________\///////////_____________\/////////_______________\/////////////____________\///____________\/////////////__
 * Create by YIueil
 * Create time 2019/9/5
 * message 小组做主体，用户做宾
 * save 插
 * remove 删
 * modify 改
 * find
 * find***List
 */
public interface GroupService {

    /**
     * 操作权限检查,使用于小组敏感操作
     * @param Uid
     * @param gid
     * @return
     */
    boolean roleTest(Long Uid, Long gid);

    /**
     * 按条件找小组,懒加载小组成员
     * @param groupFilter
     * @return
     */
    public List<Group> findGroup(Group groupFilter);

    /**
     * 查询某小组成员
     * @param gid
     * @return
     */
    public List<User> findUserByGidList(Long gid);

    /**
     * 查询某人创建的小组
     * @param uid
     * @return
     */
    public List<Group> findCreateByUserGroupList(Long uid);

    /**
     * 查询某人所管理或所在的小组
     * @param uid
     * @param urole 用户是否具有管理权限,true或false
     * @return
     */
    public List<Group> findGroupByUserList(Long uid,boolean urole);

    /**
     * 查看小组信息,懒加载小组用户
     * @return
     */
    public GroupVo findGroupInformationByGid(Long gid);

    /**
     * 删除某小组？解散
     * @param gid
     */
    public void removeGroupByGid(Long gid);

    /**
     * 用户建立小组
     * @param uid
     * @param newGroup
     */
    public void saveNewGroup(Long uid, Group newGroup);

    /**
     * 修改小组信息
     * @param uid
     * @param group
     */
    public void modifyGroupInformation(Long uid,Group group);

    /**
     * 修改某人的小组角色,小组拥有者专用
     * @param uid
     * @param handler
     * @param groupRole
     */
    public void modifyGroupUserRole(Long uid,Long handler,String groupRole);

    //查询某个小组，考虑是否加入

    //某人加入该小组

    //某人退出该小组


}
