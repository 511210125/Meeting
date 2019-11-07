package cn.yiueil.meeting;


import cn.yiueil.meeting.entity.*;
import cn.yiueil.meeting.mapper.*;
import cn.yiueil.meeting.service.*;
import cn.yiueil.meeting.util.StringUtil;
import cn.yiueil.meeting.vo.MeetingVo;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MeetingApplicationTests {
    @Autowired
    private LoginMapper loginMapper;
    @Test
    public void test123() {
        Login login = new Login();
        login.setName("YIueil");
        LoginExample loginExample = new LoginExample();
        loginExample.setDistinct(true);
        Object o=loginMapper.deleteByExample(loginExample);
        System.out.println(o);

        System.out.println();
    }

    @Autowired
    private MeetingMapperCustom meetingMapperCustom;
    @Autowired
    private MeetingService meetingService;



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
                        .param("key","a1").param("passwd","123"))
                .andExpect(status().isOk()).andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串

        System.out.println("--------返回的json = " + responseString);
    }

    @org.junit.Test
    public void register() throws Exception {
        user user ;
        for (int i=0;i<1;i++){
            user = new user();

            try{
                String responseString = mockMvc.perform(
                        post("/registerSubmit")    //请求的url,请求的方法是get
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("name", "user.getName()")
                                .param("mail", "user.getMail()")
                                .param("phone", "user.getPhone()")
                                .param("passwd","123")
                )
                        .andExpect(status().isOk()).andDo(print())         //打印出请求和相应的内容
                        .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串

                System.out.println("--------返回的json = " + responseString);
            }catch (Exception e){
                e.printStackTrace();
            }
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

    @Test
    public void add(){
//        List<MeetingVo> meetingCustomByUidList = meetingMapperCustom.findMeetingCustomByUidList(4213L);
        System.out.println();
    }

    @Test
    public void addUserToGroup() throws Exception {

        String responseString = mockMvc.perform(
                post("/setRoleOfUserInGroup")    //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("gid","8").param("uid","2")
                        .param("handler","1").param("role","admin"))

                .andExpect(status().isOk()).andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串

        System.out.println("--------返回的json = " + responseString);
    }

    @Test
    public void selectMeeting() throws Exception {
        String responseString = mockMvc.perform(
                get("/ManageGroupLoading")    //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("uid","1")
        )

                .andExpect(status().isOk()).andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串

        System.out.println("--------返回的json = " + responseString);
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
                post("/createGroup")    //请求的url,请求的方法是post
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("uid","1")
                        .param("name","这是一个测试小组").param("number", "50")
                        .param("createUser","1")
        )
                .andExpect(status().isOk()).andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串

        System.out.println("--------返回的json = " + responseString);
    }

    @org.junit.Test
    public void userInfoChenge() throws Exception {
        String responseString = mockMvc.perform(
                post("/alterUserInfo")    //请求的url,请求的方法是post
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("id","1")
                        .param("name","我改变我的名字")
                        .param("mail", "@163.com")
                        .param("phone","666")
        )
                .andExpect(status().isOk()).andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串

        System.out.println("--------返回的json = " + responseString);
    }

    @Autowired
    UserMapper userMapper;
    @Autowired
    private PermissionService permissionService;

    @Autowired
    private LoginMapperCustom loginMapperCustom;
    @Autowired
    LoginService loginService;
    @Autowired
    GroupService groupService;

    //插入小组
    @Test
    public void test() throws SQLException {
//        login login;
//        for (int i = 0 ;i<30000;i++){
//            login= new login();
//            loginService.insertUser(login);
//        }
        UserExample userExample =new UserExample();
        userExample.createCriteria().andIdBetween(4000L,5000L);
        List<User> users;

        group g;
        List<Long> longs;
        Long gid;
        for (int i=0;i<300;i++){
            g = new group();

            gid = groupService.saveNewGroup(g.getCreateUser(),g);

            longs = new ArrayList<>();

            users = userMapper.selectByExample(userExample);

            for (int j=0;j<45;j++){
                User user = users.get(new Random().nextInt(users.size()-1));
                if (user.getId()!=g.getCreateUser()&& !longs.contains(user.getId())){
                    longs.add(user.getId());
                }
            }
            groupService.modifyGroupAddUserList(longs,gid);

            for (int z=0;z<7;z++){
                Long l = longs.get(new Random().nextInt(longs.size()));
                groupService.modifyGroupUserRole(l,gid,"admin");
            }

        }




    }

    //插入会议
    @Test
    public void findManageUserListByUid() {
        List<Long> managerIdList = meetingMapperCustom.findRandomUid();
        for (int z=1 ;z<managerIdList.size()-1;z++){
            List<User> manageUserListByUid = meetingMapperCustom.findManageUserListByUid(managerIdList.get(z));
            List<Long> uids =new ArrayList<>();
            int i = new Random().nextInt(manageUserListByUid.size());
            for (int j =0;j<i;j++){
                Long newid = manageUserListByUid.get(new Random().nextInt(manageUserListByUid.size()-1)).getId();
                if (!uids.contains(newid)){
                    uids.add(newid);
                }
            }
            meet meeting = new meet();
            try {
                Long issuer = uids.get(new Random().nextInt(uids.size()));
                Long chair = uids.get(new Random().nextInt(uids.size()));
                Long recorder = uids.get(new Random().nextInt(uids.size()));
                System.out.println(issuer+" "+chair+" "+recorder);
                meetingService.saveReleaseMeeting(meeting,uids,issuer,chair,recorder);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void insertTestMeeting(){

    }

    class login extends Login{
        login(){
            this.setName(getChinaName());
            this.setMail("test"+UUID.randomUUID()+"@qq.com");
            this.setPhone(getChinaPhone());
            this.setPasswd("123");
        }
    }

    class user extends User{
        user(){
            this.name=getChinaName();
            this.mail="test"+UUID.randomUUID()+"@qq.com";
            this.phone=getChinaPhone();
        }
        private Long id;

        private String name;

        private String mail;

        private String phone;

        @Override
        public String toString() {
            return "user{" +
                    "name='" + name + '\'' +
                    ", mail='" + mail + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }
    class meet extends Meeting {
         meet(){
             this.setRemark("请准时到场,严格考勤");
             this.setTitle(this.titles[new Random().nextInt(titles.length)]);
             this.setPlace(this.places[new Random().nextInt(places.length)]);
             this.setReleaseTime(new Date(new Date().getTime()));
             this.setStartTime(new Date(new Date().getTime()+30000000+new Random().nextInt(1000000000)));
        }
        String[] titles ={"遵义会议","山中全会","座谈会","404会议","滑稽大会","娱乐会议","周会","看球会","有道会议","可乐会议"};
        private String[] places ={"北京","天津","上海","重庆","河北","山西","辽宁","吉林",
                "黑龙江","江苏","浙江","安徽","福建","江西","山东","河南","湖北","湖南",
                "广东","海南","四川","贵州","云南","陕西","甘肃","青海","内蒙古","广西",
                "西藏","宁夏","新疆维吾尔自治区","香港","澳门","台湾"};

    }
    class group extends Group{
        group(){
            UserExample userExample =new UserExample();
            userExample.createCriteria().andIdBetween(5000L,6000L);
            List<User> users = userMapper.selectByExample(userExample);
            User user = users.get(new Random().nextInt(users.size()-1));

            this.setNumber(20);

            this.setCreateUser(user.getId())  ;

            this.setName(user.getName() +"创建的小组")  ;

            this.setRemark("这是个自动生成的小组")  ;
            this.setCreateTime(new Date())  ;
        }
        private String coverImg = "http://www.qiniu.yiueil.cn/meeting.png";
    }


    public String getChinaPhone() {
        String number = "11111111111";
        for (int i = 0; i < 9; i++) {//9代表循环九次，产生九个随机号码
            number = "187";//定义电话号码以139开头
            Random random = new Random();//定义random，产生随机数
            for (int j = 0; j < 8; j++) {
                //生成0~9 随机数
                number += random.nextInt(9);
            }
            System.out.println(number);//输出一个电话号码
        }
        
        return number;
    }
    
    public String getChinaName() {
        Random random = new Random();
        String[] Surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
                "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",
                "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷",
                "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和",
                "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
                "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季"};
        String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
        String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
        int index = random.nextInt(Surname.length - 1);
        String name = Surname[index]; //获得一个随机的姓氏
        int i = random.nextInt(3);//可以根据这个数设置产生的男女比例
        if(i==2){
            int j = random.nextInt(girl.length()-2);
            if (j % 2 == 0) {
                name = getRandomString(5) + name + girl.substring(j, j + 2);
            } else {
                name = getRandomString(5) + name + girl.substring(j, j + 1);
            }

        }
        else{
            int j = random.nextInt(girl.length()-2);
            if (j % 2 == 0) {
                name = getRandomString(5) + name + boy.substring(j, j + 2);
            } else {
                name = getRandomString(5) + name + boy.substring(j, j + 1);
            }

        }

        return name;
    }

    public static String getRandomString(int stringLength) {
        String string = "abcdefghijklmnopqrstuvwxyz";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stringLength; i++) {
            int index = (int) Math.floor(Math.random() * string.length());//向下取整0-25
            sb.append(string.charAt(index));
        }
        return sb.toString();
    }
}


