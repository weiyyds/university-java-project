package com.kuang.pojo;

public class Register {
    private int id;
    private String sname;
    private String password;
    private String sphone;
    private String email;
    private String sno;

    public Register() {
    }

    public Register(int id, String sname, String password, String sphone, String email, String sno) {
        this.id = id;
        this.sname = sname;
        this.password = password;
        this.sphone = sphone;
        this.email = email;
        this.sno = sno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @Override
    public String toString() {
        return "Register{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", password='" + password + '\'' +
                ", sphone='" + sphone + '\'' +
                ", email='" + email + '\'' +
                ", sno='" + sno + '\'' +
                '}';
    }
}
