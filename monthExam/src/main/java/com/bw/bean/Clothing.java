package com.bw.bean;

import java.io.Serializable;

public class Clothing implements Serializable {

	private Integer cid = null;
	private String cname = null;
	private Double price = null;
	private Integer bid = null;
	private String bname = null;
	@Override
	public String toString() {
		return "Clothing [cid=" + cid + ", cname=" + cname + ", price=" + price + ", bid=" + bid + ", bname=" + bname
				+ "]";
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	
	
}
