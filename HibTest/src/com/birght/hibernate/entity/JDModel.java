package com.birght.hibernate.entity;

/**
 * JDModel entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JDModel implements java.io.Serializable {

	// Fields

	private Integer jdid;
	private String jd;
	private Integer qxid;
	private QXModel qx;

	// Constructors

	/** default constructor */
	public JDModel() {
	}

	/** minimal constructor */
	public JDModel(Integer qxid) {
		this.qxid = qxid;
	}

	/** full constructor */
	public JDModel(String jd, Integer qxid) {
		this.jd = jd;
		this.qxid = qxid;
	}

	// Property accessors

	public Integer getJdid() {
		return this.jdid;
	}

	public void setJdid(Integer jdid) {
		this.jdid = jdid;
	}

	public String getJd() {
		return this.jd;
	}

	public void setJd(String jd) {
		this.jd = jd;
	}

	public Integer getQxid() {
		return this.qxid;
	}

	public void setQxid(Integer qxid) {
		this.qxid = qxid;
	}

	public QXModel getQx() {
		return qx;
	}

	public void setQx(QXModel qx) {
		this.qx = qx;
	}

}