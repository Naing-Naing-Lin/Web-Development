package com.jdc.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class RegisterPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "student_id")
	private int studentId;
	@Column(name = "course_id")
	private int courseId;
	@Column(name = "classRoom_id")
	private int classRoomId;
	
}
