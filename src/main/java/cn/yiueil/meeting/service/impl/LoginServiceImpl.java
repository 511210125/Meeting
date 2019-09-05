package cn.yiueil.meeting.service.impl;

import cn.yiueil.meeting.entity.Login;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.mapper.LoginMapperCustom;
import cn.yiueil.meeting.mapper.UserMapper;
import cn.yiueil.meeting.mapper.UserMapperCustom;
import cn.yiueil.meeting.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapperCustom loginMapperCustom;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapperCustom userMapperCustom;

    @Override
    public User findUserById(String key,String passwd) throws Exception{
        Login login = loginMapperCustom.loginByKey(key, passwd);

        if (login != null){
            User user = userMapper.selectByPrimaryKey(login.getId());
            if (login.getIslogin()){

                loginMapperCustom.loginStatusUpdate(login.getId());
                return user;

            }else{

                return user;

            }

        }else
            return null;
    }

    @Override
    public boolean insertUser(Login login) throws Exception {
        User user = new User();
        user.setPhone(login.getPhone());
        user.setName(login.getName());
        user.setMail(login.getMail());

        if (userMapper.insert(user)!=1){
            return false;
        }
        //用户插入♂ 成功，设置密码
        Long uid = userMapperCustom.getLastId();
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


}
