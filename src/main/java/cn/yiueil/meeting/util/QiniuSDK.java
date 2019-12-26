package cn.yiueil.meeting.util;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * message
 * __   __ ____            _  __
 * \ \ / /|_ _| __ __ ___ (_)| |
 * \ V /  | | | || |/ -_)| || |
 * |_|  |___| \_,_|\___||_||_|
 * create by YIueil on time 2019/11/14
 */
public class QiniuSDK {
    private final static String accessKey = "eVUkAU2tg8_AtcaWLnN2NQBtm8CKWqU7T4t_h1a8";
    private final static String secretKey = "iOtW9RlIzXh9cfcQJEUdsZxDurtfIzE22TkhjQdK";
    private final static String bucket = "repository-wj";

    public static void main(String[] args) {
        System.out.println(getQiniuToken());
    }

    public static String getQiniuToken(){
        StringMap putPolicy = new StringMap();
        Auth auth = Auth.create(accessKey, secretKey);

        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");

        long expireSeconds = 3600;
        return auth.uploadToken(bucket, null, expireSeconds, putPolicy);
    }

}
