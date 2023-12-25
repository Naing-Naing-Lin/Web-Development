package com.jdc.entity.dto;

import java.time.LocalDate;

public record StudentCountByClassRoomDto(
		String name,
		LocalDate date,
		Long studentCount) {

}
