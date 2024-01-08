package com.jdc.model.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class User {

	private Integer id;
	private String full_name;
	private int age;
	private String phoneNumber;
	private Genders gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate created_date;
}
