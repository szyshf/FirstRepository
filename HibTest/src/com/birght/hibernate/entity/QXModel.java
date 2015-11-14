package com.birght.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * QXModel entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class QXModel implements java.io.Serializable {

	// Fields

	private Integer qxid;
	private String qx;
	private Set jds = new HashSet();

	// Constructors

	/** default constructor */
	public QXModel() {
	}

	/** full constructor */
	public QXModel(String qx) {
		this.qx = qx;
	}

	// Property accessors

	public Integer getQxid() {
		return this.qxid;
	}

	public void setQxid(Integer qxid) {
		this.qxid = qxid;
	}

	public String getQx() {
		return this.qx;
	}

	public void setQx(String qx) {
		this.qx = qx;
	}

	public Set getJds() {
		return jds;
	}

	public void setJds(Set jds) {
		this.jds = jds;
	}

}