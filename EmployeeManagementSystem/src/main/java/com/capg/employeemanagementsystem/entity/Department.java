package com.capg.employeemanagementsystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import lombok.Data;

@Entity @Data
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int departId;
	private String departName;
	
	
	@OneToMany(targetEntity = Project.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "DepartID_fk", referencedColumnName="departId")
	private List<Project> list;

}