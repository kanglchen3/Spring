package com.kangle.domain;

import java.util.List;

public class VO {
    private List<User> userList;

    public List<User> getVo() {
        return userList;
    }

    public void setVo(List<User> vo) {
        this.userList = vo;
    }

    @Override
    public String toString() {
        return "VO{" +
                "vo=" + userList +
                '}';
    }
}
