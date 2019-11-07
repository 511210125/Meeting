package cn.yiueil.meeting.entity;

public class MeetingUser extends MeetingUserKey {
    private String mrole;

    private String status;

    public String getMrole() {
        return mrole;
    }

    public void setMrole(String mrole) {
        this.mrole = mrole == null ? null : mrole.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}