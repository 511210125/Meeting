package cn.yiueil.meeting;


import cn.yiueil.meeting.entity.Login;
import cn.yiueil.meeting.mapper.LoginMapperCustom;
import cn.yiueil.meeting.mapper.PermissionMapperCustom;
import cn.yiueil.meeting.service.MailService;
import cn.yiueil.meeting.util.StringUtil;
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

import java.util.Calendar;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeetingApplicationTests {

    @Autowired
    private MailService mailService;

    @Autowired
    private PermissionMapperCustom permissionMapperCustom;
    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }


    @Test
    public void sendmail() {
        Long l = Long.valueOf(1);
        System.out.println(permissionMapperCustom.selectByPrimaryUserId(l ).contains("use"));

//        mailService.sendSimpleMail("26423424324234325763241@qq.com","智能会议助理","验证码:257689");

    }

    @org.junit.Test
    public void login() throws Exception {
        String responseString = mockMvc.perform(
                post("/loginSubmit")    //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("key","manager").param("passwd","123"))
                .andExpect(status().isOk()).andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串

        System.out.println("--------返回的json = " + responseString);
    }

    @org.junit.Test
    public void rigister() throws Exception {
        try{
            String responseString = mockMvc.perform(
                    post("/rigisterSubmit")    //请求的url,请求的方法是get
                            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                            .param("name","test2")
                            .param("mail","2645763241@mail")
                            .param("phone","18275506742")
                            .param("passwd","test2")
                            .param("code","test2")
            )
                    .andExpect(status().isOk()).andDo(print())         //打印出请求和相应的内容
                    .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串

            System.out.println("--------返回的json = " + responseString);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void manageLogin() throws Exception {
        try{
            String responseString = mockMvc.perform(
                    post("/manageLoginSubmit")    //请求的url,请求的方法是get
                            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                            .param("key","manager")
                            .param("passwd","123")
            )
                    .andExpect(status().isOk()).andDo(print())         //打印出请求和相应的内容
                    .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串

            System.out.println("--------返回的json = " + responseString);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void t() throws Exception {
        String responseString = mockMvc.perform(
                get("/nameCheck")    //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name","YIueill")
        )
                .andExpect(status().isOk()).andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串

        System.out.println("--------返回的json = " + responseString);
    }

    @org.junit.Test
    public void send() throws Exception {
        String responseString = mockMvc.perform(
                post("/sendMail")    //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("mail","2645763241@qq.com")
        )
                .andExpect(status().isOk()).andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串

        System.out.println("--------返回的json = " + responseString);
    }

    @Autowired
    private LoginMapperCustom loginMapperCustom;
    @Test
    public void test(){
        Login login = new Login();
        login.setMail("123");
        String str = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$";
        System.out.println(login.getMail());


//      System.out.println(StringUtil.encode("123"));
    }

}
