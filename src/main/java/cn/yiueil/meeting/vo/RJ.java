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
        this.result = result;
        this.msg=msg;
    }

    /**
     * 输出错误和错误信息
     * @param code
     * @param msg
     */
    public RJ(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    private Object result;
    private String msg;
    private int code = 200;       //错误编号,默认为正常200

    private String token = null;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
