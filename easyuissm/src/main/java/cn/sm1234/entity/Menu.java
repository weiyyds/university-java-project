package cn.sm1234.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Menu {
    private int id;
    @JsonProperty(value = "text")
    private String name;
    private int pwd;
    //这里是一个额外属性
   /* @JsonProperty("attributes")
    private String fileName;*/
    //如果有多个属性
    private String fileName;
    private Attributes attributes;
    private List<Menu> children;
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
