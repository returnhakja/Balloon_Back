package com.balloon.dto;


import com.balloon.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpResponseDTO {
	
	private String empId;
	
	private String empName;
	
	private String position;
	
	public Employee toEntity(EmpResponseDTO employeeDTO) {
		Employee employeeEntity = Employee.builder()
									.empId(employeeDTO.getEmpId())
									.empName(employeeDTO.getEmpName())
									.position(employeeDTO.getPosition())
									.build();
		
		return employeeEntity;
	}
	
	public static EmpResponseDTO of(Employee employee) {
		return  EmpResponseDTO.builder()
				.empId(employee.getEmpId())
				.empName(employee.getEmpName())
				.position(employee.getPosition())
				.build();

	}
	
	
}
