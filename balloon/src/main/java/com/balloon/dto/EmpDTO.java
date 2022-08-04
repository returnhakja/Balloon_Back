package com.balloon.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.balloon.entity.UserRole;
import com.balloon.entity.Employee;
import com.balloon.entity.Unit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpDTO {
	
	private String empId;
	
	private String password;		
	
	private String empName;

	private String position;
	
	private String mobile;
	
	private LocalDate hiredate;
	
	private Float salary;
	
	private Float commission;
	
	private String empMail;
	
	private String photo;
	
	private String empBell;
	
	private LocalDate birthday;
	
	private String address;
	
	private String licensePlate;
	
	private String responsibility;
	
	private Unit unit;
	
	private UserRole userRoleGrade;
	
	public Employee toEntity(EmpDTO employeeDTO) {
		Employee employeeEntity = Employee.builder()
									.empId(employeeDTO.getEmpId())
									.password(employeeDTO.getPassword())
									.empName(employeeDTO.getEmpName())
									.position(employeeDTO.getPosition())
									.mobile(employeeDTO.getMobile())
									.hiredate(employeeDTO.getHiredate())
									.salary(employeeDTO.getSalary())
									.commission(employeeDTO.getCommission())
									.empMail(employeeDTO.getEmpMail())
									.photo(employeeDTO.getPhoto())
									.empBell(employeeDTO.getEmpBell())
									.birthday(employeeDTO.getBirthday())
									.address(employeeDTO.getAddress())
									.licensePlate(employeeDTO.getLicensePlate())
									.responsibility(employeeDTO.getResponsibility())
									.unit(employeeDTO.getUnit())
									.userRoleGrade(employeeDTO.getUserRoleGrade())
									.build();
		
		return employeeEntity;
	}
	
	public static EmpDTO of(Employee employee) {
		return  EmpDTO.builder()
				.empId(employee.getEmpId())
				.empName(employee.getEmpName())
				.salary(employee.getSalary())
				.commission(employee.getCommission())
				.unit(employee.getUnit())
				.empBell(employee.getEmpBell())
				.position(employee.getPosition())
				.responsibility(employee.getResponsibility())
				.mobile(employee.getMobile())
				.empMail(employee.getEmpMail())
				.hiredate(employee.getHiredate())
				.build();

	}
	
	
}
