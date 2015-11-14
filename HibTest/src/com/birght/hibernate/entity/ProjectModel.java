package com.birght.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * ProjectModel entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity(name="ProjectModel")
@Table(name="project")
public class ProjectModel implements java.io.Serializable {

	// Fields
    @Id
    @Column(name="project_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long projectId;
    
    @Column(name="project_name")
	private String projectName;
    
    @Column(name="project_desc")
	private String projectDesc;

    @ManyToMany(targetEntity=EmployeeModel.class,cascade=CascadeType.ALL)
    @JoinTable(name="r_emp_proj")
    @JoinColumn(name="r_proj_id")
	private Set<EmployeeModel> mumbers = new HashSet();

	// Constructors

	/** default constructor */
	public ProjectModel() {
	}

	/** minimal constructor */
	public ProjectModel(String projectName) {
		this.projectName = projectName;
	}

	/** full constructor */
	public ProjectModel(String projectName, String projectDesc) {
		this.projectName = projectName;
		this.projectDesc = projectDesc;
	}

	// Property accessors

	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDesc() {
		return this.projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public Set getMumbers() {
		return mumbers;
	}

	public void setMumbers(Set mumbers) {
		this.mumbers = mumbers;
	}

}