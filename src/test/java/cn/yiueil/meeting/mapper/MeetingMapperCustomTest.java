package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.entity.User;
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
@RunWith(SpringRunner.class)
@SpringBootTest
public class MeetingMapperCustomTest {
    @Autowired
    private MeetingMapperCustom meetingMapperCustom;

    @Test
    public void findMeetingByUid() {
    }

    @Test
    public void findRandomUid() {
    }

    @Test
    public void findManageUserListByUid() {
    }

    @Test
    public void findMeetingCustomByUidList() {
        List<User> users = meetingMapperCustom.selectManageUserListByUid(1L);
        System.out.println();
    }

    @Test
    public void findMeetingUserRole() {
        String meetingUserRole = meetingMapperCustom.selectMeetingUserRole(1L, 2L);
        System.out.println(meetingUserRole);
    }
}