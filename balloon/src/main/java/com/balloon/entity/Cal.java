package com.balloon.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import com.balloon.dto.CalDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "schedule")
public class Cal{
	@Id
	@Column(name="schedule_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scheduleId;
	


	@NotNull
	@Column(name="schedule_title")
	private String scheduleTitle;
	

	@NotNull
	@Column(name="schedule_start")
	private LocalDateTime scheduleStart;
	

	@NotNull
	@Column(name="schedule_end")
	private LocalDateTime scheduleEnd;
	

	@NotNull
	@Column(name="emp_name")
	private String empName;
	

	@NotNull
	@Column(name="schedule_memo")
	private String scheduleMemo;
	

	@NotNull
	@Column(name="schedule_location")
	private String scheduleLocation;
	
	
	@JsonIgnore
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_id")
	private Employee empId;
	
	public CalDTO toDTO(Cal calEntity) {
		CalDTO calDTO = CalDTO.builder()
				.scheduleId(calEntity.getScheduleId())
				.scheduleTitle(calEntity.getScheduleTitle())
				.scheduleStart(calEntity.getScheduleStart())
				.scheduleEnd(calEntity.getScheduleEnd())
				.empName(calEntity.getEmpName())
				.scheduleMemo(calEntity.getScheduleMemo())
				.scheduleLocation(calEntity.getScheduleLocation())
				.employee(calEntity.getEmpId())
				.build();
		return calDTO;
	}
	
	public void updateCal(CalDTO calDTO) {
		this.scheduleTitle = calDTO.getScheduleTitle();
		this.scheduleStart = calDTO.getScheduleStart();
		this.scheduleEnd = calDTO.getScheduleEnd();
		this.scheduleMemo = calDTO.getScheduleMemo();
		this.scheduleLocation = calDTO.getScheduleLocation();
	}

}