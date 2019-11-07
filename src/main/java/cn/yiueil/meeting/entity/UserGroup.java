package cn.yiueil.meeting.entity;

public class UserGroup extends UserGroupKey {
    private String urole;

    public String getUrole() {
        return urole;
    }

    public void setUrole(String urole) {
        this.urole = urole == null ? null : urole.trim();
    }
}