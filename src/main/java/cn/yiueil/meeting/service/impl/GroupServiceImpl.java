package cn.yiueil.meeting.service.impl;

import cn.yiueil.meeting.entity.*;
import cn.yiueil.meeting.mapper.*;
import cn.yiueil.meeting.service.GroupService;
import cn.yiueil.meeting.vo.GroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * message
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
 * Create time 2019/9/29
 */
@Service
@Transactional
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupMapperCustom groupMapperCustom;

    @Autowired
    private UserGroupMapper userGroupMapper;

    @Autowired
    private MyMapper myMapper;

    @Autowired
    private UserMapperCustom userMapperCustom;
    @Override
    public String roleTest(Long uid, Long gid) throws SQLException {
        UserGroupKey userGroupKey = new UserGroupKey();
        userGroupKey.setGid(gid);
        userGroupKey.setUid(uid);
        UserGroup userGroup = userGroupMapper.selectByPrimaryKey(userGroupKey);
        return userGroup.getUrole();
    }

    @Override
    public List<GroupVo> findManageGroupList(Long uid) throws SQLException {
        return groupMapperCustom.selectGroupVoByUid(uid);
    }

    @Override
    public List<GroupVo> findGroup(Group groupFilter) throws SQLException {
        return groupMapperCustom.selectGroupByFilter(groupFilter);
    }

    @Override
    public List<User> findUserByGidList(Long gid) throws SQLException {
        return userMapperCustom.findUserByGidList(gid);
    }


    @Override
    public List<Group> findGroupByUserList(Long uid, boolean urole) throws SQLException {
        return null;
    }


    @Override
    public void removeGroupByGid(Long gid) throws SQLException {
            groupMapperCustom.deleteByPrimaryKey(gid);
    }

    @Override
    public Long saveNewGroup(Long uid, Group newGroup) throws SQLException {
            Long gid;
            groupMapperCustom.insertSelective(newGroup);
            UserGroup userGroup = new UserGroup();
            userGroup.setUid(uid);
            gid = myMapper.selectMaxId();
            userGroup.setGid(gid);
            userGroup.setUrole("owner");
            System.out.println(userGroupMapper.insertSelective(userGroup));
            return gid;
    }

    @Override
    public void modifyGroupInformation(Group group) throws SQLException {
            groupMapperCustom.updateByPrimaryKeySelective(group);
    }

    @Override
    public void modifyGroupUserRole(Long uid, Long gid, String groupRole) throws SQLException {
            UserGroup userGroup = new UserGroup();
            userGroup.setUrole(groupRole);
            userGroup.setGid(gid);
            userGroup.setUid(uid);
            userGroupMapper.updateByPrimaryKey(userGroup);
    }

    @Override
    public void modifyGroupAddUser(Long uid, Long gid) throws SQLException {
            UserGroup userGroup = new UserGroup();
            userGroup.setUid(uid);
            userGroup.setGid(gid);
            userGroup.setUrole("user");
            userGroupMapper.insert(userGroup);
    }

    @Override
    public void modifyGroupAddUserList(List<Long> uids, Long gid) throws SQLException {
            for (Long uid :uids){//可以优化的点,一次性插入
                this.modifyGroupAddUser(uid,gid);
            }
    }

    @Override
    public void removeUserInGroup(Long uid, Long gid) throws SQLException {
        UserGroupKey key = new UserGroupKey();
        key.setUid(uid);
        key.setGid(gid);
        userGroupMapper.deleteByPrimaryKey(key);
    }
}
