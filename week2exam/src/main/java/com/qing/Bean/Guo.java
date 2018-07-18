package com.qing.Bean;

import java.io.Serializable;

/**
 * @program: week2exam
 * @description: 国家类
 * @author: 杨国庆
 * @create：2018-07-16 08:52
 **/

public class Guo implements Serializable{

    private Integer gid;
    private String gname;

    @Override
    public String toString() {
        return "Guo{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                '}';
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }
}
