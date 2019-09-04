package cn.yiueil.meeting.entity;

import java.util.Date;

public class Meeting {
    private Long id;

    private String title;

    private Date releaseTime;

    private Date startTime;

    private String place;

    private Boolean isover;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Boolean getIsover() {
        return isover;
    }

    public void setIsover(Boolean isover) {
        this.isover = isover;
    }
}