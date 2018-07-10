package com.bw.bean;

import java.io.Serializable;

/**
 * 
 * <br>Title:TODO 类标题
 * <br>Description:TODO 动物类
 * <br>Author:杨国庆
 * <br>Date:2018年7月9日
 */
public class Animal implements Serializable {

  private Integer aid;

  private String aname;

  private String weight;

  private String rid;

  private String rname;

  @Override
  public String toString() {
    return "Animal [aid=" + aid + ", aname=" + aname + ", weight=" + weight + ", rid=" + rid + ", rname="
      + rname + "]";
  }

  public Integer getAid() {
    return aid;
  }

  public void setAid(Integer aid) {
    this.aid = aid;
  }

  public String getAname() {
    return aname;
  }

  public void setAname(String aname) {
    this.aname = aname;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public String getRid() {
    return rid;
  }

  public void setRid(String rid) {
    this.rid = rid;
  }

  public String getRname() {
    return rname;
  }

  public void setRname(String rname) {
    this.rname = rname;
  }

}
