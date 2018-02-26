package com.alibaba.domain;

public class Task {
    private Integer id;

    private String content;

    private Integer userid;

    private Byte type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }


    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userid=" + userid +
                ", type=" + type +
                '}';
    }
}