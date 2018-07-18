package com.qing.Bean;

/**
 * @program: week2exam
 * @description: 中间表
 * @author: 杨国庆
 * @create：2018-07-16 08:53
 **/

public class C_G {
    private Integer cid;
    private Integer gid;

    @Override
    public String toString() {
        return "C_G{" +
                "cid=" + cid +
                ", gid=" + gid +
                '}';
    }

    public Integer getCid() {

        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }
}
