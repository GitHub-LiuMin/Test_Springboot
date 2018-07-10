package com.bw.bean;

import java.io.Serializable;

/**
 * 
 * <br>Title:TODO 类标题
 * <br>Description:TODO 范围表
 * <br>Author:杨国庆
 * <br>Date:2018年7月9日
 */
public class Range implements Serializable {

  private Integer rid;

  private String rname;

  @Override
  public String toString() {
    return "Range [rid=" + rid + ", rname=" + rname + "]";
  }

  public Integer getRid() {
    return rid;
  }

  public void setRid(Integer rid) {
    this.rid = rid;
  }

  public String getRname() {
    return rname;
  }

  public void setRname(String rname) {
    this.rname = rname;
  }

}
