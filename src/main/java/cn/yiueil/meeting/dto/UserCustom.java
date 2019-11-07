package cn.yiueil.meeting.dto;

import cn.yiueil.meeting.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCustom extends User {
    private String msg;
    private String mrole;
    private String status;

}