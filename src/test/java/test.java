import cn.yiueil.meeting.util.StringUtil;

import java.util.Date;

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
 * Create time 2019/9/4
 * message
 */
public class test {
    public static void main(String[] args) {

        func func=new func();
        func.fun(new userCustom());

    }
}
class func{
    void fun(user user){
        userCustom userCustom= (userCustom) user;
        System.out.println(userCustom);
    }
}


class user{
    String name ="张三";

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                '}';
    }
}
class userCustom extends user{
    String sex ="男";

    @Override
    public String toString() {
        return "userCustom{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}