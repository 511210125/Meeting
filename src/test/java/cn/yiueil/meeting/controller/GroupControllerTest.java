package cn.yiueil.meeting.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
public class GroupControllerTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMVC;
    @Before
    public void initMockMvc() {
        mockMVC= MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void createGroup()throws Exception {
        String responseString = mockMVC.perform(
                post("/createGroup")    //请求的url,请求的方法
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("uid","1")
                        .param("name","测试用")
                        .param("number","40")
                        .param("coverImg","")
                        .param("createUser","1")
                        .param("remark","")

        )
                .andExpect(status().isOk()).andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
        System.out.println("--------返回的json = " + responseString);
    }

    @Test
    public void addUserListToGroup()throws Exception  {
        String responseString = mockMVC.perform(
                post("/addUserListToGroup")    //请求的url,请求的方法
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("gid","1086").param("uids","2,3,4")
        )
                .andExpect(status().isOk()).andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
        System.out.println("--------返回的json = " + responseString);
    }

    @Test
    public void testCreateGroup() {
    }

    @Test
    public void findGroupOfUser() {
    }

    @Test
    public void setRoleOfUserInGroup() {
    }

    @Test
    public void dropUserInGroup() {
    }

    @Test
    public void dismissGroup() {
    }
}