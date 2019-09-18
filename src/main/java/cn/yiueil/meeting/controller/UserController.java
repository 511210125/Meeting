package cn.yiueil.meeting.controller;

import cn.yiueil.meeting.vo.RJ;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
 * message  普通用户使用功能
 */
@RestController
public class UserController {
    //显示用户参加的会议
    @GetMapping("showUserMeetingList")
    public RJ showUserMeetingList(){
        return null;
    }
    //显示用户的个人信息
    @GetMapping("showUserInfo")
    public RJ showUserInfo(){
        return null;
    }
    //上传头像
    @PostMapping("uploadHeadImg")
    public RJ uploadHeadImg(){
        return null;
    }
    //修改个人信息,也没什么好改的。。。
    @PostMapping("alterUserInfo")
    public RJ alterUserInfo(){
        return null;
    }
    //手机号更换，手机号短信验证,Ajax
    @GetMapping("alterUserPhone")
    public RJ alterUserPhone(){
        return null;
    }
    //邮箱更换，邮箱验证,Ajax
    @GetMapping("alterUserMail")
    public RJ alterUserMail(){
        return null;
    }
}
