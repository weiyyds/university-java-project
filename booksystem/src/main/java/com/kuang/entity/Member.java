package com.kuang.entity;
import java.io.Serializable;
import java.util.List;

public class Member implements Serializable {
    private String mid;
    private String name;
    private Integer age;
    private Integer sex;
    private String phone;
    private List<Lenbook> Lenbooks;

    public Member(String mid) {
        this.mid = mid;
    }

    public Member(String mid, String name, Integer age, Integer sex, String phone, List<Lenbook> lenbooks) {
        this.mid = mid;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        Lenbooks = lenbooks;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Lenbook> getLenbooks() {
        return Lenbooks;
    }

    public void setLenbooks(List<Lenbook> lenbooks) {
        Lenbooks = lenbooks;
    }

    @Override
    public String toString() {
        return "Member{" +
                "mid='" + mid + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", Lenbooks=" + Lenbooks +
                '}';
    }
}
