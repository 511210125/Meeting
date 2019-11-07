package cn.yiueil.meeting.service.impl;

import cn.yiueil.meeting.entity.UserRole;
import cn.yiueil.meeting.mapper.PermissionMapperCustom;
import cn.yiueil.meeting.mapper.UserMapper;
import cn.yiueil.meeting.mapper.UserRoleMapper;
import cn.yiueil.meeting.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 * Create time 2019/9/18
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapperCustom permissionMapperCustom;
    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public List<String> findPermissionByUid(Long uid) {
        return permissionMapperCustom.selectByPrimaryUserId(uid);
    }

    @Override
    public void saveUserRole(Long uid,Long rid) {
        UserRole userRole = new UserRole();
        userRole.setUid(uid);
        userRole.setRid(rid);
        userRoleMapper.insert(userRole);
    }
}
