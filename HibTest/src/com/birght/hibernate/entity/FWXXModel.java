package com.birght.hibernate.entity;

import java.util.Date;

import javax.management.loading.PrivateClassLoader;

/**
 * FWXXModel entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class FWXXModel implements java.io.Serializable {

	// Fields

	private Integer fwid;
	private Integer uid;
	private Integer jdid;
	private Integer lxid;
	private Integer shi;
	private Integer ting;
	private String fwxx;
	private Double zj;
	private String title;
	private Date date;
	private String telephone;
	private String lxr;
	private Double zj1;
	private Double zj2;
	private Integer[] lxIds = {};

	// Constructors

	public Double getZj2() {
		return zj2;
	}

	public void setZj2(Double zj2) {
		this.zj2 = zj2;
	}

	public Integer[] getLxIds() {
		return lxIds;
	}

	public void setLxIds(Integer[] lxIds) {
		this.lxIds = lxIds;
	}

	public void setZj1(Double zj1) {
		this.zj1 = zj1;
	}

	public Double getZj1() {
		return this.zj1;
	}

	/** default constructor */
	public FWXXModel() {
	}

	// Property accessors

	public Integer getFwid() {
		return this.fwid;
	}

	public void setFwid(Integer fwid) {
		this.fwid = fwid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getJdid() {
		return this.jdid;
	}

	public void setJdid(Integer jdid) {
		this.jdid = jdid;
	}

	public Integer getLxid() {
		return this.lxid;
	}

	public void setLxid(Integer lxid) {
		this.lxid = lxid;
	}

	public Integer getShi() {
		return this.shi;
	}

	public void setShi(Integer shi) {
		this.shi = shi;
	}

	public Integer getTing() {
		return this.ting;
	}

	public void setTing(Integer ting) {
		this.ting = ting;
	}

	public String getFwxx() {
		return this.fwxx;
	}

	public void setFwxx(String fwxx) {
		this.fwxx = fwxx;
	}

	public Double getZj() {
		return this.zj;
	}

	public void setZj(Double zj) {
		this.zj = zj;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLxr() {
		return this.lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

}