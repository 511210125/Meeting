package cn.yiueil.meeting.vo;

import lombok.Getter;
import lombok.Setter;

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
 * message Return JSON
 */
@Getter
@Setter
public class RJ {
    /**
     * 全部手动设置
     */
    public RJ() {}

    /**
     * 只返回结果,信息默认
     * @param result
     */
    public RJ(Object result){
        this.result=result;
    }

    /**
     * 正常返回结果和信息
     * @param result
     * @param msg
     */
    public RJ(Object result,String msg){
        this.msg=msg;
    }

    /**
     * 输出错误和错误信息
     * @param code
     * @param msg
     */
    public RJ(int code,String msg){
        code = this.code;
        msg = this.msg;
    }

    private Object result;
    private String msg;
    private int code = 200;       //错误编号,默认为正常200

    private String token = null;
}
