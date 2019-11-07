package cn.yiueil.meeting.controller;

import cn.yiueil.meeting.entity.Group;
import cn.yiueil.meeting.service.GroupService;
import cn.yiueil.meeting.vo.RJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
 * Create time 2019/9/11
 * message
 */
@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;
    //创建小组
    @PostMapping("/createGroup")
    public RJ createGroup(Long uid, Group group) {
        RJ rj = new RJ();
        try {
            groupService.saveNewGroup(uid,group);
            rj.setMsg("创建成功");
            return rj;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    //一批人加入小组
    @PostMapping("/addUserListToGroup")
    public RJ addUserListToGroup(Long gid, List<Long> uids) {
        try {
            groupService.modifyGroupAddUserList(uids,gid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //小组加入某人
    @PostMapping("/addUserToGroup")
    public RJ createGroup(Long gid, Long uid) {
        try {
            groupService.modifyGroupAddUser(uid,gid);
            return new RJ(200,"成功加入该会议组");
        } catch (SQLException e) {
            e.printStackTrace();
            return new RJ(500,"加入会议组遇到问题");
        }
    }

    //查询小组成员
    @GetMapping("/findGroupOfUser")
    public RJ findGroupOfUser(@RequestParam Long gid){
        RJ rj = new RJ();
        try {
            rj.setResult(groupService.findUserByGidList(gid));
            rj.setMsg("查询成功");
            return rj;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    //设置某人在组中的角色
    @PostMapping("/setRoleOfUserInGroup")
    public RJ setRoleOfUserInGroup(@RequestParam Long uid,
                                   @RequestParam Long gid,
                                   @RequestParam Long handler,
                                   @RequestParam String role) {
        if (!role.equals("owner")&&!role.equals("admin")&&!role.equals("user")){
            return new RJ(40409,"设置了无效权限");
        }

        try {
            if (groupService.roleTest(handler,gid).equals("owner")){
                groupService.modifyGroupUserRole(uid,gid,role);
                return new RJ(200,"设置角色成功");
            }return new RJ(40410,"权限不足");

        } catch (SQLException e) {
            e.printStackTrace();
            return new RJ(500,"加入会议组遇到问题");
        }
    }

    //从小组中t掉某人
    @PostMapping("/dropUserInGroup")
    public RJ dropUserInGroup(@RequestParam Long uid,
                              @RequestParam Long gid,
                              @RequestParam Long handler) {
        try {
                if (groupService.roleTest(handler,gid).equals("owner")){
                    groupService.removeUserInGroup(uid, gid);
                    return new RJ(200,"成功请出小组");
                }else if (groupService.roleTest(handler,gid).equals("admin")&&groupService.roleTest(uid,gid).equals("user")){
                    groupService.removeUserInGroup(uid, gid);
                    return new RJ(200,"成功请出小组");
                }return new RJ(40410,"权限不足");

        } catch (SQLException e) {
            e.printStackTrace();
            return new RJ(500,"请出小组出错,检查该用户是否还在小组中");
        }
    }
    //解散小组
    @PostMapping("/dismissGroup")
    public RJ dismissGroup(@RequestParam Long uid,
                           @RequestParam Long gid){
        try {
            if (groupService.roleTest(uid,gid).equals("owner")){
                //此处应该通知所有小组成员
                groupService.removeGroupByGid(gid);
                return new RJ(200,"成功解散小组");
            }return new RJ(40410,"权限不足");

        } catch (SQLException e) {
            e.printStackTrace();
            return new RJ(500,"解散小组出错,小组可能已经被解散。");
        }
    }
}
