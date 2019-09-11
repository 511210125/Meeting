package cn.yiueil.meeting.service.impl;

import cn.yiueil.meeting.entity.Login;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.mapper.LoginMapperCustom;
import cn.yiueil.meeting.mapper.PermissionMapperCustom;
import cn.yiueil.meeting.mapper.UserMapper;
import cn.yiueil.meeting.service.ManageService;
import cn.yiueil.meeting.vo.RJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
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
 * Create time 2019/9/6
 * message
 */
@Service
public class ManageServiceImpl implements ManageService {
    @Autowired
    private LoginMapperCustom loginMapperCustom;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapperCustom permissionMapperCustom;

    @Override
    public void findManagerByKeyAndPasswd(String key, String passwd,RJ rj) {
        //账户密码验证，用户权限验证
        Login login = loginMapperCustom.loginByKey(key, passwd);
        if (login != null){
            //查询用户权限
            List<String> permissions = permissionMapperCustom.selectByPrimaryUserId(login.getId());
            if (!permissions.contains("manage")){
                rj.setMsg("无使用权限");
                return;
            }
            rj.setOb(userMapper.selectByPrimaryKey(login.getId()));
            if (!login.getIslogin()){
                loginMapperCustom.loginStatusUpdate(login.getId());
                rj.setMsg("管理员登录成功");
            }else{
                rj.setMsg("管理员登陆中");
            }

        }else{
            rj.setMsg("账号或者密码错误");
        }

    }

}
