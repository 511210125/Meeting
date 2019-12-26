package cn.yiueil.meeting.controller;

import cn.yiueil.meeting.util.QiniuSDK;
import cn.yiueil.meeting.vo.RJ;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * message
 * __   __ ____            _  __
 * \ \ / /|_ _| __ __ ___ (_)| |
 * \ V /  | | | || |/ -_)| || |
 * |_|  |___| \_,_|\___||_||_|
 * create by YIueil on time 2019/11/14
 */
@RestController
public class QiniuSDKController {

    @GetMapping("/getQiniuSDKToken")
    public String getQiniuSDKToken(){
        return QiniuSDK.getQiniuToken();
    }

}
