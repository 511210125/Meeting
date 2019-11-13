package cn.yiueil.meeting.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

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
public class MeetingControllerTest {
    @Autowired
    WebApplicationContext context;

    private MockMvc mockMVC;

    @Before
    public void initMockMvc() {
        mockMVC= MockMvcBuilders.webAppContextSetup(context).build();
    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void releaseMeetingSubmit() {
        System.out.println("hello world");
    }

    @Test
    public void cancelledMeetingSubmit() {

    }

    @Test
    public void meetingPostponed() {

    }

    @Test
    public void meetingStart() {

    }

    @Test
    public void audioFileUpload() {

    }
}