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
 * EmployeeModel entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity(name="EmployeeModel")
@Table(name="employee")
public class EmployeeModel implements java.io.Serializable {

	// Fields
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="employee_id")
	private Long employeeId;
    
    @Column(name="employee_name")
	private String employeeName;
    
    @Column(name="employee_desc")
	private String employeeDesc;
    
    @ManyToMany(targetEntity=ProjectModel.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},mappedBy="mumbers")
    @JoinTable(name="r_emp_proj")
    @JoinColumn(name="r_proj_id")
	private Set<ProjectModel> projects = new HashSet();

	// Constructors

	/** default constructor */
	public EmployeeModel() {
	}

	/** minimal constructor */
	public EmployeeModel(String employeeName) {
		this.employeeName = employeeName;
	}

	/** full constructor */
	public EmployeeModel(String employeeName, String employeeDesc) {
		this.employeeName = employeeName;
		this.employeeDesc = employeeDesc;
	}

	// Property accessors

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDesc() {
		return this.employeeDesc;
	}

	public void setEmployeeDesc(String employeeDesc) {
		this.employeeDesc = employeeDesc;
	}

	public Set getProjects() {
		return projects;
	}

	public void setProjects(Set projects) {
		this.projects = projects;
	}

}