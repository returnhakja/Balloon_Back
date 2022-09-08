package com.balloon.dto;

import com.balloon.entity.Employee;
import com.balloon.entity.Unit;
import com.balloon.entity.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpResByAdminDTO {

	private String empId;

	private String password;

	private String empName;

	private String position;

	private String responsibility;

	private Float salary;

	private Float commission;

	private String photo;

	private String empBell;

	private Unit unit;

	private UserRole userRoleGrade;

	public Employee toEntity(EmpResByAdminDTO employeeDTO) {
		Employee employeeEntity = Employee.builder().empId(employeeDTO.getEmpId()).password(employeeDTO.getPassword())
				.empName(employeeDTO.getEmpName()).position(employeeDTO.getPosition())
				.responsibility(employeeDTO.getResponsibility()).salary(employeeDTO.getSalary())
				.commission(employeeDTO.getCommission()).photo(employeeDTO.getPhoto()).empBell(employeeDTO.getEmpBell())
				.unit(employeeDTO.getUnit()).userRoleGrade(employeeDTO.getUserRoleGrade()).build();

		return employeeEntity;
	};
}
