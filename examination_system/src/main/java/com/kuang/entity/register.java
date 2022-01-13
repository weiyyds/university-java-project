package com.kuang.entity;

public class register {
    private int id;
    private String telNumber;
    private String password;
    private String ID_number;
    private String name;
    private String email;

    public register() {
    }

    public register(int id, String telNumber, String password, String ID_number, String name, String email) {
        this.id = id;
        this.telNumber = telNumber;
        this.password = password;
        this.ID_number = ID_number;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getID_number() {
        return ID_number;
    }

    public void setID_number(String ID_number) {
        this.ID_number = ID_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "register{" +
                "id=" + id +
                ", telNumber=" + telNumber +
                ", password='" + password + '\'' +
                ", ID_number='" + ID_number + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
