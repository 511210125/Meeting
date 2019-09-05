package cn.yiueil.meeting;


import cn.yiueil.meeting.service.IMailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeetingApplicationTests {

    @Autowired
    IMailService mailService;

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }


    @Test
    public void sendmail() {
        mailService.sendSimpleMail("2645763241@qq.com","主题：你好普通邮件","内容：第一封邮件");

    }

    @org.junit.Test
    public void login() throws Exception {
        String responseString = mockMvc.perform(
                post("/loginSubmit")    //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("key","YIueil").param("passwd","257689"))
                .andExpect(status().isOk()).andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串

        System.out.println("--------返回的json = " + responseString);
    }

    @org.junit.Test
    public void rigister() throws Exception {
        String responseString = mockMvc.perform(
                post("/rigisterSubmit")    //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name","test2")
                        .param("mail","test2@mail")
                        .param("phone","test2")
                        .param("passwd","test2")
                        .param("code","test2")
        )
                .andExpect(status().isOk()).andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串

        System.out.println("--------返回的json = " + responseString);
    }

}
