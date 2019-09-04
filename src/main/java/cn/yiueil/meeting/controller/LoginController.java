package cn.yiueil.meeting.controller;

import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.service.LoginService;
import cn.yiueil.meeting.util.StringUtil;
import cn.yiueil.meeting.vo.RJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

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
@RestController
public class LoginController {
    @Resource
    LoginService loginService;

    @PostMapping("/login")
    public Object login(@RequestParam String key,
                        @RequestParam String passwd){
        RJ rj;
        try{
            User user=loginService.findUserById(key,passwd);
            if (user == null){
                return new RJ("账号或者密码错误");
            }else{
                rj=new RJ(user);
                //token生成
                String token=user.getId().toString()+"YIueil"+new Date().getTime()+ StringUtil.encode(user.getId().toString());

                return rj;
            }

        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }

}
