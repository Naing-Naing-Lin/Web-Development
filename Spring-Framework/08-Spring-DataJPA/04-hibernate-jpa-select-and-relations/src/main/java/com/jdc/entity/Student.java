package com.jdc.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "student")
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String name;
	private Gender gender;
	@Column(columnDefinition = "varchar(30) check (email != null && email like '%@%')")
	private String email;
	private String contact;
	@Column(columnDefinition = "tinyint(1) default 1")
	private Boolean active;
	

	public enum Gender{
		MALE, FEMALE, OTHER
	}
}
