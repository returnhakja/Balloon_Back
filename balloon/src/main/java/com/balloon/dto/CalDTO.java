package com.balloon.dto;

import java.time.LocalDateTime;

import com.balloon.entity.Cal;
import com.balloon.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CalDTO {
	
	private Long scheduleId;
	
	private String scheduleTitle;
	
	private LocalDateTime scheduleStart;
	
	private LocalDateTime scheduleEnd;
	
	private String empName;
	
	private String scheduleMemo;
	
	private String scheduleLocation;
	

	private Employee employee;

	
	public Cal toEntity(CalDTO calDTO) {
		Cal calEntity = Cal.builder()
				.scheduleId(calDTO.getScheduleId())
				.scheduleTitle(calDTO.getScheduleTitle())
				.scheduleStart(calDTO.getScheduleStart())
				.scheduleEnd(calDTO.getScheduleEnd())
				.empName(calDTO.getEmpName())
				.scheduleMemo(calDTO.getScheduleMemo())
				.scheduleLocation(calDTO.getScheduleLocation())
				.empId(calDTO.getEmployee())
				.build();
		return calEntity;
	}
	

	public Employee toEmpId(String empId) {
		Employee employeeId = Employee.builder()
									.empId(empId)
									.build();
		
		return employeeId;
	}
	

}