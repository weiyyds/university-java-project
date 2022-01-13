package com.kuang.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Repaired {
    private int id;
    private String dormitoryid;
    private String reason;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private Date submit_time;

    public Repaired() {
    }

    public Repaired(int id, String dormitoryid, String reason, Date submit_time) {
        this.id = id;
        this.dormitoryid = dormitoryid;
        this.reason = reason;
        this.submit_time = submit_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDormitoryid() {
        return dormitoryid;
    }

    public void setDormitoryid(String dormitoryid) {
        this.dormitoryid = dormitoryid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getSubmit_time() {
        return submit_time;
    }

    public void setSubmit_time(Date submit_time) {
        this.submit_time = submit_time;
    }

    @Override
    public String toString() {
        return "Repaired{" +
                "id=" + id +
                ", dormitoryid='" + dormitoryid + '\'' +
                ", reason='" + reason + '\'' +
                ", submit_time=" + submit_time +
                '}';
    }
}
