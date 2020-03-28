package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.dto.MeetingRemindCustom;
import cn.yiueil.meeting.entity.MeetingRemind;
import cn.yiueil.meeting.entity.MeetingRemindExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static org.junit.Assert.*;

/**
 * message
 * __   __ ____            _  __
 * \ \ / /|_ _| __ __ ___ (_)| |
 * \ V /  | | | || |/ -_)| || |
 * |_|  |___| \_,_|\___||_||_|
 * create by YIueil on time 2020/3/28
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MeetingRemindMapperCustomTest {
    @Autowired
    private MeetingRemindMapperCustom meetingRemindMapperCustom;

    @Test
    public void selectMeetingRemindDetailListByDay() {
        MeetingRemindExample example = new MeetingRemindExample();
        long current = System.currentTimeMillis();    //当前时间毫秒数
        long zeroT = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();  //今天零点零分零秒的毫秒数
        long endT = zeroT + 24 * 60 * 60 * 1000 - 1;  //今天23点59分59秒的毫秒数 }
        example.createCriteria().andRemindtimeBetween(new Date(zeroT), new Date(endT));
        List<MeetingRemindCustom> meetingRemindList = meetingRemindMapperCustom.selectMeetingRemindDetailListByDay(example);
        System.out.println();

    }
}