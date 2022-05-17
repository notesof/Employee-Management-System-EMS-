package com.capg.employeemanagementsystem.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employee
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int userId;
private String firstname;
private String lastname;
private Date dob;
private String email;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "ed_fk", referencedColumnName="departId")
private Department department;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "ep_fk", referencedColumnName="projId")
private Project project;


private String username; 

@NotBlank(message = "Password is mandatory")
@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$", message="Password must contain a lowercase character, "
                                    + "a uppercase character and a digit, minimum length must be 6 characters")
private String password;



}