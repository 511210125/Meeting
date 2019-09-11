package cn.yiueil.meeting.dto;

import cn.yiueil.meeting.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCustom extends User {
    public UserCustom(String msg){
        this.msg=msg;
    }
    private String msg;

}