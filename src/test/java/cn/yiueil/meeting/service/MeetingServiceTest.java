package cn.yiueil.meeting.service;

import cn.yiueil.meeting.entity.Meeting;
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
 * create by YIueil on time 2020/3/26
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MeetingServiceTest {
    @Autowired
    MeetingService meetingService;
    @Test
    public void remindQueue() {

    }
}