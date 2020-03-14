package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.entity.Group;
import cn.yiueil.meeting.entity.User;
import cn.yiueil.meeting.vo.GroupVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class GroupMapperCustomTest {
    @Autowired
    private GroupMapperCustom groupMapperCustom;
    @Test
    public void selectGroupVoByUid() {
        List<GroupVo> groupVos = groupMapperCustom.selectGroupVoByUid(1L);
        System.out.println();
    }

    @Test
    public void selectManageUserByUid() {
        List<User> users = groupMapperCustom.selectManageUserByUid(1L);
        System.out.println();
    }

    @Test
    public void selectGroupVoByCreateUid() {
        List<GroupVo> groupVos = groupMapperCustom.selectGroupVoByCreateUid(5000L);
        System.out.println();
    }

    @Test
    public void findGroup() {
        Group g =new Group();
        g.setName("创建");
        List<GroupVo> group = groupMapperCustom.selectGroupByFilter(g);
        System.out.println();

    }

    @Test
    public void testSelectGroupVoByUid() {
    }

    @Test
    public void testSelectManageUserByUid() {
    }

    @Test
    public void testSelectGroupVoByCreateUid() {
    }

    @Test
    public void selectGroupByFilter() {
    }
}