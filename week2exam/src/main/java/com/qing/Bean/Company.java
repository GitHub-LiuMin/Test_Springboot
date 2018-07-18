package com.qing.Bean;

import java.io.Serializable;

/**
 * @program: week2exam
 * @description: 公司类
 * @author: 杨国庆
 * @create：2018-07-16 08:52
 **/

public class Company implements Serializable{

    private  Integer cid;
    private String cname;
    private String type;

    private String gid;
    private String gname;

    @Override
    public String toString() {
        return "Company{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", type='" + type + '\'' +
                ", gid='" + gid + '\'' +
                ", gname='" + gname + '\'' +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }
}
