package cn.yiueil.meeting.service.impl;

import cn.yiueil.meeting.entity.Login;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.mapper.LoginMapperCustom;
import cn.yiueil.meeting.mapper.UserMapper;
import cn.yiueil.meeting.service.LoginService;
import org.springframework.stereotype.Service;

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
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    LoginMapperCustom loginMapperCustom;

    @Resource
    UserMapper userMapper;

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


}
