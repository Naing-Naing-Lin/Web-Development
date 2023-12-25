package com.jdc.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "register")
public class Register {

	@EmbeddedId
	private RegisterPk id;
	
	@MapsId("studentId")
	@ManyToOne
	private Student student;
	
	@MapsId("courseId")
	@ManyToOne
	private Course course;
	
	@MapsId("classRoomId")
	@ManyToOne
	private ClassRoom classroom;
}
