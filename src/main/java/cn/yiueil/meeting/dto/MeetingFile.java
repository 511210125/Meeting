package cn.yiueil.meeting.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * message
 * __   __ ____            _  __
 * \ \ / /|_ _| __ __ ___ (_)| |
 * \ V /  | | | || |/ -_)| || |
 * |_|  |___| \_,_|\___||_||_|
 * create by YIueil on time 2020/3/14
 */
@Getter
@Setter

public class MeetingFile {
    private String name;
    private String status;
    private String uid;
    private String url;
}
