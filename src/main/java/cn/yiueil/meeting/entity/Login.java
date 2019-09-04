package cn.yiueil.meeting.entity;

public class Login {
    private Long id;

    private String name;

    private String mail;

    private String phone;

    private String passwd;

    private Boolean islogin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Boolean getIslogin() {
        return islogin;
    }

    public void setIslogin(Boolean islogin) {
        this.islogin = islogin;
    }
}