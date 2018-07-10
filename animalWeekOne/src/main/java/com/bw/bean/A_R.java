package com.bw.bean;

import java.io.Serializable;

/**
 * 
 * <br>Title:TODO 类标题
 * <br>Description:TODO 动物和范围的中间表
 * <br>Author:杨国庆
 * <br>Date:2018年7月9日
 */
public class A_R implements Serializable {

  private Integer aid;

  private Integer rid;

  @Override
  public String toString() {
    return "A_R [aid=" + aid + ", rid=" + rid + "]";
  }

  public Integer getAid() {
    return aid;
  }

  public void setAid(Integer aid) {
    this.aid = aid;
  }

  public Integer getRid() {
    return rid;
  }

  public void setRid(Integer rid) {
    this.rid = rid;
  }

}
