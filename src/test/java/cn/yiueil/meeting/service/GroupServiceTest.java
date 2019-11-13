package cn.yiueil.meeting.service;

import cn.yiueil.meeting.vo.GroupVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * message
 * __   __ ____            _  __
 * \ \ / /|_ _| __ __ ___ (_)| |
 * \ V /  | | | || |/ -_)| || |
 * |_|  |___| \_,_|\___||_||_|
 * create by YIueil on time 2019/11/7
 */
@SpringBootTest
@RunWith(SpringRunner.class)

public class GroupServiceTest {
    @Autowired
    private GroupService groupService;

    @Test
    public void roleTest() throws SQLException {
        String s = groupService.roleTest(1L, 1L);
        System.out.println(s);
    }

    @Test
    public void findManageGroupList()throws SQLException {
        List<GroupVo> manageGroupList = groupService.findManageGroupList(1L);
        System.out.println();
    }

    @Test
    public void findGroup() {

    }

    @Test
    public void findUserByGidList() {
    }

    @Test
    public void findCreateByUserGroupList() {
    }

    @Test
    public void findGroupByUserList() {
    }

    @Test
    public void findGroupInformationByGid() {
    }

    @Test
    public void removeGroupByGid() {
    }

    @Test
    public void saveNewGroup() {
    }

    @Test
    public void modifyGroupInformation() {
    }

    @Test
    public void modifyGroupUserRole() {
    }

    @Test
    public void modifyGroupAddUser() {
    }

    @Test
    public void modifyGroupAddUserList() {
    }

    @Test
    public void removeUserInGroup() {
    }
}