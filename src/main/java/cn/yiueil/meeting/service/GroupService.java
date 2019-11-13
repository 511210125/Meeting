package cn.yiueil.meeting.service;

import cn.yiueil.meeting.entity.Group;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.vo.GroupVo;

import java.sql.SQLException;
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
     * @param uid
     * @param gid
     * @return
     * ok
     */
    String roleTest(Long uid, Long gid)throws SQLException;


    /**
     * 加载管理的用户群组，懒加载群组成员,需要复习一下resultMap
     * @param uid
     * @return
     * ok
     */
    List<GroupVo> findManageGroupList(Long uid)throws SQLException;


    /**
     * 按条件找小组List,懒加载小组成员(懒加载能大幅提升效率)
     * @param groupFilter
     * @return
     *
     */
    public List<GroupVo> findGroup(Group groupFilter)throws SQLException;

    /**
     * 查询某小组成员
     * @param gid
     * @return
     */
    public List<User> findUserByGidList(Long gid)throws SQLException;

    /**
     * 查询某人所管理或所在的小组
     * @param uid
     * @param urole 用户是否具有管理权限,true或false
     * @return
     */
    public List<Group> findGroupByUserList(Long uid,boolean urole)throws SQLException;

    /**
     * 删除某小组？解散
     * @param gid
     */
    public void removeGroupByGid(Long gid)throws SQLException;

    /**
     * 用户建立小组
     * @param uid
     * @param newGroup
     */
    public Long saveNewGroup(Long uid, Group newGroup)throws SQLException;

    /**
     * 修改小组信息
     * @param group
     */
    public void modifyGroupInformation(Group group)throws SQLException;

    /**
     * 修改某人的小组角色,小组拥有者专用
     * @param uid
     * @param gid
     * @param groupRole
     */
    public void modifyGroupUserRole(Long uid,Long gid,String groupRole)throws SQLException;

    /**
     * 某人加入该小组
     * @param uid
     */
    public void modifyGroupAddUser(Long uid,Long gid)throws SQLException;

    /**
     * 将一群人与的id与某组关联
     * @param uids
     * @param gid
     * @throws SQLException
     */
    public void modifyGroupAddUserList(List<Long> uids,Long gid)throws SQLException;

    /**
     * 某人退出该小组
     * @param uid
     */
    public void removeUserInGroup(Long uid,Long gid)throws SQLException;

}
