package cn.yiueil.meeting.controller;

import cn.yiueil.meeting.dto.MeetingCustom;
import cn.yiueil.meeting.entity.Meeting;
import cn.yiueil.meeting.entity.Remind;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.service.*;
import cn.yiueil.meeting.util.ChineseCharacterUtil;
import cn.yiueil.meeting.vo.GroupVo;
import cn.yiueil.meeting.vo.MeetingVo;
import cn.yiueil.meeting.vo.RJ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
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
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MeetingService meetingService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
    @Autowired
    private LoginService loginService;


    @GetMapping("/showManageUserList")
    public RJ showManageUserList(@RequestParam Long uid){
        Map<Character,List<User>> txl = new HashMap<>();
        for (char i='A';i<'Z';i++){
            txl.put(i,new ArrayList<>());
        }
        txl.put('*',new ArrayList<>());
        try {
            List<User> manageUserByUidList = userService.findManageUserByUidList(uid);
            for (User user : manageUserByUidList){
                Character c = ChineseCharacterUtil.firstPinyin(user.getName());//得到首字母
                if (txl.containsKey(c)){//有则入
                    txl.get(c).add(user);
                }else {
                    txl.put(c,new ArrayList<>());
                    txl.get(c).add(user);
                }
            }
            for (char i='A';i<'Z';i++){
                if (txl.get(i).size()==0)
                     txl.remove(i);
            }
            return new RJ(txl, "成功查询");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     *message 查询用户相关会议,支持条件筛选
     *Create by YIueil
     *time 2019/10/10
     *state

     *参数 [uid, meeting]
     *返还值 cn.yiueil.meeting.vo.RJ

     */
    @GetMapping("/showUserMeetingList")
    public RJ showUserMeetingList(@RequestParam Long uid, Meeting meeting){
        RJ rj = new RJ(400,"查询出错");
        try {
            MeetingCustom meetingCustom = new MeetingCustom();
            BeanUtils.copyProperties(meeting,meetingCustom);
            meetingCustom.setUid(uid);
            List<MeetingVo> meetingList = userService.findMeetingByUidList(meetingCustom);
            rj.setResult(meetingList);
            rj.setMsg("成功执行查询");
            rj.setCode(200);
            return rj;
        } catch (SQLException e) {
            e.printStackTrace();
            return rj;
        }
    }

    /**
     *message 加载用户小组信息
     *Create by YIueil
     *time 2019/10/10
     *state

     *参数 [uid]
     *返还值 cn.yiueil.meeting.vo.RJ

     */
    @GetMapping("/groupLoading")
    public RJ ManageGroupLoading(@RequestParam Long uid){
        try {
            List<GroupVo> groupByUidList = userService.findGroupByUidList(uid);
            return new RJ(groupByUidList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 加载用户创建会议时候的管理小组和管理用户     加急
     * @param uid
     * @return
     */
    @GetMapping("/ManageGroupAndUserLoading")
    public RJ ManageGroupAndUserLoading(@RequestParam Long uid){
        try {
            List<User> userList = userService.findManageUserByUidList(uid);
            List<GroupVo> groupVoList = groupService.findManageGroupList(uid);
            Map<String ,Object> map = new HashMap<>();
            map.put("userList",userList);
            map.put("groupVoList",groupVoList);
            return new RJ(map,"成功查询");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     *message
     *Create by YIueil
     *time 2019/10/10
     *state

     *参数 [uid]
     *返还值 cn.yiueil.meeting.vo.RJ
     */
    @GetMapping("/showUserInfo")
    public RJ showUserInfo(@RequestParam Long uid){
        try {
            User user = userService.findUserInformationByUid(uid);
            return new RJ(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return new RJ(500,"遇到了意料之外的错误");
        }

    }
    //用户上传虚拟头像
    @PostMapping("/uploadAvatarUrl")
    public RJ uploadHeadImg(){
        return null;
    }

    //修改个人信息,通用。。。
    @PostMapping("/alterUserInfo")
    public void alterUserInfo(User user){
        if (user.getId()==null){
            return;
        }
        try {
            userService.modifyUserInformation(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //用户加入小组
    @PostMapping("/joinGroup")
    public RJ joinGroup(@RequestParam Long uid,@RequestParam Long gid){
        try {
            groupService.modifyGroupAddUser(uid,gid);
            return new RJ(200,"成功加入该会议组");
        } catch (SQLException e) {
            e.printStackTrace();
            return new RJ(500,"加入会议组遇到问题");
        }
    }

    //手机号更换提交，手机号短信验证,Ajax
    @GetMapping("/alterUserPhone")
    public RJ alterUserPhone(){
        return null;
    }

    //邮箱更换提交，邮箱验证,Ajax
    @GetMapping("/alterUserMail")
    public void alterUserMail(@RequestParam String newMail,@RequestParam Long uid){
            User user = new User();
            user.setId(uid);
            user.setMail(newMail);
        try {
            userService.modifyUserInformation(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //用户添加提醒方式
    @PostMapping("/addRemind")
    public void addRemind(@RequestParam Long uid,
                          @RequestParam byte of,
                          @RequestParam byte type,
                          @RequestParam boolean enable,
                          @RequestParam Integer param
    ){
        Remind remind = new Remind();
        remind.setRenable(enable);
        remind.setRof(of);
        remind.setRtype(type);
        if (param<=0){
            throw new RuntimeException("时间参数必须是大于0");
        }
        remind.setRparam(param);
        remind.setUid(uid);
        try {
            userService.addRemind(remind);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //用户提醒方式查询
    @GetMapping("/getUserRemindList")
    public RJ getUserRemindList(@RequestParam Long uid){
        List<Remind> remindList = null;
        try {
            remindList = userService.findRemindListByUid(uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new RJ(remindList);
    }

    //用户提醒方式修改
    @PostMapping("/modifyUserRemind")
    public void modifyUserRemind(Remind remind,Long uid){
        try {
            userService.modifyRemindByUid(remind,uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //用户提醒方式删除
    @PostMapping("/delUserRemind")
    public void delUserRemind(@RequestParam Long uid,
                              @RequestParam Long rid){
        try {
            userService.removeRemindByUid(rid,uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
