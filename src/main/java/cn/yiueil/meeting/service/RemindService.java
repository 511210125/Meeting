package cn.yiueil.meeting.service;

/**
 * message 会议通知服务
 * __   __ ____            _  __
 * \ \ / /|_ _| __ __ ___ (_)| |
 * \ V /  | | | || |/ -_)| || |
 * |_|  |___| \_,_|\___||_||_|
 * create by YIueil on time 2020/3/26
 */
public interface RemindService {
    /**
     * 每天检查今日需要通知的用户信息
     */
    public void SchedulingDay();


}