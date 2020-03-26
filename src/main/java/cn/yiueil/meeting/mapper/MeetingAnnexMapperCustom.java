package cn.yiueil.meeting.mapper;

import cn.yiueil.meeting.dto.MeetingFile;
import cn.yiueil.meeting.entity.MeetingAnnex;
import cn.yiueil.meeting.entity.MeetingAnnexExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MeetingAnnexMapperCustom extends MeetingAnnexMapper {
    @Select("SELECT\n" +
            "  `t_meeting_annex`.`file_url` AS url,\n" +
            "  `t_meeting_annex`.`id` AS id,\n" +
            "  `t_meeting_annex`.`name` AS name,\n" +
            "  `t_meeting_annex`.type AS type\n" +
            "FROM\n" +
            "  `t_meeting_annex`\n" +
            "WHERE MID= #{mid}")
    List<MeetingFile> selectMeetingFileListByMid(Long mid);
}