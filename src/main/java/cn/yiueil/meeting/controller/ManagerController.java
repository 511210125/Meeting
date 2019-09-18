package cn.yiueil.meeting.controller;

import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.service.ManageService;
import cn.yiueil.meeting.util.StringUtil;
import cn.yiueil.meeting.vo.RJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

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
 * Create time 2019/9/5
 * message 后台管理控制器，后台管理专用
 */
@Controller
public class ManagerController {
    @Autowired
    private ManageService manageService;

    //后台管理员登陆
    @PostMapping("/manageLoginSubmit")
    public String manageLoginSubmit(@RequestParam String key,
                                    @RequestParam String passwd,
                                    Map<String,String> result, HttpSession session){
        passwd = StringUtil.encode(passwd);
        RJ rj =new RJ();
        manageService.findManagerByKeyAndPasswd(key,passwd,rj);
        result.put("msg",rj.getMsg());
        //这里登陆鸭
        if (rj.getResult()!=null){
            session.setAttribute("manager",rj.getResult());
            //重定向防止重新提交表单
            return "redirect:manageMain";
        }else{
            return "login";
        }
    }

    //后台管理员退出
    @GetMapping("/managerSignOut")
    public String managerSignOut(HttpSession session){
        User manager = (User)session.getAttribute("manager");
        System.out.println(manager.getName() + "离开了");
        session.removeAttribute("manager");
        return "login";
    }

}
