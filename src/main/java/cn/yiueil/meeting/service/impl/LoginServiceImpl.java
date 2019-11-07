package cn.yiueil.meeting.service.impl;

import cn.yiueil.meeting.entity.Login;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.mapper.*;
import cn.yiueil.meeting.service.LoginService;
import cn.yiueil.meeting.service.PermissionService;
import cn.yiueil.meeting.vo.RJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
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
 * Create time 2019/9/3
 * message
 */
@Transactional
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapperCustom loginMapperCustom;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapperCustom userMapperCustom;

    @Autowired
    private PermissionService permissionService;


    @Override
    public User findUserById(String key, String passwd, RJ rj) throws SQLException {
        //账户密码验证，用户权限验证
        Login login = loginMapperCustom.loginByKey(key, passwd);
        if (login != null){
            List<String> permissions = permissionService.findPermissionByUid(login.getId());
            if (!permissions.contains("use")){
                rj.setMsg("无使用权限");
                return null;
            }
            User user = userMapper.selectByPrimaryKey(login.getId());
            if (!login.getIslogin()){
                loginMapperCustom.loginStatusUpdate(login.getId());
                rj.setMsg("登录成功");
                return user;

            }else{
                rj.setMsg("用户已登陆");
                return user;
            }

        }else{
            rj.setMsg("账号或者密码错误");
            return null;
        }

    }

    @Override
    public boolean insertUser(Login login) throws SQLException {
        User user = new User();
        user.setPhone(login.getPhone());
        user.setName(login.getName());
        user.setMail(login.getMail());

        if (userMapper.insertSelective(user)!=1){
            return false;
        }
        //用户插入♂ 成功，设置密码
        Long uid = userMapperCustom.getLastId();
        permissionService.saveUserRole(uid,1L);
        if (uid!=0){
            User newuser = userMapperCustom.selectByPrimaryKey(uid);

            login.setId(newuser.getId());
            login.setPhone(newuser.getPhone());
            login.setMail(newuser.getMail());
            login.setName(newuser.getName());
            loginMapperCustom.insertSelective(login);

            return true;
        }else
            return false;

    }

    @Override
    public boolean nameCheck(String name) throws SQLException {
        return loginMapperCustom.nameCheck(name) == 1;
    }

    @Override
    public boolean phoneCheck(String phone)throws SQLException {
        return loginMapperCustom.phoneCheck(phone) == 1;
    }

    @Override
    public boolean mailCheck(String mail)throws SQLException {
        return loginMapperCustom.mailCheck(mail) == 1;
    }


}
