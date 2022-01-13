package com.kuang.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Admin {
    private int aid;
    private String name;

    private String password;

    private Timestamp lastdate;

    private int flag;

    private int status;

    public Admin() {
    }

    public Admin(int aid, String name, String password, Timestamp lastdate, int flag, int status) {
        this.aid = aid;
        this.name = name;
        this.password = password;
        this.lastdate = lastdate;
        this.flag = flag;
        this.status = status;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastdate() {
        return lastdate;
    }

    public void setLastdate(Timestamp lastdate) {
        this.lastdate = lastdate;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", lastdate=" + lastdate +
                ", flag=" + flag +
                ", status=" + status +
                '}';
    }
}
