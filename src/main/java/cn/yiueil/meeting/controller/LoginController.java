package cn.yiueil.meeting.controller;

import cn.yiueil.meeting.entity.Login;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.service.LoginService;
import cn.yiueil.meeting.util.StringUtil;
import cn.yiueil.meeting.vo.RJ;
import cn.yiueil.meeting.vo.UserCustom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    LoginService loginService;


    /**
     *message
     *Create by YIueil
     *time 2019/9/4
     *state

     *参数 [key, passwd]
     *返还值 java.lang.Object

     */
    @PostMapping("/loginSubmit")
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
                String token = new Date().getTime()+ StringUtil.encode(user.getId().toString());

                rj.setToken(token);

                return rj;
            }

        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.toString());
            return "error";
        }
    }


    /**
     *message
     *Create by YIueil
     *time 2019/9/4
     *state

     *参数 [name, mail, phone, passwd]
     *返还值 java.lang.Object

     */
    @PostMapping("/rigisterSubmit")
    public Object rigisterSubmit(@RequestParam String name,
                           @RequestParam String mail,
                           @RequestParam String phone,
                           @RequestParam String passwd,
                           @RequestParam String code
                           ){
        RJ rj=new RJ("注册信息已存在或者有误啊");
        Login login;
        try{
            //注册，，发邮箱，注册成功，直接返回登陆页面
            login=new Login();
            login.setMail(mail);
            login.setName(name);
            login.setPhone(phone);
            login.setPasswd(passwd);
            if (loginService.insertUser(login)){
                rj.setMsg("注册成功了,马上返回登陆界面试试咯");
            }
            return rj;
        }catch (Exception e){
            logger.error(e.toString());
            e.printStackTrace();
            return rj;
        }

    }

    @PostMapping("/sendMail")
    public boolean sendMail(@RequestParam String phone){
        if (true)//发送成功
        {

            return true;
        }else {//发送失败
            return false;
        }
    }


}
