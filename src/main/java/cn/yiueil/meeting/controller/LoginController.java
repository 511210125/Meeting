package cn.yiueil.meeting.controller;

import cn.yiueil.meeting.entity.Login;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.service.LoginService;
import cn.yiueil.meeting.service.MailService;
import cn.yiueil.meeting.util.CodeGenerator;
import cn.yiueil.meeting.util.StringUtil;
import cn.yiueil.meeting.vo.RJ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
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
 * message 登陆注册模块,登陆注册控制器
 */
@RestController
@CrossOrigin
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LoginService loginService;

    @Autowired
    private MailService mailService;

    /**
     *message
     *Create by YIueil
     *time 2019/9/4
     *state

     *参数 [key, passwd]
     *返还值 java.lang.Object

     */
    @PostMapping("/loginSubmit")
    public Object loginSubmit(@RequestParam String key,
                        @RequestParam String passwd){
        RJ rj;
        try{
            rj=new RJ();
            passwd = StringUtil.encode(passwd);
            User user=loginService.findUserById(key,passwd,rj);
            if (user == null){
                return rj;
            }else{
                rj.setResult(user);
                //token生成
                String token = new Date().getTime()+ StringUtil.encode(user.getId().toString());
                //后台生成token使用时间戳+用户id+md5加密后的用户密码,整体再对称加密一波.待实现

                //前台每次请求发送用户id，和token,同时判断时间是否超时，以及用户id使用md5加密后是否和用户一致
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
    @PostMapping("/registerSubmit")
    public Object registerSubmit(@Valid Login login){
        RJ rj=new RJ();
        try{
            //注册，，发邮箱，注册成功，直接返回登陆页面

            //密码MD5加密
            login.setPasswd(StringUtil.encode(login.getPasswd()));
            if (loginService.insertUser(login)){
                rj.setMsg("注册成功了,马上返回登陆界面试试咯");
            }
            return rj;
        }catch (Exception e){
            logger.error(e.toString());
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    /**
     *message
     *Create by YIueil
     *time 2019/9/5
     *state

     *参数 [mail]
     *返还值 java.lang.Object

     */
    @GetMapping("/sendMail")
    public String sendMail(@RequestParam String mail){
        //验证码强度6
        String code = CodeGenerator.code(6);

        try{//发送邮箱验证码
            String finalCode = code;
            new Thread() {
                public void run() {
                        mailService.sendSimpleMail(mail,"智能会议助理", finalCode);
                }
            }.start();//开启线程
        }catch (MailException me){
            logger.error(me.toString());
        }

        //MD5加密验证码,加密后为128位（bit），按照16进制（4位一个16进制数）编码后，就成了32个字符，而不是32位
        code = StringUtil.encode(code);
        return code;
    }

    /**
      *message 三个是否存在校验，提高用户感知
      *Create by YIueil
      *time 2019/9/6
      */
    @GetMapping("/nameCheck")
    public boolean nameCheck(@RequestParam String name){
        try {
            return loginService.nameCheck(name);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @GetMapping("/phoneCheck")
    public boolean phoneCheck(@RequestParam String phone){
        try {
            return loginService.phoneCheck(phone);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @GetMapping("/mailCheck")
    public boolean mailCheck(@RequestParam String mail){
        try {
            return loginService.mailCheck(mail);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @GetMapping("/keyCheck")
    public boolean keyCheck(@RequestParam String key){
        try {
            if (nameCheck(key))
                return true;
            else if (phoneCheck(key))
                return true;
            else return mailCheck(key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
