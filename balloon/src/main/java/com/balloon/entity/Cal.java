package com.balloon.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.balloon.dto.CalDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cal{
	@Id
	@Column(name="schedule_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scheduleId;
	
	@Column(name="schedule_title")
	private String scheduleTitle;
	
	@Column(name="schedule_start")
	private LocalDateTime scheduleStart;
	
	@Column(name="schedule_end")
	private LocalDateTime scheduleEnd;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="schedule_memo")
	private String scheduleMemo;
	
	@Column(name="schedule_location")
	private String scheduleLocation;
	
	@Column(name="emp_id")
	private String empId;
	
	public CalDTO toDTO(Cal calEntity) {
		CalDTO calDTO = CalDTO.builder()
				.scheduleId(calEntity.getScheduleId())
				.scheduleTitle(calEntity.getScheduleTitle())
				.scheduleStart(calEntity.getScheduleStart())
				.scheduleEnd(calEntity.getScheduleEnd())
				.empName(calEntity.getEmpName())
				.scheduleMemo(calEntity.getScheduleMemo())
				.scheduleLocation(calEntity.getScheduleLocation())
				.empId(calEntity.getEmpId())
				.build();
		return calDTO;
	}
}
