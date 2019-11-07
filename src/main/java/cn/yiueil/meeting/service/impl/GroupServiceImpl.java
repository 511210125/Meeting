package cn.yiueil.meeting.service.impl;

import cn.yiueil.meeting.entity.*;
import cn.yiueil.meeting.mapper.GroupMapper;
import cn.yiueil.meeting.mapper.MyMapper;
import cn.yiueil.meeting.mapper.UserGroupMapper;
import cn.yiueil.meeting.mapper.UserMapperCustom;
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
    private GroupMapper groupMapper;

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
    public List<Group> findGroup(Group groupFilter) throws SQLException {
        return null;
    }

    @Override
    public List<User> findUserByGidList(Long gid) throws SQLException {
        return userMapperCustom.findUserByGidList(gid);
    }

    @Override
    public List<Group> findCreateByUserGroupList(Long uid) throws SQLException {
        return null;
    }

    @Override
    public List<Group> findGroupByUserList(Long uid, boolean urole) throws SQLException {
        return null;
    }

    @Override
    public GroupVo findGroupInformationByGid(Long gid) throws SQLException {
        return null;
    }

    @Override
    public void removeGroupByGid(Long gid) throws SQLException {
            groupMapper.deleteByPrimaryKey(gid);
    }

    @Override
    public Long saveNewGroup(Long uid, Group newGroup) throws SQLException {
            Long gid;
            groupMapper.insertSelective(newGroup);
            UserGroup userGroup = new UserGroup();
            userGroup.setUid(uid);
            gid = myMapper.selectMaxId();
            userGroup.setGid(gid);
            userGroup.setUrole("owner");
            System.out.println(userGroupMapper.insertSelective(userGroup));
            return gid;
    }

    @Override
    public void modifyGroupInformation(Long uid, Group group) throws SQLException {

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
            for (Long uid :uids){
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
